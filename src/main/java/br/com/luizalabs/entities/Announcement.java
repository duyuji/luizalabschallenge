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
            if(type == null)
                throw new NullPointerException("Type could'not be null");
            this.type = type;
            return this;
        }

        public Builder destinatary(String destinatary) {
            if(destinatary == null)
                throw new NullPointerException("Destinatary could'not be null");
            this.destinatary = destinatary;
            return this;
        }

        public Builder message(String message) {
            if(message == null)
                throw new NullPointerException("Message could'not be null");
            this.message = message;
            return this;
        }

        public Optional<Announcement> build() {
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
