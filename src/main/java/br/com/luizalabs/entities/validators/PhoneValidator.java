package br.com.luizalabs.entities.validators;

import java.util.List;
import java.util.regex.Pattern;

public class PhoneValidator implements AnnoucementValidator {
    private static final List<Integer> DDD = List.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 24, 27, 28, 31, 32, 33, 34, 35, 37, 38, 41, 42, 43, 44, 45, 46, 47, 48, 49, 51, 53, 54, 55, 61, 62, 63, 64, 65, 66, 67, 68, 69, 71, 73, 74, 75, 77, 79, 81, 82, 83, 84, 85, 86, 87, 88, 89, 91, 92, 93, 94, 95, 96, 97, 98, 99);
    private static final Pattern PATTERN = Pattern.compile("[0-9]+");

    @Override
    public boolean isValid(String phoneNumber) {
        return phoneNumber != null
                && !phoneNumber.isEmpty()
                && PATTERN.matcher(phoneNumber).matches()
                && phoneNumber.length() == 11
                && Integer.parseInt(phoneNumber.substring(2, 3)) == 9
                && DDD.contains(Integer.parseInt(phoneNumber.substring(0, 2)));
    }
}
