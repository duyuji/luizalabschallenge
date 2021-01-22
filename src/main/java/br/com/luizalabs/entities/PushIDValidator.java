package br.com.luizalabs.entities;

public class PushIDValidator implements AnnoucementValidator {
    @Override
    public boolean isValid(String pushID) {
        return pushID != null && !pushID.isEmpty();
    }
}
