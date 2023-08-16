/*
 * DuyDuc94
 */

/**
 *
 * @author duy20
 */
public class Node {
    public Node left, right;
    public int info;    

    public Node() {
        left = right = null;
    }

    public Node(int info) {
        this.info = info;
        left = right = null;
    }
   
    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
    
    public Node(int info, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.info = info;
    }
    
    @Override
    public String toString() {
        return info + "";
    }
}
