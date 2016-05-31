@Grab(group = 'org.codehaus.groovy.modules.http-builder',
        module = 'http-builder', version = '0.7')

import groovyx.net.http.HTTPBuilder

/**
 * Created by noam on 5/22/16.
 */

String secretaryNode = System.getenv('SECRETARY_NODE')
println "Client: Hello"
def secretaryClient = new HTTPBuilder(secretaryNode)
def secretaryResponse = secretaryClient.get([:]).text
println "Secretary: ${secretaryResponse}"

println "Client: an argument please"
def doctorUrl = secretaryClient.get(path: '/argument').text
println "Secretary: Here you go - ${doctorUrl}"
println "Client: Thank you"

goToDoctor(doctorUrl);

void goToDoctor(doctorUrl) {
    println "Client: Hello"
    def doctorClient = new HTTPBuilder(doctorUrl)
    def doctorsGreeting = doctorClient.get([:]).text
    println "Doctor: ${doctorsGreeting}"
    askDoctorForArgument(doctorClient)
}

void askDoctorForArgument(doctorClient) {
    println "Client: Is this arguments?"
    def doctorsResponse = doctorClient.get(path: '/argument').text
    println "Doctor: $doctorsResponse"

    if (doctorsResponse.startsWith('http')) {
        goToDoctor(doctorsResponse);
    } else {
        println "Client: No you haven't, etc."
    }
}