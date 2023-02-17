/*
 * DuyDuc94
 */
package Object;

import GUI.ProductMenu;

/**
 *
 * @author duy20
 */
public class Order {
    private String productCode;
    private String customerCode;
    private int quantity;

    public Order(String productCode, String customerCode, int quantity) {
        this.productCode = productCode;
        this.customerCode = customerCode;
        this.quantity = quantity;
        //When new order create, subtract reamain product by quantity order
        ProductMenu.productList.subtractQuantityOrder(productCode, quantity);
    }
    
    public String getPrimaryKey(){
        return productCode + ", "  + customerCode;
    }
    
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void display(){
        System.out.format("   %-6s|     %-8s|     %-6d\n", getProductCode(), getCustomerCode(), getQuantity());
    }
    
    @Override
    public String toString() {
        return "("+ productCode+ " | " + customerCode+ " | " + quantity + ")";
    }
    
}
