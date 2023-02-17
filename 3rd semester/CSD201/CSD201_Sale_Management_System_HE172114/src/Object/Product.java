/*
 * DuyDuc94
 */
package Object;


/**
 *
 * @author duy20
 */
public class Product {
    private String productCode;
    private String productName;
    private int quantity;
    private int saled;
    private double price;

    public String getPrimaryKey(){
        return productCode;
    }
    
    public Product() {
    }
    
    public Product(String productCode, String productName, int quantity, int saled, double price) throws Exception{
        if(saled <= quantity){
            this.productCode = productCode;
            this.productName = productName;
            this.quantity = quantity;
            this.saled = saled;
            this.price = price;
        }else{
            throw new Exception("(saled:"+saled+" > quantity:"+quantity+")!");
        }
    }
    
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSaled() {
        return saled;
    }

    public void setSaled(int saled) {
        this.saled = saled;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    //Has sold
    public double getValue(){
        return getPrice() * getSaled();
    }

    public void display(){
        System.out.format(" %-4s|   %-10s|     %-7d|   %-5d|  %-8.1f|   %-6.1f\n", getProductCode(), getProductName(), getQuantity(), getSaled(), getPrice(), getValue());
    }
    
    public String getDataLine(){
        return String.format(" %-4s|   %-10s|     %-7d|   %-5d|  %-8.1f|   %-6.1f\n", getProductCode(), getProductName(), getQuantity(), getSaled(), getPrice(), getValue());
    }
    
    @Override
    public String toString() {
        return "("+productCode+"|"+productName+"|"+quantity+"|"+saled+"|"+price+")";
    }
}
