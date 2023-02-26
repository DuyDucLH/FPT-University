package Mainflow;


import Function.Ebank;
import Function.GetData;

/*
 * DuyDuc94
 */
/**
 *
 * @author duy20
 */
public class Main {

    public static void main(String[] args) {
        GUI gui = new GUI();
        GetData getData = new GetData();
        Ebank loginSystem = new Ebank();
        while(true){
            //Step 1: Display menu
            gui.displayMenu();
            //Step 2: Get choice from user
            int userChoice = getData.getUserChoice("Please choice one option: ");
            //Step 3: Perform language based on the selected option.
            switch(userChoice){
                case 1:
                    //Perform login system with Vietnamese interface
                    loginSystem.performVIetnameseInterfaceLoginSystem();
                    break;
                case 2:
                    //Perform login system with English interface
                    loginSystem.performEnglishInterfaceLoginSystem();
                    break;
                case 3:
                    //Exit the program
                    return;
            }
        }
    }
}
