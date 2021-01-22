package br.com.luizalabs.repositories


import br.com.luizalabs.repositories.entities.AnnouncementEntity
import br.com.luizalabs.repositories.entities.AnnouncementTypeEntity
import br.com.luizalabs.repositories.entities.ProcessingStatusTypeEntity
import io.micronaut.data.exceptions.DataAccessException
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject
import java.time.LocalDateTime

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
                           .status(ProcessingStatusTypeEntity.TO_PROCESS)
                           .destinatary("11994196292")
                           .message("A test message")
                           .dateTimeToSend(LocalDateTime.now())
                           .build(),
                   AnnouncementEntity.builder()
                           .type(AnnouncementTypeEntity.EMAIL)
                           .status(ProcessingStatusTypeEntity.TO_PROCESS)
                           .destinatary("eduardo@gmail.com")
                           .message("A test message")
                           .dateTimeToSend(LocalDateTime.now())
                           .build(),
                   AnnouncementEntity.builder()
                           .type(AnnouncementTypeEntity.PUSH)
                           .status(ProcessingStatusTypeEntity.TO_PROCESS)
                           .destinatary("1")
                           .message("A test message")
                           .dateTimeToSend(LocalDateTime.now())
                           .build(),
                   AnnouncementEntity.builder()
                           .type(AnnouncementTypeEntity.WHATSAPP)
                           .status(ProcessingStatusTypeEntity.PROCESSED)
                           .destinatary("11994196262")
                           .message("A test message")
                           .dateTimeToSend(LocalDateTime.now())
                           .build()]
    }

    def 'test save a invalid Announcement without destinatary'() {
        when:
        announcementRepository.save(entity)

        then:
        thrown(expectedException)

        where:
        entity                   || expectedException
        withoutDestinatary()     || DataAccessException
        whithoutMessage()        || DataAccessException
        whithoutType()           || DataAccessException
        whithoutStatus()         || DataAccessException
        whithoutDateTimeToSend() || DataAccessException
    }

    private AnnouncementEntity withoutDestinatary() {
        AnnouncementEntity.builder()
                .type(AnnouncementTypeEntity.WHATSAPP)
                .status(ProcessingStatusTypeEntity.TO_PROCESS)
                .dateTimeToSend(LocalDateTime.now())
                .message("A test message")
                .build()
    }

    private whithoutMessage() {
        AnnouncementEntity.builder()
                .type(AnnouncementTypeEntity.WHATSAPP)
                .status(ProcessingStatusTypeEntity.TO_PROCESS)
                .dateTimeToSend(LocalDateTime.now())
                .destinatary("11994196262")
                .build()
    }

    private whithoutType() {
        AnnouncementEntity.builder()
                .destinatary("11994196262")
                .status(ProcessingStatusTypeEntity.TO_PROCESS)
                .dateTimeToSend(LocalDateTime.now())
                .message("A test message")
                .build()
    }

    private whithoutStatus() {
        AnnouncementEntity.builder()
                .type(AnnouncementTypeEntity.WHATSAPP)
                .destinatary("11994196262")
                .dateTimeToSend(LocalDateTime.now())
                .message("A test message")
                .build()
    }

    private whithoutDateTimeToSend() {
        AnnouncementEntity.builder()
                .type(AnnouncementTypeEntity.WHATSAPP)
                .status(ProcessingStatusTypeEntity.TO_PROCESS)
                .destinatary("11994196262")
                .message("A test message")
                .build()
    }
}
