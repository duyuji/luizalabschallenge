package br.com.luizalabs.entities;

import java.time.LocalDateTime;
import java.util.Optional;

public class Announcement {
    private Long id;
    private String message;
    private String destinatary;
    private LocalDateTime dateTimeToSend;
    private LocalDateTime dateTimeOfSending;
    private AnnouncementType type;
    private ProcessingStatusType status;

    public static class Builder {
        private Long id;
        private String message;
        private String destinatary;
        private LocalDateTime dateTimeToSend;
        private LocalDateTime dateTimeOfSending;
        private AnnouncementType type;
        private ProcessingStatusType status;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder type(AnnouncementType type) {
            this.type = type;
            return this;
        }

        public Builder destinatary(String destinatary) {
            this.destinatary = destinatary;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder dateTimeToSend(LocalDateTime dateTimeToSend) {
            this.dateTimeToSend = dateTimeToSend;
            return this;
        }

        public Builder dateTimeOfSending(LocalDateTime dateTimeOfSending) {
            this.dateTimeOfSending = dateTimeOfSending;
            return this;
        }

        public Builder status(ProcessingStatusType status) {
            this.status = status;
            return this;
        }

        public Optional<Announcement> build() {
            if(type == null)
                return Optional.empty();

            if(destinatary == null || destinatary.isEmpty())
                return Optional.empty();

            if(message == null || message.isEmpty())
                return Optional.empty();

            if(dateTimeToSend == null || dateTimeToSend.isBefore(LocalDateTime.now()))
                return Optional.empty();

            if(status == null)
                return Optional.empty();

            if (type.getValidator().isValid(destinatary)) {
                return Optional.of(new Announcement(id, message, destinatary, dateTimeToSend, dateTimeOfSending, type, status));
            }
            return Optional.empty();
        }
    }

    private Announcement() {}

    private Announcement(Long id, String message, String destinatary, LocalDateTime dateTimeToSend,
                         LocalDateTime dateTimeOfSending, AnnouncementType type, ProcessingStatusType status) {
        this.id = id;
        this.message = message;
        this.destinatary = destinatary;
        this.dateTimeToSend = dateTimeToSend;
        this.dateTimeOfSending = dateTimeOfSending;
        this.type = type;
        this.status = status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getDestinatary() {
        return destinatary;
    }

    public AnnouncementType getType() {
        return type;
    }

    public LocalDateTime getDateTimeToSend() {
        return dateTimeToSend;
    }

    public LocalDateTime getDateTimeOfSending() {
        return dateTimeOfSending;
    }

    public ProcessingStatusType getStatus() {
        return status;
    }
}
