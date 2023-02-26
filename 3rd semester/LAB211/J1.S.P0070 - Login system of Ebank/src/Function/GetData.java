package Function;



import java.util.Scanner;

/*
 * DuyDuc94
 */

/**
 *
 * @author duy20
 */
public class GetData {
    
    public int getUserChoice(String message){
        Scanner sc = new Scanner(System.in);
        String userInput;
        int userChoice;
        while (true) {            
            System.out.print(message);
            userInput = sc.nextLine();
            if(userInput.trim().isEmpty()){
                System.out.println("Input cannot be empty!");
                continue;
            }
            try {
                userChoice = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Please input choice as number!");
                continue;
            }
            if(userChoice > 0 && userChoice <4){
                return userChoice;
            }
            System.out.println("Invalid choice!");
        }
    }
    
    public String getUserInputString(String message, String messageInputIsEmpty){
        Scanner sc = new Scanner(System.in);
        String userInputString;
        while (true) {            
            System.out.print(message);
            userInputString = sc.nextLine();
            if(userInputString.trim().isEmpty()){
                System.out.println(messageInputIsEmpty);
                continue;
            }
            return userInputString;
        }
    }
    
}
