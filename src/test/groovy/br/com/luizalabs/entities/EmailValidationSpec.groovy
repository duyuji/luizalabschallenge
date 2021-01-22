package br.com.luizalabs.entities

import spock.lang.Specification

class EmailValidationSpec extends Specification {

    def EMAIL_VALIDATOR = new EmailValidator();

    void 'test a valid email'() {
        def email = 'eduardocustodio@gmail.com'

        expect:
        true == EMAIL_VALIDATOR.isValid(email)
    }

    void 'test a valid email with .'() {
        def email = 'eduardo.custodio@gmail.com'

        expect:
        true == EMAIL_VALIDATOR.isValid(email)
    }

    void 'test a valid email with _'() {
        def email = 'eduardo_custodio@gmail.com'

        expect:
        true == EMAIL_VALIDATOR.isValid(email)
    }

    void 'test a valid email with _ at the beginning'() {
        def email = '_custodio@gmail.com'

        expect:
        true == EMAIL_VALIDATOR.isValid(email)
    }

    void 'test a valid email with . at the beginning'() {
        def email = '.custodio@gmail.com'

        expect:
        true == EMAIL_VALIDATOR.isValid(email)
    }

    void 'test a invalid email with @ at the beginning'() {
        def email = '@custodio@gmail.com'

        expect:
        false == EMAIL_VALIDATOR.isValid(email)
    }


}
