import static ratpack.groovy.Groovy.ratpack

ratpack {
    serverConfig {
        port(System.getProperty('PORT').toInteger())
    }
    handlers {
        get {
            render 'Hello'
        }
        get('argument') {
//            def argumentNodes = System.getProperty('ARGUMENT_NODES')
            def argumentNodes = System.getProperty('ABUSE_NODES')
            println "Found the following argument nodes: $argumentNodes"
            def splitArgumentNodes = argumentNodes.split(',')
            def nodeToPick = new Random().nextInt(splitArgumentNodes.size())
            def nodeUrl = splitArgumentNodes[nodeToPick]
            println "Picked node: $nodeUrl"
            render nodeUrl
        }
    }
}