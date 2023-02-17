/*
 * DuyDuc94
 */
package GUI;

import Function.MyLinkedList;
import Function.ValidationInput;
import Object.Node;
import Object.Product;
import java.io.*;

/**
 *
 * @author duy20
 */
public class ProductMenu {
    
    static MyLinkedList<Product> productList = new MyLinkedList();
    
    public static void productMenu(){
        while (true) {
            System.out.println("\n==============================================");
            System.out.println("Product list (8 marks):");
            System.out.println("1.1.      Load data from file");
            System.out.println("1.2.      Input & add to the end");
            System.out.println("1.3.      Display data");
            System.out.println("1.4.      Save product list to file");
            System.out.println("1.5.      Search by pcode");
            System.out.println("1.6.      Delete by pcode");
            System.out.println("1.7.      Sort by pcode");
            System.out.println("1.8.      Add after position k");
            System.out.println("1.9.      Delete the node after the node having code = xCode");
/*Addition*/            System.out.println("1.10.     Return to menu");
            switch(ValidationInput.inputUserChoice(1, 10)){
                case 1:
                    loadDataFromFile();
                    break;
                case 2:
                    productList.addLast(ValidationInput.inputProductData());
                    break;
                case 3:
                    displayData();
                    break;
                case 4:
                    saveProductListToFile();
                    break;
                case 5:
                    searchByProductCode();
                    break;
                case 6:
                    deleteByProductCode();
                    break;
                case 7:
                    productList.sortByCode();
                    break;
                case 8:
                    insertAfterPosition();
                    break;
                case 9:
                    delNodeAfterxCode();
                    break;
                case 10:
                    return;
            }
        }
    }
    
    public static void loadDataFromFile(){
        String filePath;
        FileReader dataFile;
        BufferedReader buffRead;
        String readString;
        boolean isFileEmpty = true;
///*Auto add data*/        String filePath = "D:\\Work_Space\\Study_Space\\FPT-University\\Ky_3\\CSD201\\CSD201_Project\\CSD201_Sale_Management_System_HE172114\\src\\Data\\Data_SaleManagementSystem.txt";
        filePath = ValidationInput.inputString("Input path of file contain data: ");
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
            if(isFileEmpty){
                System.out.println("File data is empty!");
            }else{
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
        if(stringLine.trim().isEmpty()){
            System.out.println("Line is empty!");
            return;
        }
        String[] data = stringLine.split("\\|");
        try {
            String productCode = data[0].trim();
            String productName = data[1].trim();
            int quantity = Integer.parseInt(data[2].trim());
            int saled = Integer.parseInt(data[3].trim());
            double price = Double.parseDouble(data[4].trim());
            productList.addLast(new Product(productCode, productName, quantity, saled, price));
        } catch (NumberFormatException e) {
            System.out.println("Data doesn't follow format!");
        } catch (Exception productEx) {
            System.out.println("Cannot add product because " + productEx.getMessage());
        }
    }
    
    public static void displayData(){
        if(productList.isEmpty()) 
            System.out.println("\nList is empty! Nothing to display!");
        else{
            System.out.println("\ncode |   Pro_name  |  Quantity  |  saled |  Price   |   Value");
            System.out.println("---------------------------------------------------------------");
            productList.traverseIn("product");
        }
    }
    
    public static void saveProductListToFile(){
        String fileName = ValidationInput.inputString("Input file name to save data: ");
        System.out.println("");
        //Get current directory that program is running
        String curentDir = System.getProperty("user.dir");
        
        //Create new file
        File newFile = new File(curentDir + "\\" + fileName + ".txt");
        try {
            if(newFile.createNewFile()){
                System.out.println("Create " + fileName + ".txt succesfully!");
            }else{
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
                fileWriter.write("code |   Pro_name  |  Quantity  |  saled |  Price   |   Value\n");
                fileWriter.write("---------------------------------------------------------------\n");
                fileWriter.write(productList.getData("product"));
            }
            System.out.println("Successfully write data on file.");
        } catch (IOException ex) {
            System.out.print("An error has occur: ");
            System.out.println(ex.getMessage());
        }
    }
    
    public static void searchByProductCode(){
        if(productList.isEmpty()){
            System.out.println("\nList is empty!");
            return;
        }
        Product tempProduct;
        //Search by product code, if not found "search" will return null
        try {
            tempProduct = (Product) productList.search(ValidationInput.inputString("Input product code need to search: "), "product").getData();
            System.out.println("\nFound " + tempProduct + "!");
        } catch (NullPointerException e) {
            System.out.println("\nNot found!");
        }
    }
    
    public static void deleteByProductCode(){
        if(productList.isEmpty()){
            System.out.println("\nList is empty!");
            return;
        }
        productList.delete(ValidationInput.inputString("Input product code need delete: "));
    }
    
    public static void insertAfterPosition(){
        if(productList.isEmpty()){
            System.out.println("\nList is empty!");
            return;
        }
        Node nodeAtPositionK = productList.atPosition(ValidationInput.inputInt("Input position k: "));
        if(nodeAtPositionK == null){
            System.out.println("\nNot found!");
            return;
        }
        Product tempProduct = ValidationInput.inputProductData();
        if(tempProduct != null){
            productList.insertAfter(nodeAtPositionK, tempProduct);
        }else{
            return;
        }
    }
    
    public static void delNodeAfterxCode(){
        if(productList.isEmpty()){
            System.out.println("\nList is empty!");
            return;
        }
        productList.deleteAfter(productList.search(ValidationInput.inputString("Input code of node want to delete its after node: "), "product"));
    }
    
}
