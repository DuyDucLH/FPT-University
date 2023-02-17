/*
 * DuyDuc94
 */
package GUI;

import Function.ValidationInput;

/**
 *
 * @author duy20
 */
public class Menu {
    public static void main(String[] args) {
        while (true) {            
            //Display main menu
            System.out.println("==============================================");
            System.out.println("===Sale Management System===");
            System.out.println("1.0.    Product List Management");
            System.out.println("2.0.    Customer List Management");
            System.out.println("3.0.    Order List Management");
            System.out.println("4.0.    Exit program");
            switch(ValidationInput.inputUserChoice(1, 4)){
                case 1:
                    //Get into sub menu: Product menu
                    ProductMenu.productMenu();
                    break;
                case 2:
                    //Get into sub menu: Customer menu
                    System.out.println("Unfinished!");
//                    CustomerMenu.customerMenu();
                    break;
                case 3:
                    //Get into sub menu: Order menu
                    System.out.println("Unfinished!");
//                    OrderMenu.orderMenu();
                    break;
                case 4:
                    System.out.println("Exiting the program");
                    return;
            }
        }
    }
}
