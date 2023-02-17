/*
 * DuyDuc94
 */
package Object;

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

    @Override
    public String toString() {
        return "Order{"+ productCode+ " " + customerCode+ " " + quantity + '}';
    }
    
}
