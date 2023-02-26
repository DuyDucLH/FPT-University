/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author duy20
 */
public class GetData {

    //Get validated date has dd/mm/yyyy format
    public static Date getDateWith_dd_mm_yyyy_Format(String numberOrder) {
        Scanner sc = new Scanner(System.in);
        String userInput;
        Date date;
        //Loop until get validated date has dd/mm/yyyy format
        while (true) {
            System.out.print("Please enter the " + numberOrder + " date: ");
            userInput = sc.nextLine();
            //Check format of string, if not correct format, input again
            if (!isCorrectFormat(userInput)) {
                continue;
            }
            //Validate date from date string user input is exist or not
            if ((date = validateDate(userInput)) == null) {
                continue;
            }
            return date;
        }
    }
    
    //Check if string user input is correct with dd/mm/yyyy format
    public static boolean isCorrectFormat(String userInput) {
        //Check if user input is empty or not
        if (userInput.isEmpty()) {
            System.out.println("Input cannot be empty!");
            return false;
        }
        //Check user input is correct with dd/mm/yyyy format or not
        /*Regex: \\d{1,2}: String must contains 1 or 2 digits
                 [/]: String must contains character '/'
                 \\d{4}: String must contains 4 digits
         */
        if (!userInput.matches("^\\d{1,2}[/]\\d{1,2}[/]\\d{4}$")) {
            System.out.println("Wrong format! Date must be in format [dd/mm/yyyy]");
            return false;
        }
        return true;
    }

    //Validate date has correct format is exist or not
    public static Date validateDate(String userInput) {
        Date date;
        /*Pattern:  d: day in month
                    MM: month in year
                    y: year
         */
        SimpleDateFormat formatDate = new SimpleDateFormat("d/MM/y");
        //Set default parsing to strict parsing to parse correct date
        formatDate.setLenient(false);
        //Parse string user input to Date to check it exist or not
        try {
            date = formatDate.parse(userInput);
            return date;
        } catch (ParseException e) {
            System.out.println("Date doesn't exist!");
            return null;
        }
    }

    //Get result string of compare 2 date
    public static String getResultOfCompareTwoDate(Date firstDate, Date secondDate) {
        //method compareTo return int value, 1 if this date is after another date, 0 if equal, and -1 if before
        int compareDate = firstDate.compareTo(secondDate);
        if (compareDate > 0) {
            return "Date1 is after Date2";
        } else if (compareDate == 0) {
            return "Date1 is equal Date2";
        } else {
            return "Date1 is before Date2";
        }
    }

    public static void display(String message) {
        System.out.println("");
        System.out.println(message);
    }
}
