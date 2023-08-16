/*
 * DuyDuc94.
 */

/**
 *
 * @author duy20
 */
public class Main {
    
    public static void main(String[] args) {
        MyBinarySreachTree bst = new MyBinarySreachTree();
        int info;
        
        //Set value of tree
//        int[] randomTree = {6,4,8,7,3,2,9,10,1,5};
        int[] randomTree = {6, 3, 7, 1, 4, 8, 2, 5};
        int[] balancedTree = {15, 8, 20, 10, 3, 5, 9, 2, 13, 17, 19, 25, 22, 26, 16};
        
        // bst.addTree(balancedTree, "balanced");
        bst.addTree(randomTree, "random");
        bst.breadthFirstSearch(bst.root);
        System.out.println("");

        // System.out.println("Inorder: ");
        // bst.inOrder(bst.root);
        // //Inorder: 2, 3, 5, 8, 9, 10, 13, 15, 16, 17, 19, 20, 22, 25, 26
        // System.out.println("\n==================================================");
        
        // System.out.println("Preorder: ");
        // bst.preOrder(bst.root);
        // //Preorder: 15, 8, 3, 2, 5, 10, 9, 13, 20, 17, 16, 19, 25, 22, 26
        // System.out.println("\n==================================================");
        
        // System.out.println("Postorder");
        // bst.postOrder(bst.root);
        // //Postorder: 2, 5, 3, 9, 13, 10, 8, 16, 19, 17, 22, 26, 25, 20, 15
        // System.out.println("\n==================================================");
        
        // System.out.println("Breadth First Sreach: ");
        // bst.breadthFirstSearch(bst.root);
        // //Breadth_First Search: 15, 8, 20, 3, 10, 17, 25, 2, 5, 9, 13, 16, 19, 22, 26
        // System.out.println("\n==================================================");
        
        // System.out.print("Tree has " + bst.count(bst.root) + " node");
        // System.out.println("\n==================================================");
        
        // info = 3;
        // System.out.println("Search node have value = " + info + ":");
        // System.out.print(bst.searchInSubtreeOf(bst.root, info));
        // System.out.println("\n==================================================");
        
        // System.out.println("Search father of node have value = " + info + ":");
        // System.out.print(bst.searchFatherOf(bst.searchInSubtreeOf(bst.root, info)));
        // System.out.println("\n==================================================");

        
        // System.out.print("Height of tree: " + bst.heightOf(bst.root));
        // System.out.println("\n==================================================");
        
        // System.out.print("Left Most Node(min value): " + bst.leftMost(bst.root));
        // System.out.println("\n==================================================");
        
        // System.out.print("Right Most Node(max value): " + bst.rightMost(bst.root));
        // System.out.println("\n==================================================");
        
//         info = 5;
//         System.out.println("Delete node (using Copying) has value = " + info);
//         bst.deletionByCopying(bst.searchInSubtreeOf(bst.root, info));
//         bst.breadthFirstSearch(bst.root);
//         System.out.println("\n==================================================");
        
//         info = 3;
//         System.out.println("Delete node (using Merging) has value = " + info);
//         bst.deleteByMerging(bst.searchInSubtreeOf(bst.root, info));
//         bst.breadthFirstSearch(bst.root);
//         System.out.println("\n==================================================");

//        System.out.println("Rotate left node = " + bst.searchByValue(4));
//        bst.rotateLeft(bst.searchByValue(4));
//        bst.breadthFirstSearch(bst.root);
//        System.out.println("\n==================================================");
//
//        bst.balance();
//        bst.breadthFirstSearch(bst.root);
//        System.out.println("\n==================================================");
        
        
    }
}

