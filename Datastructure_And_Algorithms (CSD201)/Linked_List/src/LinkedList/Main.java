package LinkedList;
/*
 * DuyDuc94
 */

/**
 *
 * @author duy20
 */
public class Main {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        Node p, q;
        Person x;
        int k;
        String[] a = {"A", "C", "B", "E", "D", "A", "C", "B"};
        int[] b = {9, 5, 17, 5, 8, 6, 4, 12};
        
        linkedList.clear();
        linkedList.addMany(a, b);
        System.out.println("\n1. Test addLast");
        linkedList.traverse();
        x = new Person("X", 30);
        Node test1 = new Node(x);
        linkedList.addLast(test1);
        linkedList.traverse();
        
        linkedList.clear();
        linkedList.addMany(a, b);
        System.out.println("\n2. Test addFirst");
        linkedList.traverse();
        x = new Person("X", 30);
        Node test2 = new Node(x);
        linkedList.addFirst(test2);
        linkedList.traverse();
        
        linkedList.clear();
        linkedList.addMany(a, b);
        System.out.println("\n3. Test insertAtPosition(Node nodeNeedInsert, int index)");
        linkedList.traverse();
        x = new Person("X", 30);
        Node test3 = new Node(x);
        linkedList.insertAtPosition(test3, 0);
        linkedList.traverse();
        
        linkedList.clear();
        linkedList.addMany(a, b);
        System.out.println("\n4. Test insertAtNth(Node nodeNeedInsert, int nth)");
        linkedList.traverse();
        x = new Person("X", 30);
        Node test4 = new Node(x);
        linkedList.insertAtNth(test4, 5);
        linkedList.traverse();
        
        linkedList.clear();
        linkedList.addMany(a, b);
        System.out.println("\n5. Test removeHead()");
        linkedList.traverse();
        linkedList.removeHead();
        linkedList.traverse();
        
        linkedList.clear();
        linkedList.addMany(a, b);
        System.out.println("\n6. Test removeTail()");
        linkedList.traverse();
        linkedList.removeTail();
        linkedList.traverse();
        
        linkedList.clear();
        linkedList.addMany(a, b);
        System.out.println("\n8. Test removeAtPosition(int index)");
        linkedList.traverse();
        linkedList.removeAtPosition(5);
        linkedList.traverse();
        
        linkedList.clear();
        linkedList.addMany(a, b);
        System.out.println("\n10. Test removeNthByInt(int value, int nth)");
        linkedList.traverse();
        linkedList.removeNth(5, 2);
        linkedList.traverse();
        
        linkedList.clear();
        linkedList.addMany(a, b);
        System.out.println("\n12. Test removeAllHaveInt(int value)");
        linkedList.traverse();
        linkedList.removeAllHave(5);
        linkedList.traverse();
        
        linkedList.clear();
        linkedList.addMany(a, b);
        System.out.println("\n14. Test sortFromPosToPosByInt(int from, int to)");
        linkedList.traverse();
        linkedList.sortFromPosToPos(4, 7);
        linkedList.traverse();
        
        linkedList.clear();
        linkedList.addMany(a, b);
        System.out.println("\n15. Test sortFromPosToPosByStringAndInt(int from, int to)");
        linkedList.traverse();
        linkedList.sortFromPosToPosByStringAndInt(2, 7);
        linkedList.traverse();
        
        linkedList.clear();
        linkedList.addMany(a, b);
        System.out.println("\n17. Test sortAllListByInt()");
        linkedList.traverse();
        linkedList.sortAllList();
        linkedList.traverse();
        
        linkedList.clear();
        linkedList.addMany(a, b);
        System.out.println("\n18. Test sortAllListByStringAndInt()");
        linkedList.traverse();
        linkedList.sortAllListByStringAndInt();
        linkedList.traverse();
        
        System.out.println("\n20. Test searchByInt()");
        linkedList.traverse();
        Node test20 = linkedList.search(5);
        System.out.println(test20);
        
        System.out.println("\n22. Test searchNthByString()");
        linkedList.traverse();
        Node test22 = linkedList.searchNth(5, 2);
        System.out.println(test22);
        
        System.out.println("\n23. Test String findMax()");
        linkedList.traverse();
        String maxString = linkedList.findMaxString();
        System.out.println(maxString);
        
        System.out.println("\n24. Test String findMin()");
        linkedList.traverse();
        String minString = linkedList.findMinString();
        System.out.println(minString);
        
        System.out.println("\n23. Test String findMax()");
        linkedList.traverse();
        int maxInt = linkedList.findMaxInt();
        System.out.println(maxInt);
        
        System.out.println("\n24. Test String findMin()");
        linkedList.traverse();
        int minInt = linkedList.findMinInt();
        System.out.println(minInt);
    }
}
