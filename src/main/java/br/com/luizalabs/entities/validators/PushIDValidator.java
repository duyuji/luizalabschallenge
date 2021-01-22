package br.com.luizalabs.entities.validators;

public class PushIDValidator implements AnnoucementValidator {
    @Override
    public boolean isValid(String pushID) {
        return pushID != null && !pushID.isEmpty();
    }
}
