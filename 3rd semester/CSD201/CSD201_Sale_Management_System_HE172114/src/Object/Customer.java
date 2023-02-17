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
    
    public Customer(String customerCode, String customerName, String phone) throws Exception{
        if(phone.matches("[0-9]+")){
            this.customerCode = customerCode;
            this.customerName = customerName;
            this.phone = phone;
        }else{
            throw new Exception("Phone must contain only number!");
        }
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

    public void display(){
        System.out.format(" %-5s|  %-9s  |  %-7s\n", getCustomerCode(), getCustomerName(), getPhone());
    }
    
    public String getDataLine(){
        return String.format(" %-5s|  %-9s  |  %-7s\n", getCustomerCode(), getCustomerName(), getPhone());
    }
    
    @Override
    public String toString() {
        return "("+customerCode+" | "+customerName+" | "+phone +")";
    }
    
    
}
