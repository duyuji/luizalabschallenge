package br.com.luizalabs.entities

import spock.lang.Specification

class AnnouncementTypeEntitySpecification extends Specification {

    def 'test a valid email announcement type'() {
        def email = 'eduardo.custodio@gmail.com'

        expect:
        AnnouncementType.EMAIL.validator.isValid(email)
    }

    def 'test a invalid email announcement type'() {
        def email = '.custodio@gmail.com'

        expect:
        !AnnouncementType.EMAIL.validator.isValid(email)
    }

    def 'test a valid sms announcement type'() {
        def phone = '11944445555'

        expect:
        AnnouncementType.SMS.validator.isValid(phone)
    }

    def 'test a invalid sms announcement type'() {
        def phone = '944445555'

        expect:
        !AnnouncementType.SMS.validator.isValid(phone)
    }

    def 'test a valid push announcement type'() {
        def phone = '11944445555'

        expect:
        AnnouncementType.PUSH.validator.isValid(phone)
    }

    def 'test a invalid push announcement type'() {
        def phone = '11944445555'

        expect:
        AnnouncementType.PUSH.validator.isValid(phone)
    }

    def 'test a valid whatsapp announcement type'() {
        def phone = '11944445555'

        expect:
        AnnouncementType.WHATSAPP.validator.isValid(phone)
    }

    def 'test a invalid whatsapp announcement type'() {
        def phone = '944445555'

        expect:
        !AnnouncementType.WHATSAPP.validator.isValid(phone)
    }
}
