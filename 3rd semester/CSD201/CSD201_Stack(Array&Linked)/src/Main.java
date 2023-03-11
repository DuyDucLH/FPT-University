
import java.util.*;

/*
 * DuyDuc94.
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static int userChoice;
    public static void main(String[] args) {
        while(true){
            System.out.println("1. Array Stack");
            System.out.println("2. Linked List Stack");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            userChoice = sc.nextInt();
            switch(userChoice){
                case 1:
                    displayArrayStackMenu();
                    break;
                case 2:
                    displayLinkedListStackMenu();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
    }

    public static void displayArrayStackMenu(){
        while(true){
            ArrayStack arrayStack = new ArrayStack();
            System.out.println("0. Generate random numbers");
            System.out.println("1. Push");
            System.out.println("2. Top");
            System.out.println("3. Pop");
            System.out.println("4. Insert at position");
            System.out.println("5. Delete at position");
            System.out.println("6. Display all");
            System.out.println("7. Clear");
            System.out.println("8. Exit to main menu");
            System.out.print("Enter your choice: ");
            userChoice = sc.nextInt();
            switch(userChoice){ 
                case 0:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 1:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 2:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 3:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 4:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 5:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 6:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 7:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public static void displayLinkedStackMenu(){
        while(true){
            System.out.println("1. Push");
            System.out.println("2. Top");
            System.out.println("3. Pop");
            System.out.println("4. Insert at position");
            System.out.println("5. Delete at position");
            System.out.println("6. Display all");
            System.out.println("7. Clear");
            System.out.println("8. Exit to main menu");
            System.out.print("Enter your choice: ");
            userChoice = sc.nextInt();
            switch(userChoice){
                case 1:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 2:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 3:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 4:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 5:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 6:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 7:
                    System.out.println("Enter the value to be pushed: ");
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
