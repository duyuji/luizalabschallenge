package br.com.luizalabs.entities

import spock.lang.Specification

class PhoneValidatorSpec extends Specification {

    def PHONE_VALIDATOR = new PhoneValidator();

    void 'test a valid cellphone number'() {
        def cellphoneNumber = "11994192222"

        expect:
        true == PHONE_VALIDATOR.isValid(cellphoneNumber)
    }

    void 'test a valid phone number'() {
        def cellphoneNumber = "1144192222"

        expect:
        true == PHONE_VALIDATOR.isValid(cellphoneNumber)
    }

    void 'test a invalid phone number'() {
        def cellphoneNumber = "11444192222"

        expect:
        false == PHONE_VALIDATOR.isValid(cellphoneNumber)
    }

    void 'test a invalid phone number without DDD'() {
        def cellphoneNumber = "44192222"

        expect:
        false == PHONE_VALIDATOR.isValid(cellphoneNumber)
    }

    void 'test a invalid cellphone number without DDD'() {
        def cellphoneNumber = "944192222"

        expect:
        false == PHONE_VALIDATOR.isValid(cellphoneNumber)
    }
}
