/*
 * DuyDuc94
 */
package GUI;

import Function.MyLinkedList;
import Function.ValidationInput;
import Object.Order;
import Object.Product;

/**
 *
 * @author duy20
 */
public class OrderMenu {

    static MyLinkedList<Order> orderList = new MyLinkedList<>();
    
    public static void orderMenu() {
        while (true) {
            System.out.println("");
            System.out.println("Order list (1 mark):");
            System.out.println("3.1.      Input data");
            System.out.println("3.2.      Display data with total value");
            System.out.println("3.3.      Sort  by pcode + ccode");
            /*Addition*/ System.out.println("3.4.      Return to menu");
            switch (ValidationInput.inputUserChoice(1, 4)) {
                case 1:
                    inputDataSaleItem();
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    orderList.sortByCode();
                    break;
                case 4:
                    return;
            }
        }
    }
    
    public static void inputDataSaleItem(){
        if(ProductMenu.productList.isEmpty() || CustomerMenu.customerList.isEmpty()){
            System.out.println("\nPlease load data of product and customer!");
            return;
        }
        String pCode = ValidationInput.inputString("Enter product code: ");
        String cCode = ValidationInput.inputString("Enter customer code: ");
        if(ProductMenu.productList.search(pCode) == null || CustomerMenu.customerList.search(cCode) == null){
            System.out.println("\nProduct code or Customer code doesn't exist!");
            return;
        }
        if(orderList.checkDuplicate(pCode + ", " + cCode)) return;
        Product tempProduct = (Product) ProductMenu.productList.search(pCode).getData();
        if(tempProduct.remainQuantity() == 0){
            System.out.println("\nThis product is exhausted!");
            return;
        }
        int quantity = ValidationInput.inputInt("Enter quantity: ");
        if(quantity > tempProduct.remainQuantity()){
            System.out.println("\nThe number of product is not enough to order!");
            return;
        }
        System.out.println("");
        orderList.addLast(new Order(pCode, cCode, quantity));
    }
    
    public static void displayData() {
        if (orderList.isEmpty()) {
            System.out.println("\nList is empty! Nothing to display!");
        } else {
            System.out.println("\nPro_Code |   Cus_Code  |  Quantity  ");
            System.out.println("---------------------------------------");
            orderList.traverse();
        }
    }
}



