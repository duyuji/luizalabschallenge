package br.com.luizalabs.repositories


import br.com.luizalabs.entities.AnnouncementType
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class AnnouncementRepositorySpec extends Specification {

    @Inject
    AnnouncementRepository announcementRepository;

    def 'test save a valid Announcement'() {
        def sms = AnnouncementEntity.builder()
                .type(AnnouncementType.SMS)
                .destinatary("11994196292")
                .message("A test message")
                .build()

        def email = AnnouncementEntity.builder()
                .type(AnnouncementType.EMAIL)
                .destinatary("eduardo@gmail.com")
                .message("A test message")
                .build()

        def push = AnnouncementEntity.builder()
                .type(AnnouncementType.PUSH)
                .destinatary("1")
                .message("A test message")
                .build()

        def whatsapp = AnnouncementEntity.builder()
                .type(AnnouncementType.WHATSAPP)
                .destinatary("11994196262")
                .message("A test message")
                .build()

        when:
        announcementRepository.save(entity)

        expect:
        noExceptionThrown()

        where:
        uentity << [sms, email, push, whatsapp]
    }

    def 'test save a invalid Announcement without destinatary'() {
        def withoutDestinatry = AnnouncementEntity.builder()
                .type(AnnouncementType.WHATSAPP)
                .message("A test message")
                .build()

        def withoutMessage = AnnouncementEntity.builder()
                .type(AnnouncementType.WHATSAPP)
                .destinatary("11994196262")
                .build()

        def withoutType = AnnouncementEntity.builder()
                .destinatary("11994196262")
                .message("A test message")
                .build()

        when:
        announcementRepository.save(entity)

        then:
        Exception

        where:
        entity << [withoutDestinatry, withoutMessage, withoutType]
    }
}
