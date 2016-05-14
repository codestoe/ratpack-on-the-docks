import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get {
            render 'Hello'
        }
        get('argument') {
            redirect 302, 'http://localhost'
        }
    }
}