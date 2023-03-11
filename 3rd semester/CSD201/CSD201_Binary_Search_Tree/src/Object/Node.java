package Object;

/*
 * DuyDuc94.
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

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getInfo() {
        return info;
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
