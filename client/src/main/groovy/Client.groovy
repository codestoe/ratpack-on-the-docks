@Grab(group = 'org.codehaus.groovy.modules.http-builder',
        module = 'http-builder', version = '0.7')

import groovyx.net.http.HTTPBuilder

/**
 * Created by noam on 5/22/16.
 */

String secretaryNode = System.getenv('SECRETARY_NODE')
println "Client: Hello"
def secretaryClient = new HTTPBuilder(secretaryNode)
secretaryClient.get([:]) { resp, reader ->
    assert resp.status == 200

    println "Secretary: ${reader.text}"
    askSecretaryForArgument(secretaryClient)
}

void askSecretaryForArgument(secretaryClient) {
    println "Client: an argument please"
    secretaryClient.get(path: '/argument') { resp, reader ->
        assert resp.status == 200
        def doctorUrl = reader.text
        println "Secretary: Here you go - ${doctorUrl}"
        println "Client: Thank you"

        goToDoctor(doctorUrl);
    }
}

void goToDoctor(doctorUrl) {
    println "Client: Hello"
    def doctorClient = new HTTPBuilder(doctorUrl)
    doctorClient.get([:]) { resp, reader ->
        assert resp.status == 200

        def doctorsGreeting = reader.text
        println "Doctor: ${doctorsGreeting}"
        askDoctorForArgument(doctorClient)
    }
}

void askDoctorForArgument(doctorClient) {
    println "Client: Is this arguments?"
    doctorClient.get(path: '/argument') { resp, reader ->
        assert resp.status == 200
        def doctorsResponse = reader.text
        println "Doctor: $doctorsResponse"

        if (doctorsResponse.startsWith('http')) {
            goToDoctor(doctorsResponse);
        }
    }
}