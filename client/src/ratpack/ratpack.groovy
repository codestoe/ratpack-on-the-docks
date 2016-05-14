import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get('argument') {
            render "I've told you once"
        }
    }
}