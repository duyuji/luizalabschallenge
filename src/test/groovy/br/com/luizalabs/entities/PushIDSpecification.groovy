package br.com.luizalabs.entities

import spock.lang.Specification

class PushIDSpecification extends Specification {
    def PUSH_ID_VALIDATOR = new PushIDValidator();

    def 'test a valid push id'() {
        def pushID = "1"

        expect:
        true == PUSH_ID_VALIDATOR.isValid(pushID);
    }

    def 'test a invalid push id'() {
        def pushID = ""

        expect:
        false == PUSH_ID_VALIDATOR.isValid(pushID);
    }
}
