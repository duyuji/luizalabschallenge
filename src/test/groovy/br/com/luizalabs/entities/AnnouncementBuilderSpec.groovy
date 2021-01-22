package br.com.luizalabs.entities

import br.com.luizalabs.repositories.entities.ProcessingStatusTypeEntity
import spock.lang.Specification

import java.time.LocalDateTime

class AnnouncementBuilderSpec extends Specification {

    def 'build a valid SMS Announcement'() {
        def optionalAnnouncement = Announcement.builder()
                .type(AnnouncementType.SMS)
                .destinatary("11994196292")
                .message("A test message")
                .status(ProcessingStatusType.TO_PROCESS)
                .dateTimeToSend(LocalDateTime.now().plusDays(1))
                .build();

        expect:
        optionalAnnouncement.isPresent()
    }

    def 'build a invalid SMS Announcement'() {
        def optionalAnnouncement = Announcement.builder()
                .type(AnnouncementType.SMS)
                .destinatary("994196292")
                .message("A test message")
                .status(ProcessingStatusType.TO_PROCESS)
                .dateTimeToSend(LocalDateTime.now().plusDays(1))
                .build();

        expect:
        !optionalAnnouncement.isPresent()
    }

    def 'build a valid email Announcement'() {
        def optionalAnnouncement = Announcement.builder()
                .type(AnnouncementType.EMAIL)
                .destinatary("eduardo@gmail.com")
                .message("A test message")
                .status(ProcessingStatusType.TO_PROCESS)
                .dateTimeToSend(LocalDateTime.now().plusDays(1))
                .build();

        expect:
        optionalAnnouncement.isPresent()
    }

    def 'build a invalid email Announcement'() {
        def optionalAnnouncement = Announcement.builder()
                .type(AnnouncementType.EMAIL)
                .destinatary(".eduardo@gmail.com")
                .message("A test message")
                .status(ProcessingStatusType.TO_PROCESS)
                .dateTimeToSend(LocalDateTime.now().plusDays(1))
                .build();

        expect:
        !optionalAnnouncement.isPresent()
    }

    def 'build a valid Push Announcement'() {
        def optionalAnnouncement = Announcement.builder()
                .type(AnnouncementType.PUSH)
                .destinatary("1")
                .message("A test message")
                .status(ProcessingStatusType.TO_PROCESS)
                .dateTimeToSend(LocalDateTime.now().plusDays(1))
                .build();

        expect:
        optionalAnnouncement.isPresent()
    }

    def 'build a invalid Push Announcement'() {
        def optionalAnnouncement = Announcement.builder()
                .type(AnnouncementType.PUSH)
                .destinatary("")
                .message("A test message")
                .status(ProcessingStatusType.TO_PROCESS)
                .dateTimeToSend(LocalDateTime.now().plusDays(1))
                .build();

        expect:
        !optionalAnnouncement.isPresent()
    }

    def 'build a valid WhatsApp Announcement'() {
        def optionalAnnouncement = Announcement.builder()
                .type(AnnouncementType.WHATSAPP)
                .destinatary("11994196292")
                .message("A test message")
                .status(ProcessingStatusType.TO_PROCESS)
                .dateTimeToSend(LocalDateTime.now().plusDays(1))
                .build();

        expect:
        optionalAnnouncement.isPresent()
    }

    def 'build a invalid WhatsApp Announcement'() {
        def optionalAnnouncement = Announcement.builder()
                .type(AnnouncementType.WHATSAPP)
                .destinatary("994196292")
                .message("A test message")
                .status(ProcessingStatusType.TO_PROCESS)
                .dateTimeToSend(LocalDateTime.now().plusDays(1))
                .build();

        expect:
        !optionalAnnouncement.isPresent()
    }
}
