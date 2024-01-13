package org.example.utill;

import org.apache.commons.lang3.StringUtils;


import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).*$";
    private static final String STRING_REGEX = "^[a-zA-Z\\s]+$";
    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isValidPassword(String password) {
        // Additional logic for validating password outside the class
        // (e.g., if you need to validate passwords in a service or controller)
        return password != null && password.matches(PASSWORD_REGEX);
    }
    public static boolean containsOnlyAlphabetsAndSpaces(String input) {
         // Alphabets and spaces only
        return input.matches(STRING_REGEX) && !StringUtils.isBlank(input);
    }
    public static boolean isValidNationalCodeAndPostalCodeWithRegex(String nationalCode) {
        Pattern pattern =
                Pattern.compile("^[0-9]{10}$");
        return nationalCode.matches(pattern.pattern());
    }
//    public static String generatePassword() {
//        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&])(?=\\S+$).{8,}$";
//
//        SecureRandom random = new SecureRandom();
//
//        StringBuilder password = new StringBuilder();
//
//        while (!password.toString().matches(passwordPattern)) {
//            password.setLength(0);
//            for (int i = 0; i < 12; i++) {
//                char randomChar = (char) (random.nextInt(94) + 33);
//                password.append(randomChar);
//            }
//        }
//        return password.toString();
//    }




//    public static boolean isValidCardNumberWithRegex(String cardNumber) {
//        Pattern pattern =
//                Pattern.compile("^[0-9]{16}$");
//        return cardNumber.matches(pattern.pattern());
//    }

    public static boolean getBooleanInputWithValidation(String prompt, Scanner scanner) {
        boolean validInput = false;
        boolean userInput = false;

        while (!validInput) {
            System.out.print(prompt + " (true/false): ");

            try {
                userInput = scanner.nextBoolean();
                validInput = true; // If no exception is thrown, the input is valid
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
                scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
            }
        }

        return userInput;
    }

    public static Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }


//    public static String generatePasswordddd() {
//        Random random = new Random();
//        String validCharacters = "@#$%&abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        String password;
//        do {
//            StringBuilder passwordBuilder = new StringBuilder();
//            for (int i = 0; i < 8; i++) {
//                int randomIndex = random.nextInt(validCharacters.length());
//                passwordBuilder.append(validCharacters.charAt(randomIndex));
//            }
//            password = passwordBuilder.toString();
//        } while (!isValidPassword(password));
//
//        return password;
//    }

//    private static boolean isValidPasswordddddd(String password) {
//        if (!password.matches(".*[A-Z].*")) {
//            return false;
//        }
//
//        if (!password.matches(".*[a-z].*")) {
//            return false;
//        }
//
//        if (!password.matches(".*[@#$%&].*")) {
//            return false;
//        }
//
//        if (!password.matches(".*\\d.*")) {
//            return false;
//        }
//
//        return true;
//    }

}
