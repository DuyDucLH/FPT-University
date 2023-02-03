
public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    // (1)
    void addLast(Person x) {    //Add new node to the end of list
        Node newNode = new Node(x);
        if (isEmpty()) {    //If empty add node to head
            head = tail = newNode;
            return;
        }
        //Else add new node after tail
        tail.next = newNode;
        tail = newNode;
    }

    //Display node need visit to console
    void visit(Node needVisit) {
        if (needVisit != null) {
            System.out.print(needVisit.info);
        }
    }

    //Traverse and display all node of list
    void traverse() {
        Node current = head;
        while (current != null) {
            visit(current);
            current = current.next;
        }
        System.out.println();
    }

    //Add new list from 2 array
    void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }

    // (2)
    Node searchByName(String nameOfNode) {   //Search and return node that have name
        Node currPoint = head;
        while (currPoint != null) {
            if (currPoint.info.name.equals(nameOfNode)) {
                return currPoint;
            }
            currPoint = currPoint.next;
        }
        return null;
    }

    // (3)
    void addFirst(Person x) {       //Add new node to the head of list
        Node newNode = new Node(x);
        if (isEmpty()) head = tail = newNode;
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    // (4)
    void insertAfter(Node needInsertAfter, Person x) {    //Add new node after current node
        Node newNode = new Node(x);
        if(isEmpty()) head = tail = newNode;
        Node temp = needInsertAfter.next;
        needInsertAfter.next = newNode;
        newNode.next = temp;
    }

    // (5)
    void insertBefore(Node needInsertBefore, Person x) {   //Add new node before current node
        Node newNode = new Node(x);
        if (isEmpty()) head = tail = newNode;
        Node currPoint = head, beforeCurrPoint = null;
        //Loop until current node is node before node need insert before
        while (currPoint != null) {            
            if (currPoint.info == needInsertBefore.info) break;
            beforeCurrPoint = currPoint;
            currPoint = currPoint.next;
        }
        //If beforeCurrPoint == null that means node needInsertBefore is head, then simply add newNode to head
        if(beforeCurrPoint != null){
            beforeCurrPoint.next = newNode;
            newNode.next = currPoint;
        }else{
            newNode.next = currPoint;
            head = newNode;
        }
    }

    // (6)
    void remove(Node needRemove) {   //Remove node from the list
        //Check if node need remove is exist or not
        if(needRemove == null) return;
        
        Node currPoint = head, beforeCurrPoint = null;
        
        //If list empty, do nothing
        if (isEmpty()) return;
        
        //Loop until find currPoint that equal to node needRemove
        while (currPoint != null) { 
            if (currPoint.info == needRemove.info ) break;
            beforeCurrPoint = currPoint;
            currPoint = currPoint.next;
        }
        
        //If beforeCurrPoint == null that means node needRemove is head, then simply delete the head
        if(beforeCurrPoint != null){
            beforeCurrPoint.next = currPoint.next;
        }else{
            head = head.next;
        }
    }

    // (7)
    void remove(String nameNeedRemove) {     //Remove node that have name need to remove
        if (isEmpty()) return;
        Node currPoint = head;
        //Break until current node is node before node that have name need remove
        while(currPoint != null){
            if(currPoint.info.name.compareTo(nameNeedRemove) == 0) break;
            currPoint = currPoint.next;
        }
        //Remove node
        remove(currPoint);
    }

    // (8)
    void remove(int ageNeedRemove) {     //Remove node that have age need remove
        if (isEmpty()) return;
        Node currPoint = head;
        while (currPoint != null) {            
            if(currPoint.info.age == ageNeedRemove) break;
            currPoint = currPoint.next;
        }
        //Remove node
        remove(currPoint);
    }

    // (9)
    void removeAll(int ageNeedRemove) {     //Remove all node that have the same age value to ageNeedRemove
        if (isEmpty()) return;
        Node currPoint = head, beforeCurrPoint = null;
        while (currPoint != null) {            
            if(currPoint.info.age == ageNeedRemove){
                //Remove node 
                currPoint = currPoint.next;
                //If beforeCurrPoint == null that means node needRemove is head, then simply delete the head
                if(beforeCurrPoint != null){
                    remove(beforeCurrPoint.next);
                }else{
                    remove(head);
                }
                continue;
            }
            beforeCurrPoint = currPoint;
            currPoint = currPoint.next;
        }
    }

    // (10)
    Node pos(int index) {   //Return node at the position index
        if (isEmpty()) return null;
        Node currPoint = head; 
        int i = 0;
        while (currPoint != null) {
            if (i == index) return currPoint;
//            System.out.println(currPoint + " at " + i);            
            currPoint = currPoint.next; i++;
        }
        return null;
    }

    // (11)
    void removePos(int index) { //Remove node at index using above function
        if (isEmpty()) return;
        remove(pos(index));
    }

    // (12)
    void sortByName() {     //Bubble sort (swap only data): sort ascending, less value up to head
        if (isEmpty()) return;
        Person tempInfo;
        
        //Using while
//        Node beforeCurrPoint = head, currPoint;
//        while (beforeCurrPoint != null) {          
//            currPoint = beforeCurrPoint.next;
//            while (currPoint != null) {                
//                //Swap data ascending by name
//                if(beforeCurrPoint.info.name.compareTo(currPoint.info.name) > 0){
//                    tempInfo = beforeCurrPoint.info;
//                    beforeCurrPoint.info = currPoint.info;
//                    currPoint.info = tempInfo;
//                }
//                currPoint = currPoint.next;
//            }
//            beforeCurrPoint = beforeCurrPoint.next;
//        }
        
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size()-i-1; j++) {
                if(pos(j).info.name.compareTo(pos(j+1).info.name) > 0){
                    tempInfo = pos(j).info;
                    pos(j).info = pos(j+1).info;
                    pos(j+1).info = tempInfo;
                }
            }
        }
    }

    // (13)
    void sortByAge() {
        if (isEmpty()) return;
        Person tempInfo;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size()-i-1; j++) {
                if(pos(j).info.age > pos(j+1).info.age){
                    tempInfo = pos(j).info;
                    pos(j).info = pos(j+1).info;
                    pos(j+1).info = tempInfo;
                }
            }
        }
    }

    // (14)
    int size() {
        if (isEmpty()) return 0;
        Node currPoint = head;
        int size = 0;
        while (currPoint != null) {            
            currPoint = currPoint.next; size++;
        }
        return size;
    }

    // (15)
    Person[] toArray() {
        if (isEmpty()) return null;
        Node currPoint = head;
        Person[] result = new Person[this.size()];
        int index = 0;
        while (currPoint != null) {            
            result[index] = currPoint.info;
            currPoint = currPoint.next; index++;
        }
        return result;
    }

    // (16)
    void reverse() {        //Reverse the list, using swap head and tail
        if (isEmpty()) return;
        Person tempInfo;
        for (int i = 0, j = this.size()-1; i < j; i++, j--) {
            tempInfo = pos(i).info;
            pos(i).info = pos(j).info;
            pos(j).info = tempInfo;
        }
    }

    // (17) 
    Node findMaxAge() {     
        if (isEmpty()) return null;
        Node currPoint = head.next, maxAgeNode = head;
        while (currPoint != null) {            
            if (currPoint.info.age > maxAgeNode.info.age) {
                maxAgeNode = currPoint;
            }
            currPoint = currPoint.next;
        }
        return maxAgeNode;
    }

    // (18) 
    Node findMinAge() {
        if (isEmpty()) return null;
        Node currPoint = head.next, minAgeNode = head;
        while (currPoint != null) {            
            if (currPoint.info.age < minAgeNode.info.age) {
                minAgeNode = currPoint;
            }
            currPoint = currPoint.next;
        }
        return minAgeNode;
    }

    // (19) 
    void setData(Node needSetData, Person infoReplace) {    //Replace data of node with new data
        if (isEmpty()) return;
        Node currPoint = head;
        while (currPoint != null) {            
            if(currPoint == needSetData){
                currPoint.info = infoReplace;
                break;
            }
            currPoint = currPoint.next;
        }
        
    }

    // (20) 
    void sortByAge(int from, int to){ // Sort from position k to position h (the position of the first element is 0)
        if (isEmpty()) return;
        Person tempInfo;
        for (int i = 0; i < this.size(); i++) {
            for (int j = from; j < to-i; j++) {
                if(pos(j).info.age > pos(j+1).info.age){
                    tempInfo = pos(j).info;
                    pos(j).info = pos(j+1).info;
                    pos(j+1).info = tempInfo;
                }
            }
        }
    }

    // (21) 
    void reverse(int from, int to){ // reverse from position k to position h (the position of the first element is 0) 
        if (isEmpty()) return;
        Person tempInfo;
        for (int i = from, j = to; i < j; i++, j--) {
            tempInfo = pos(i).info;
            pos(i).info = pos(j).info;
            pos(j).info = tempInfo;
        }
    }
}
