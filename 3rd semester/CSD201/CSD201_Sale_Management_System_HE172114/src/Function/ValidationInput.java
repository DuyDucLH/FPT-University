/*
 * DuyDuc94
 */
package Function;

import Object.Product;
import java.util.Scanner;

/**
 *
 * @author duy20
 */
public class ValidationInput {
    
    public static final Scanner SC = new Scanner(System.in);
    
    public static int inputUserChoice(int min, int max){
        String userInput;
        int userInputChoice;
        while (true) {
            System.out.print(">Input choice: ");
            userInput = SC.nextLine().trim();
            if(userInput.isEmpty()){
                System.out.println("Cannot empty!");
                continue;
            }
            try {
                userInputChoice = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Input must be digit!");
                continue;
            }
            if(userInputChoice>=min && userInputChoice<=max){
                return userInputChoice;
            }else{
                System.out.println("Invalid choice!");
            }
        }
    }
    
    public static String inputString(String message){
        String result;
        while (true) {            
            System.out.print(message);
            result = SC.nextLine().trim();
            if(result.isEmpty()){
                System.out.println("Cannot empty!");
                continue;
            }
            return result;
        }
    }
    
    public static int inputInt(String message){
        String inputString;
        int result;
        while (true) {            
            System.out.print(message);
            inputString = SC.nextLine().trim();
            if(inputString.isEmpty()){
                System.out.println("Cannot empty!");
                continue;
            }
            try {
                result = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                System.out.println("Can only contain digits");
                continue;
            }
            return result;
        }
    }
    
    public static double inputDouble(String message){
        String inputString;
        double result;
        while (true) {            
            System.out.print(message);
            inputString = SC.nextLine().trim();
            if(inputString.isEmpty()){
                System.out.println("Cannot empty!");
                continue;
            }
            try {
                result = Double.parseDouble(inputString);
            } catch (NumberFormatException e) {
                System.out.println("Can only contain digits");
                continue;
            }
            return result;
        }
    }
    
    public static Product inputProductData(){
        System.out.println("Add new product data:");
        String productCode = inputString("Input Product code: ");
        String productName = inputString("Input Product name: ");
        int quantity = inputInt("Input Product quantity: ");
        int saled = inputInt("Input Product saled: ");
        double price = inputDouble("Input Product price: ");
        System.out.println("");
        Product newProduct = null;
        try {
            newProduct = new Product(productCode, productName, quantity, saled, price);
        } catch (Exception productEx) {
            System.out.println("Cannot add product because " + productEx.getMessage());
        }
        return newProduct;
    }
}
