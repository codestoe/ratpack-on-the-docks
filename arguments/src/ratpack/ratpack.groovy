import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get {
            render 'Hello'
        }
        get('argument') {
            render "I've told you once"
        }
    }
}