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
            render "I've told you once"
        }
    }
}