/*
 * DuyDuc94
 */
package Object;

/**
 *
 * @author duy20
 */
public class Customer {
    private String customerCode;
    private String customerName;
    private String phone;

    public Customer() {
    }
    
    public Customer(String customerCode, String customerName, String phone) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.phone = phone;
    }
    
    public String getPrimaryKey() {
        return customerCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{"+ customerCode + " " + customerName+ " " + phone + '}';
    }
    
    
}
