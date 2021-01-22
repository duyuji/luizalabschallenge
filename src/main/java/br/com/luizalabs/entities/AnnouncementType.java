package br.com.luizalabs.entities;

import br.com.luizalabs.entities.validators.AnnoucementValidator;
import br.com.luizalabs.entities.validators.EmailValidator;
import br.com.luizalabs.entities.validators.PhoneValidator;
import br.com.luizalabs.entities.validators.PushIDValidator;

public enum AnnouncementType {
    EMAIL(new EmailValidator()),
    SMS(new PhoneValidator()),
    PUSH(new PushIDValidator()),
    WHATSAPP(new PhoneValidator());

    private AnnoucementValidator validator;

    AnnouncementType(AnnoucementValidator validator) {
        this.validator = validator;
    }

    public AnnoucementValidator getValidator() {
        return validator;
    }
}
