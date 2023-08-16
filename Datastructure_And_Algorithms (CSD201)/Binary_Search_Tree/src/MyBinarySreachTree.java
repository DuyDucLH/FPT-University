import java.util.ArrayList;
/*
 * DuyDuc94
 */

/**
 *
 * @author duy20
 */
public class MyBinarySreachTree {

    public Node root;

    public MyBinarySreachTree() {
        root = null;
    }

    public MyBinarySreachTree(Node root) {
        this.root = root;
    }

    void clear(){
        root = null;
    }
    
    public boolean isEmpty() {
        return root == null;
    }

    public void addTree(int[] type, String typeTree) {
        System.out.println("Add " + typeTree + " tree");
        for (int i = 0; i < type.length; i++) {
            this.insert(new Node(type[i]));
        }
    }

    //Insert new node with info into binary tree
    public void insert(Node newNode) {
        //If tree is empty, set new node = root
        if (isEmpty()) {
            root = newNode;
            return;
        }
        Node curr = root;
        while (curr != null) {
            //If tree already have node has the same info, deny insert it
            if (curr.info == newNode.info) {
                return;
            }
            //If new node is less than current node, get into left node, else get into right node
            if (newNode.info < curr.info) {
                if (curr.left == null) {
                    curr.left = newNode;
                    return;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right = newNode;
                    return;
                } else {
                    curr = curr.right;
                }
            }
        }
    }

    //Print out info of node need visit
    public void visit(Node nodeNeedVisit) {
        System.out.print(nodeNeedVisit.info + " ");
    }
    
//========================Depth-First Traversal=================================
    //Left -> Root -> Right
    public void inOrder(Node travelNode) {
        if (travelNode != null) {
            inOrder(travelNode.left);
            visit(travelNode);
            inOrder(travelNode.right);
        }
    }

    //Root -> Left -> Right
    public void preOrder(Node travelNode) {
        if (travelNode != null) {
            visit(travelNode);
            preOrder(travelNode.left);
            preOrder(travelNode.right);
        }
    }

    //Left ->  Right -> Root
    public void postOrder(Node travelNode) {
        if (travelNode != null) {
            postOrder(travelNode.left);
            postOrder(travelNode.right);
            visit(travelNode);
        }
    }
    
//========================Breadth-First Traversal===============================1
    public void breadthFirstSearch(Node travelNode) {
        if (travelNode == null) {
            return;
        }
        MyQueue queue = new MyQueue();
        queue.enqueue(travelNode);
        Node tempNode;
        while (!queue.isEmpty()) {
            tempNode = queue.dequeue();
            visit(tempNode);
            if (tempNode.left != null) {
                queue.enqueue(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.enqueue(tempNode.right);
            }
        }
    }
    
    Node searchByValue(int info){
        Node curr = root;
        while(curr != null){
            if(curr.info == info){
                return curr;
            }
            if(info > curr.info){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
        return null;
    }
  
    public Node searchInSubtreeOf(Node travelNode, int info) {
        if (travelNode.info == info) {
            return travelNode;
        }
        if (info > travelNode.info && travelNode.right != null) {
            return searchInSubtreeOf(travelNode.right, info);
        }
        if (info < travelNode.info && travelNode.left != null) {
            return searchInSubtreeOf(travelNode.left, info);
        }
        return null;
    }

    public Node searchFatherOf(Node travelNode) {
        if(travelNode == root || travelNode == null) return null;
        Node fp = null, p = root;
        while (p != null) {
            if (p.info == travelNode.info) {
                break;
            }
            fp = p;
            if (travelNode.info < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return fp;
    }

    //Count number of node in tree
    public int count(Node travelNode) {
        if (travelNode == null) {
            return 0;
        }
        return 1 + count(travelNode.left) + count(travelNode.right);
    }

    //Count level of node
    public int heightOf(Node travelNode) {
        if (travelNode == null) {
            return 0;
        } else {
            int lDepth = heightOf(travelNode.left);// compute the depth of each subtree
            int rDepth = heightOf(travelNode.right);
            if (lDepth > rDepth) {
                return (lDepth + 1);// use the larger one
            } else {
                return (rDepth + 1);
            }
        }
    }

    public Node leftMost(Node p) {
        Node leftMostNode = p;
        while (leftMostNode.left != null) {
            leftMostNode = leftMostNode.left;
        }
        return leftMostNode;
    }

    public Node rightMost(Node p) {
        Node rightMostNode = p;
        while (rightMostNode.right != null) {
            rightMostNode = rightMostNode.right;
        }
        return rightMostNode;
    }

    /*
     * Delete in binary searchInSubtreeOf tree with 3 cases:
     * 1. Node need delete is leaf node (no child): delete it (unlink it from its parent)
     * 2. Node need delete has only one child: delete it and replace it with its child (link its child to its parent)
     * 3. Node need delete has 2 children: two methods:
     *      - Deletion by copying:
     *          + Find the leftmost node in the right subtree of the node need delete (minimum node in the right subtree) or find the rightmost node in the left subtree of the node need delete (maximum node in the left subtree)
     *          + Copy the info of the leftmost node to the node need delete
     *          + Delete the leftmost node
     *      - Deletion by merging:
     *          + Find the rightmost node in the left subtree of the node need delete (maximum node in the left subtree)
     *          + Link right sub tree of node need delete to right child of rightmost node in the left subtree
     *          + Replace node need delete with left sub tree of node need delete
     */

    public void deleteByCopying(Node nodeNeedDelete) {
        //If tree is empty or node need delete is null
        if (isEmpty() || nodeNeedDelete == null) return;
        Node fp, p;
        fp = null;
        p = root;
        //Search p and fp (p is node need delete, fp is father node of p)
        while (p != null) {
            if (p.info == nodeNeedDelete.info) break;
            fp = p;
            if (nodeNeedDelete.info < p.info) p = p.left;
            else p = p.right;
        }
        //Can not found node have same info
        if (p == null) return;
        //If p is a leaf node (no child)
        if (p.left == null && p.right == null) {
            //If p is root (fp still null), then delete tree
            if (fp == null){
                root = null;
            }else{
                //Check if p is left or right child of fp, then delete p
                if (p == fp.left) fp.left = null;
                else fp.right = null;
            }
            return;            
        }
        //If p has left child only
        if (p.left != null && p.right == null) {
            //If p is root (fp still null), then replace root with left child of p
            if (fp == null){
                root = p.left;
            }else{
                //Check if p is left or right child of fp, then replace p with left child of p
                if (p == fp.left) fp.left = p.left;
                else fp.right = p.left;
            }
            return;
        }
        //If p has right child only
        if (p.left == null && p.right != null) {
            //If p is root (fp still null), then replace root with right child of p
            if (fp == null) {
                root = p.right;
            } else {
                //Check if p is left or right child of fp, then replace p with right child of p
                if (p == fp.left) fp.left = p.right;
                else fp.right = p.right;
            }
            return;
        }
        //If p has both 2 child (replace p with rightMost node(max value) of 
        //left sub-tree of p)
        if (p.left != null && p.right != null) {
            //Get root of left sub-tree of p
            Node leftSubRoot = p.left;
            // find the right-most node in the left sub-tree
            Node frp = null, rp = leftSubRoot;  //rp: rightMost node, frp: father of rp
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            //Copy value of rightMost to p
            p.info = rp.info;
            //If frp still null that means left-sub-tree of p don't have any child
            if (frp == null) { // rightMost == leftRootSubTreeOfp
                p.left = leftSubRoot.left;
            } else {
                frp.right = rp.left;
            }
        }
    }

    //merge delete
    //tìm node phải nhất của con trái của node mà mình muốn xoá, xong đó móc cây con phải của node mình muốn xoá vào bên phải của node phải nhất đó, móc cây con trái vừa tạo vào cây chính thay thế cho node muốn xoá
    public void deleteByMerging(Node nodeNeedDelete) {
        if (isEmpty() || nodeNeedDelete == null) return;
        Node fp, p;
        p = root;
        fp = null;
        //Search p and fp (p is node need delete, fp is father node of p)
        while (p != null) {
            if (p.info == nodeNeedDelete.info) {
                break;
            }
            fp = p;
            if (nodeNeedDelete.info < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //Can not found node have same info
        if (p == null) {
            return;
        }
        //If p is a leaf node (no child)
        if (p.left == null && p.right == null) {
            //If p is root (fp still null), then delete tree
            if (fp == null){
                root = null;
            }else{
                //Check if p is left or right child of fp, then delete p
                if (p == fp.left) fp.left = null;
                else fp.right = null;
            }
            return;            
        }
        //If p has left child only
        if (p.left != null && p.right == null) {
            //If p is root (fp still null), then replace root with left child of p
            if (fp == null){
                root = p.left;
            }else{
                //Check if p is left or right child of fp, then replace p with left child of p
                if (p == fp.left) fp.left = p.left;
                else fp.right = p.left;
            }
            return;
        }
        //If p has right child only
        if (p.left == null && p.right != null) {
            //If p is root (fp still null), then replace root with right child of p
            if (fp == null) {
                root = p.right;
            } else {
                //Check if p is left or right child of fp, then replace p with right child of p
                if (p == fp.left) fp.left = p.right;
                else fp.right = p.right;
            }
            return;
        }
        //If p has both 2 child
        if (p.left != null && p.right != null) {
            Node rp, leftSubRoot = p.left;
            //Find the right-most node in the left sub-tree
            rp = rightMost(leftSubRoot);
            //Link right child of p to right child of rp
            rp.right = p.right;
            //If p is root (fp still null), then replace root with left sub-tree of p
            if(fp == null){
                root = leftSubRoot;
            }else{
                ////Check if p is left or right child of fp, then replace p with left sub-tree of p
                if(p == fp.right) fp.right = leftSubRoot;
                else fp.left = leftSubRoot;
            }
        }
    }
    
    public void inOrder(ArrayList list, Node travelNode) {
        if (travelNode != null) {
            inOrder(travelNode.left);
            list.add(travelNode.info);
            inOrder(travelNode.right);
        }
    }
    
    void balance() {
        ArrayList<Integer> t = new ArrayList();
        inOrder(t, root);
        clear();
        int n = t.size();
        balance(t, 0, n - 1);
    }
    
    void balance(ArrayList<Integer> array, int first, int last) {
        if (first <= last) {
            int mid = (first + last) / 2;
            int newInfo = (int) array.get(mid);
            insert(new Node(newInfo));
            balance(array, first, mid - 1);
            balance(array, mid + 1, last);
        }
    }
    
    Node rotateLeft(Node par) {
        if (par == null || par.right == null) {
            return null;
        }
        //Rotate left
        Node ch = par.right;
        par.right = ch.left;
        ch.left = par;
        //Set node
        if (searchFatherOf(par) == null) {
            root = ch;
        }else if (searchFatherOf(par).left == par) {
            searchFatherOf(par).left = ch;
        } else {
            searchFatherOf(par).right = ch;
        }
        return ch;
    }
    
    Node rotateRight(Node par) {
        if (par == null || par.left == null) {
            return null;
        }
        //Rotate right
        Node ch = par.left;
        par.left = ch.right;
        ch.right = par;
        //Set node
        if (searchFatherOf(par) == null) {
            root = ch;
        }else if (searchFatherOf(par).left == par) {
            searchFatherOf(par).left = ch;
        } else {
            searchFatherOf(par).right = ch;
        }
        return ch;
    }
    
    /**
     * Rotate binary tree node with left child. For AVL trees, this is a single
     * rotation for case 1.
     */
    static Node rotateWithLeftChild(Node k2) {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    //tree.root = rotateWithRightChild(tree.root);
    static Node rotateWithRightChild(Node k2) {
        Node k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        return k1;
    }
    
}
