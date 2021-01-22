package br.com.luizalabs.entities.validators;

import java.util.regex.Pattern;

public class EmailValidator implements AnnoucementValidator {
    private static final String ATOM = "[a-z0-9!#$%&'*+/=?^_`{|}~-]";
    private static final String DOMAIN = "(" + ATOM + "+(\\." + ATOM + "+)+";
    private static final String IP_DOMAIN = "\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\]";

    private static final String STRING_PATTERN =
            "^" + ATOM + "+(\\." + ATOM + "+)*@"
                    + DOMAIN
                    + "|"
                    + IP_DOMAIN
                    + ")$";

    private static final Pattern PATTERN = Pattern.compile(STRING_PATTERN);

    @Override
    public boolean isValid(String email) {
        return email != null && !email.isEmpty() && PATTERN.matcher(email).matches();
    }
}
