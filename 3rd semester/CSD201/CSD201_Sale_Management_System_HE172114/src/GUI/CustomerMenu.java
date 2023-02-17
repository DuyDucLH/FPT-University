/*
 * DuyDuc94
 */
package GUI;

import Function.MyLinkedList;
import Function.ValidationInput;
import Object.Customer;
import java.io.*;

/**
 *
 * @author duy20
 */
public class CustomerMenu {
    
    public static MyLinkedList<Customer> customerList = new MyLinkedList();
    
    public static void customerMenu() {
        while (true) {            
            System.out.println("");
            System.out.println("Customer list (1 mark):");
            System.out.println("2.1.      Load data from file");
            System.out.println("2.2.      Input & add to the end");
            System.out.println("2.3.      Display data");
            System.out.println("2.4.      Save customer list to file");
            System.out.println("2.5.      Search by ccode");
            System.out.println("2.6.      Delete by ccode");
            /*Addition*/ System.out.println("2.7.      Return to menu");
            switch (ValidationInput.inputUserChoice(1, 7)) {
                case 1:
                    loadDataFromFile();
                    break;
                case 2:
                    customerList.addLast(ValidationInput.inputCustomerData());
                    break;
                case 3:
                    displayData();
                    break;
                case 4:
                    saveCustomerListToFile();
                    break;
                case 5:
                    searchByCustomerCode();
                    break;
                case 6:
                    deleteByCustomerCode();
                    break;
                case 7:
                    return;
            }
        }
    }
    
    public static void loadDataFromFile() {
//        String filePath;
        FileReader dataFile;
        BufferedReader buffRead;
        String readString;
        boolean isFileEmpty = true;
        /*Auto add data*/ String filePath = "D:\\Specialized - SE1731\\Ki3_Spring 2023\\CSD201\\JavaCode\\CSD201_Sale_Management_System\\src\\Data\\CustomerData_SaleManagementSystem.txt";
//        filePath = ValidationInput.inputString("Input path of file contain data: ");
        System.out.println("");
        //Check file exist
        try {
            dataFile = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist! Create or correct path file!");
            return;
        }
        buffRead = new BufferedReader(dataFile);
        try {
            int countLine = 0;
            //Read every single line of file till end of file
            while ((readString = buffRead.readLine()) != null) {
                countLine++;
                System.out.print("Line " + countLine + ": ");
                //Load every single line to data (must follow format)
                loadDataWithFormat(readString, countLine);
                isFileEmpty = false;
            }
            if (isFileEmpty) {
                System.out.println("File data is empty!");
            } else {
                System.out.println("Add data successfully!");
            }
            buffRead.close();
        } catch (IOException ex) {
            System.out.print("An error has occur: ");
            System.out.println(ex);
        }
    }

    //Transfer single line contain data to new data in linked list
    public static void loadDataWithFormat(String stringLine, int numberLine) {
        /*
To split the string on a pipe character, need to escape it with a backslash (\\|) to indicate that it should be treated as a literal character rather than a regular expression metacharacter.
         */
        if (stringLine.trim().isEmpty()) {
            System.out.println("Line is empty!");
            return;
        }
        String[] data = stringLine.split("\\|");
        try {
            String customerCode = data[0].trim();
            String sustomerName = data[1].trim();
            String phone = data[2].trim();
            customerList.addLast(new Customer(customerCode, sustomerName, phone));
        } catch (NumberFormatException e) {
            System.out.println("Data doesn't follow format!");
        } catch (Exception PhoneException) {
            System.out.println("Cannot add Customer! " + PhoneException.getMessage());
        }
    }
    
    public static void displayData() {
        if (customerList.isEmpty()) {
            System.out.println("\nList is empty! Nothing to display!");
        } else {
            System.out.println("\nccode |  Cus_name   |  phone   ");
            System.out.println("---------------------------------");
            customerList.traverse();
        }
    }
    
    public static void saveCustomerListToFile() {
        String fileName = ValidationInput.inputString("Input file name to save data: ");
        System.out.println("");
        //Get current directory that program is running
        String curentDir = System.getProperty("user.dir");

        //Create new file
        File newFile = new File(curentDir + "\\" + fileName + ".txt");
        try {
            if (newFile.createNewFile()) {
                System.out.println("Create " + fileName + ".txt succesfully!");
            } else {
                System.out.println("File already exist!");
            }
        } catch (IOException ex) {
            System.out.print("An error has occur: ");
            System.out.println(ex.getMessage());
            return;
        }

        System.out.println("File located at " + newFile.getAbsolutePath());

        //Write data into file
        try {
            try (FileWriter fileWriter = new FileWriter(newFile)) {
                fileWriter.write("ccode |  Cus_name   |  phone   \n");
                fileWriter.write("---------------------------------\n");
                fileWriter.write(customerList.getData());
            }
            System.out.println("Successfully write data on file.");
        } catch (IOException ex) {
            System.out.print("An error has occur: ");
            System.out.println(ex.getMessage());
        }
    }
    
    public static void searchByCustomerCode() {
        if (customerList.isEmpty()) {
            System.out.println("\nList is empty!");
            return;
        }
        Customer tempCustomer;
        //Search by product code, if not found "search" will return null
        try {
            tempCustomer = (Customer) customerList.search(ValidationInput.inputString("Input customer code need to search: ")).getData();
            System.out.println("\nFound " + tempCustomer + "!");
        } catch (NullPointerException e) {
            System.out.println("\nNot found!");
        }
    }
    
    public static void deleteByCustomerCode() {
        if (customerList.isEmpty()) {
            System.out.println("\nList is empty!");
            return;
        }
        customerList.delete(ValidationInput.inputString("Input customer code need delete: "));
    }
}
