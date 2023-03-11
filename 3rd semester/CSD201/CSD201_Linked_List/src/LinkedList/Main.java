package LinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        Node p, q;
        Person x;
        int k;
        String[] a = {"A", "C", "B", "E", "D"};
        int[] b = {9, 5, 17, 5, 8};

        //Checked
        System.out.println("\n1. Test addLast");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
        x = new Person("X", 30);
        linkedList.addLast(x);
        linkedList.traverse();

        //Checked
        System.out.println("\n2. Test searchByName");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
        p = linkedList.searchByName("B");
        if (p == null) {
            System.out.println("Not found");
        } else {
            System.out.println("The person found is");
            linkedList.visit(p);
            System.out.println();
        }

        //Checked
        System.out.println("\n3. Test addFirst");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); //  (A,9) (C,5) (B,17) (E,5) (D,8)
        x = new Person("X", 30);
        linkedList.addFirst(x);
        linkedList.traverse(); // (X,30) (A,9) (C,5) (B,17) (E,5) (D,8)

        //Checked
        System.out.println("\n4. Test insertAfter");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        x = new Person("X", 30);
        q = linkedList.searchByName("B");
        linkedList.insertAfter(q, x);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (X,30) (E,5) (D,8)

        //Checked
        System.out.println("\n5. Test insertBefore");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        x = new Person("X", 30);
        q = linkedList.searchByName("B");
        linkedList.insertBefore(q, x);
        linkedList.traverse(); // (A,9) (C,5) (X,30) (B,17) (E,5) (D,8)

        //Checked
        System.out.println("\n6. Test remove(Node q)");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        q = linkedList.searchByName("B");
        linkedList.remove(q);
        linkedList.traverse(); // (A,9) (C,5) (E,5) (D,8)

        //Checked
        System.out.println("\n7. Test remove(String xName)");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        linkedList.removeByString("B");
        linkedList.traverse(); // (A,9) (C,5) (E,5) (D,8)

        //Checked
        System.out.println("\n8. Test remove(int xAge)");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        linkedList.removeByInteger(5);
        linkedList.traverse(); // (A,9) (B,17) (E,5) (D,8)

        //Checked
        System.out.println("\n9. Test removeAll(int xAge)");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        linkedList.removeAllHave(5);
        linkedList.traverse(); // (A,9) (B,17) (D,8)

        //Checked
        System.out.println("\n10. Test pos(int k)");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        p = linkedList.atPostion(2);
        System.out.println("The person at position 2 is ");
        linkedList.visit(p); // The person at position 2 is  (B,17)
        System.out.println();

        //Checked
        System.out.println("\n11. Test removePos(int k)");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        linkedList.removeAtPosition(2);
        linkedList.traverse(); // (A,9) (C,5) (E,5) (D,8)

        //Checked
        System.out.println("\n12. Test sortByName()");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        linkedList.sortByName();
        linkedList.traverse(); // (A,9) (B,17) (C,5) (D,8) (E,5)

        //Checked
        System.out.println("\n13. Test sortByAge()");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        linkedList.sortByAge();
        linkedList.traverse(); // (C,5) (E,5) (D,8) (A,9) (B,17)

        //Checked
        System.out.println("\n14. Test size()");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        k = linkedList.size();
        System.out.println("Size = " + k);

        //Checked
        System.out.println("\n15. Test toArray()");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        Person[] u = linkedList.toArray();
        if (u != null) {
            for (int i = 0; i < u.length; i++) {
                System.out.print(u[i]); // (A,9) (C,5) (B,17) (E,5) (D,8)
            }
            System.out.println();
        }

        //Checked
        System.out.println("\n16. Test reverse()");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        linkedList.reverse();
        linkedList.traverse(); // (D,8) (E,5) (B,17) (C,5) (A,9)

        //Checked
        System.out.println("\n17. Test findMaxAge()");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        p = linkedList.findMaxAge();
        System.out.println("The person with maximum age:");
        linkedList.visit(p);
        System.out.println();

        //Checked
        System.out.println("\n18. Test findMinAge()");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        p = linkedList.findMinAge();
        System.out.println("The person with minimum age:");
        linkedList.visit(p);
        System.out.println();

        //Checked
        System.out.println("\n19. Test setData()");
        linkedList.clear();
        linkedList.addMany(a, b);
        linkedList.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        p = linkedList.searchByName("B");
        x = new Person("XX", 99);
        linkedList.setData(p, x);
        linkedList.traverse(); // (D,8) (E,5) (XX,99) (C,5) (A,9)

        //Checked
        String[] c = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        int[] d = {9, 8, 7, 6, 15, 4, 3, 2, 1};
        System.out.println("\n20. Test sortByAge(3, 6)");
        linkedList.clear();
        linkedList.addMany(c, d);
        linkedList.traverse(); // (A,9) (B,8) (C,7) (D,6) (E,15) (F,4) (G,3) (H,2) (I,1)
        linkedList.sortByAgeInRange(3, 6);
        linkedList.traverse(); // (A,9) (B,8) (C,7) (G,3) (F,4) (D,6) (E,15) (H,2) (I,1) 

        //Checked
        System.out.println("\n21. Test reverse(3, 7)");
        linkedList.clear();
        linkedList.addMany(c, d);
        linkedList.traverse(); // (A,9) (B,8) (C,7) (D,6) (E,15) (F,4) (G,3) (H,2) (I,1)
        linkedList.reverseInRange(3, 7);
        linkedList.traverse(); // (A,9) (B,8) (C,7) (G,3) (F,4) (E,15) (D,6) (H,2) (I,1) 

        //Addional function

        //Checked
        System.out.println("\n22. Test removeFromHead()");
        linkedList.clear();
        linkedList.addMany(c, d);
        linkedList.traverse(); // (A,9) (B,8) (C,7) (D,6) (E,15) (F,4) (G,3) (H,2) (I,1)
        linkedList.removeHead();
        linkedList.traverse(); // (B,8) (C,7) (D,6) (E,15) (F,4) (G,3) (H,2) (I,1)
        System.out.println();

        //Checked
        System.out.println("\n23. Test removeFromTail()");
        linkedList.clear();
        linkedList.addMany(c, d);
        linkedList.traverse(); // (A,9) (B,8) (C,7) (D,6) (E,15) (F,4) (G,3) (H,2) (I,1)
        linkedList.removeTail();
        linkedList.traverse(); // (A,9) (B,8) (C,7) (D,6) (E,15) (F,4) (G,3) (H,2)
        System.out.println();

        //Checked
    }
}
