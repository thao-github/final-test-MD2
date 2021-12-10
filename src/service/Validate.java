package service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static final String NAME_REGEX = "^[a-zA-Z\\s]+$";
    public static final String GROUP_REGEX = "^[a-zA-Z\\s]+$";
    public static final String GENDER_REGEX = "^[a-zA-Z]+$";
    public static final String DATE_OF_BIRTH_REGEX = "^[0-9]+$";
    public static final String PHONE_NUMBER_REGEX = "^[0-9]{10}+$";
    public static final String ADDRESS_REGEX = "^[a-zA-Z0-9]+$";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public static boolean validateInputDate(String string, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static String validate (String soutInput, String regex){
        String output = null;
        while (true){
            System.out.println(soutInput);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (Validate.validateInputDate(input, regex)) {
                output = input;
                break;
            } else {
                System.err.println("Wrong data type!");
            }
        }
        return output;
    }
}
