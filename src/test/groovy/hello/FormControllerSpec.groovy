package hello

import spock.lang.Specification

class FormControllerSpec extends Specification {

    def "freePorn controller test" () {
        given:
            def controller = new FormController()
            def result = controller.getImage1()

        expect:
            result != null
    }

}
