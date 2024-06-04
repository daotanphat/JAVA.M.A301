package fa.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public boolean isValidDate(String dateStr) {
        // Define the date format
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            // Try to parse the date
            Date date = sdf.parse(dateStr);
            // If successful, return true
            return true;
        } catch (ParseException e) {
            System.out.println("Input correct format dd/MM/yyyy");
            // If parsing fails, return false
            return false;
        }
    }


    public boolean isValidEmail(String email) {
        String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        // Compile the regular expression
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        // Match the given email string with the pattern
        Matcher matcher = pattern.matcher(email);
        // Return true if the email matches the pattern, otherwise false
        return matcher.matches();
    }

    public double inputMark(int min, int max, String message) {
        Scanner sc = new Scanner(System.in);
        double result;
        while (true) {
            try {
                System.out.print(message);
                result = sc.nextDouble();
                if (result < min || result > max) {
                    System.out.println("Pls enter mark from " + min + " to " + max);
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Pls enter mark from " + min + " to " + max);
                sc.next();
            }
        }
        return result;
    }

    public int inputInt(String message, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                System.out.print(message);
                choice = sc.nextInt();
                if (choice < min || choice > max) {
                    System.out.println("Input a number from " + min + " to " + max);
                } else {
                    break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Input a number from " + min + " to " + max);
                sc.next();
            }
        }
        return choice;
    }

    public static String inputStrNoBlank(String msg) {
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
            if (data.length() == 0) {
                System.out.println("String can not be blank. Input again!");
            }
        } while (data.length() == 0);
        return data;
    }

    public boolean checkQuit(int choice) {
        if (choice == 1 || choice == 2 || choice == 3 || choice == 4) return true;
        return false;
    }
}
