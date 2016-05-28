import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get {
            render 'WHADDAYOU WANT?'
        }
        get('argument') {
            def argumentNodes = System.getenv('ARGUMENT_NODES')
            println "Found the following argument nodes: $argumentNodes"
            def splitArgumentNodes = argumentNodes.split(',')
            def nodeToPick = new Random().nextInt(splitArgumentNodes.size())
            def nodeUrl = splitArgumentNodes[nodeToPick]
            println "Picked node: $nodeUrl"
            render nodeUrl
        }
    }
}