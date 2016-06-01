import groovy.json.JsonSlurper

import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get {
            render 'WHADDAYOU WANT?'
        }
        get('argument') {
            def argumentNode = getArgumentNode()
            render argumentNode
        }
    }
}

String getArgumentNode() {
    def consulResponse = new JsonSlurper().parse(new URL('http://192.168.99.100:8500/v1/catalog/service/arguments'))
    def firstService = consulResponse.first()
    "http://${firstService.Address}:${firstService.ServicePort}"
}