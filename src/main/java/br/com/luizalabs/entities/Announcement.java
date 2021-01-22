package br.com.luizalabs.entities;

import java.util.Optional;

public class Announcement {
    private Long id;
    private String message;
    private String destinatary;
    private AnnouncementType type;

    public static class Builder {
        private Long id;
        private String message;
        private String destinatary;
        private AnnouncementType type;

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

        public Optional<Announcement> build() {
            if(type == null)
                return Optional.empty();

            if(destinatary == null || destinatary.isEmpty())
                return Optional.empty();

            if(message == null || message.isEmpty())
                return Optional.empty();

            if (type.getValidator().isValid(destinatary)) {
                return Optional.of(new Announcement(id, message, destinatary, type));
            }
            return Optional.empty();
        }
    }

    private Announcement() {}

    private Announcement(Long id, String message, String destinatary, AnnouncementType type) {
        this.id = id;
        this.message = message;
        this.destinatary = destinatary;
        this.type = type;
    }

    public static Builder builder() {
        return new Builder();
    }
}
