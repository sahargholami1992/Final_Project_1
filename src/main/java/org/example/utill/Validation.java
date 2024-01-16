package org.example.utill;

import org.apache.commons.lang3.StringUtils;
import org.example.Application;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8}$";
    private static final String STRING_REGEX = "^[a-zA-Z\\s]+$";
    private static final Scanner SC = new Scanner(System.in);

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
//        return password != null && password.matches(PASSWORD_REGEX);
    }

    public static boolean containsOnlyAlphabetsAndSpaces(String input) {
        // Alphabets and spaces only
        return input.matches(STRING_REGEX) && !StringUtils.isBlank(input);
    }

    public static boolean isValidNationalCodeAndPostalCodeWithRegex(String nationalCode) {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        return nationalCode.matches(pattern.pattern());
    }

    public static boolean validateImage(String imagePath)  {
        File imageFile = new File(imagePath);

        // Check image format based on file extension
        String fileName = imageFile.getName();
        if (!fileName.toLowerCase().endsWith(".jpg")) {
            System.out.println("Image must be in JPG format.");
            return false;
        }

        // Check image size
        long fileSizeInKB = 0;
        try {
            fileSizeInKB = Files.size(Paths.get(imagePath)) / 1024;
        } catch (IOException e) {
            return false;
        }
        if (fileSizeInKB > 300) {
            System.out.println("Image size exceeds the maximum limit of 300 kilobytes.");
            return false;
        }
        return true;
    }

    public static byte[] readsImage(String imageName)  {
        // Assuming "image.jpg" is the name of your image file in the resources folder

        InputStream inputStream = Validation.class.getClassLoader().getResourceAsStream(imageName);
        if (inputStream != null){
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int bytesRead;
            byte[] buffer = new byte[1024];

            while (true) {
                try {
                    if ((bytesRead = inputStream.read(buffer)) == -1) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            return byteArrayOutputStream.toByteArray();
        }else{
            System.out.println("invalid image name");
            return null;
        }


    }




    public static boolean isValidImage(byte[] imageData) {
        try {
            // Validate image format (JPEG)
            if (imageData == null || !isJpegFormat(imageData)) {
                System.out.println("Invalid image format. Only JPEG format is allowed.");
                return false;
            }

            // Validate image size (300 KB)
            if (!isWithinSizeLimit(imageData)) {
                System.out.println("Image size exceeds the maximum limit (300 KB).");
                return false;
            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isJpegFormat(byte[] imageData) throws IOException {
        // Read the first two bytes to identify the image format
        if (imageData.length < 2) {
            return false;
        }

        // JPEG magic number: 0xFFD8
        return (imageData[0] & 0xFF) == 0xFF && (imageData[1] & 0xFF) == 0xD8;
    }

    private static boolean isWithinSizeLimit(byte[] imageData) {
        return imageData != null && imageData.length <= (long) 307200;
    }



    public static byte[] readImage(String imagePath) {
        try {
            Path path = Paths.get(imagePath);
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean saveImageToFile(byte[] imageData, String outputPath) {
        try (OutputStream outputStream = new FileOutputStream(outputPath)) {
            outputStream.write(imageData);
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    public static Integer input() {
        int i;
        while (true) {
            try {
                i = SC.nextInt();
                SC.nextLine();
                return i;
            } catch (InputMismatchException in) {
                SC.nextLine();
                System.out.println("enter valid number !");
            }
        }
    }
    public static Double inputDouble() {
        double i;
        while (true) {
            try {
                i = SC.nextDouble();
                SC.nextLine();
                return i;
            } catch (InputMismatchException in) {
                SC.nextLine();
                System.out.println("enter valid number !");
            }
        }
    }
    public static boolean validateString(String string) {
        return !StringUtils.isBlank(string);
    }
    public static LocalDate validateAndProcessDate(String inputDate) {
        // Define the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Parse the input date
        return LocalDate.parse(inputDate, formatter);

    }


        public static boolean getBooleanInputWithValidation (String prompt, Scanner scanner){
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

        public static Date getDate ( int year, int month, int day){
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            return calendar.getTime();
        }

    }

