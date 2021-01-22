package br.com.luizalabs.repositories


import br.com.luizalabs.repositories.entities.AnnouncementEntity
import br.com.luizalabs.repositories.entities.AnnouncementTypeEntity
import io.micronaut.data.exceptions.DataAccessException
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class AnnouncementRepositorySpec extends Specification {

    @Inject
    AnnouncementRepository announcementRepository;

    def 'test save a valid Announcement'() {
        when:
        announcementRepository.save(entity)

        then:
        noExceptionThrown()

        where:
        entity << [AnnouncementEntity.builder()
                           .type(AnnouncementTypeEntity.SMS)
                           .destinatary("11994196292")
                           .message("A test message")
                           .build(),
                   AnnouncementEntity.builder()
                           .type(AnnouncementTypeEntity.EMAIL)
                           .destinatary("eduardo@gmail.com")
                           .message("A test message")
                           .build(),
                   AnnouncementEntity.builder()
                           .type(AnnouncementTypeEntity.PUSH)
                           .destinatary("1")
                           .message("A test message")
                           .build(),
                   AnnouncementEntity.builder()
                           .type(AnnouncementTypeEntity.WHATSAPP)
                           .destinatary("11994196262")
                           .message("A test message")
                           .build()]
    }

    def 'test save a invalid Announcement without destinatary'() {
        when:
        announcementRepository.save(entity)

        then:
        thrown(expectedException)

        where:
        entity               || expectedException
        withoutDestinatary() || DataAccessException
        whithoutMessage()    || DataAccessException
        whithoutType()       || DataAccessException
    }

    private AnnouncementEntity withoutDestinatary() {
        AnnouncementEntity.builder()
                .type(AnnouncementTypeEntity.WHATSAPP)
                .message("A test message")
                .build()
    }

    private whithoutMessage() {
        AnnouncementEntity.builder()
                .type(AnnouncementTypeEntity.WHATSAPP)
                .destinatary("11994196262")
                .build()
    }

    private whithoutType() {
        AnnouncementEntity.builder()
                .destinatary("11994196262")
                .message("A test message")
                .build()
    }
}
