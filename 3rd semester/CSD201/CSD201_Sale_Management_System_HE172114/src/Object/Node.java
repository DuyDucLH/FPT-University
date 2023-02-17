/*
 * DuyDuc94
 */
package Object;

/**
 *
 * @author duy20
 */
public class Node<T> {
    private Node<T> nextNode;
    private T data;

    public Node(T data) {
        this.data = data;
        this.nextNode = null;
    }

    public Node(Node nextNode, T data) {
        this.nextNode = nextNode;
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Object getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }

    public String getKey(){
        if(data == null){
            return null;
        }
        //If data is an instance of Product, get its ProductCode
        if(data instanceof Product){
            Product product = (Product) data;
            return product.getPrimaryKey();
        }
        ////If data is an instance of Customer, get its CustomerCode
        if(data instanceof Customer){
            Customer customer = (Customer) data;
            return customer.getPrimaryKey();
        }
        return null;
    }
    
    
    
}
