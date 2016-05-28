import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get {
            render 'Hello'
        }
        get('argument') {
//            def argumentNodes = System.getenv('ARGUMENT_NODES')
            def argumentNodes = System.getenv('ABUSE_NODES')
            println "Found the following argument nodes: $argumentNodes"
            def splitArgumentNodes = argumentNodes.split(',')
            def nodeToPick = new Random().nextInt(splitArgumentNodes.size())
            def nodeUrl = splitArgumentNodes[nodeToPick]
            println "Picked node: $nodeUrl"
            render nodeUrl
        }
    }
}