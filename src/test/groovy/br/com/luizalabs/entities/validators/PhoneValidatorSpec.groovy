package br.com.luizalabs.entities.validators

import spock.lang.Specification

class PhoneValidatorSpec extends Specification {

    def PHONE_VALIDATOR = new PhoneValidator()

    void 'test a valid cellphone number'() {
        def cellphoneNumber = "11994192222"

        expect:
        PHONE_VALIDATOR.isValid(cellphoneNumber)
    }

    void 'test a invalid cellphone number without DDD'() {
        def cellphoneNumber = "944192222"

        expect:
        !PHONE_VALIDATOR.isValid(cellphoneNumber)
    }
}
