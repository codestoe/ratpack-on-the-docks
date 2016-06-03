import groovy.json.JsonSlurper

/**
 * Created by noam on 5/22/16.
 */

def secretaryNode = getSecretaryNode()
println "Secretary node: $secretaryNode"
println "Client: Hello"
def secretaryResponse = secretaryNode.toURL().text
println "Secretary: ${secretaryResponse}"

println "Client: an argument please"
def doctorUrl = "$secretaryNode/argument".toURL().text
println "Secretary: Here you go - ${doctorUrl}"
println "Client: Thank you"

goToDoctor(doctorUrl);

void goToDoctor(doctorUrl) {
    println "Client: Hello"
    def doctorsGreeting = doctorUrl.toURL().text
    println "Doctor: ${doctorsGreeting}"
    askDoctorForArgument(doctorUrl)
}

void askDoctorForArgument(doctorUrl) {
    println "Client: Is this arguments?"
    def doctorsResponse = "$doctorUrl/argument".toURL().text
    println "Doctor: $doctorsResponse"

    if (doctorsResponse.startsWith('http')) {
        goToDoctor(doctorsResponse);
    } else {
        println "Client: No you haven't, etc."
    }
}

String getSecretaryNode() {
    def consulResponse = 'http://192.168.99.100:8500/v1/catalog/service/secretary'.toURL().text
    def secretaryServices = new JsonSlurper().parseText(consulResponse)
    def firstService = secretaryServices.first()
    "http://${firstService.Address}:${firstService.ServicePort}"
}