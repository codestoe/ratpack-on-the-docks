import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get {
            render 'WHADDAYOU WANT?'
        }
        get('argument') {
            redirect 302, 'http://localhost:5051'
        }
    }
}