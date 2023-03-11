package LinkedList;

public class MyLinkedList {

    Node head, tail;
//==============================================================================
    MyLinkedList() {
        head = tail = null;
    }
//==============================================================================
    boolean isEmpty() {
        return (head == null);
    }
//==============================================================================
    void clear() {
        head = tail = null;
    }
//==============================================================================
    //Display node need visit
    void visit(Node needVisit) {
        if (needVisit != null) {
            System.out.print(needVisit.info);
        }
    }
//==============================================================================
    //Traverse and display all node of list
    void traverse() {
        Node current = head;
        while (current != null) {
            visit(current);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
//==============================================================================
    //Add new list from 2 array
    void addMany(String[] a, int[] b) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }
//==============================================================================
    // (1): Add new node to the end of list
    void addLast(Person info) {
        if (info == null) {
            return;
        }
        Node newNode = new Node(info);
        //If list is empty, then add new node to head and tail
        if (isEmpty()) {
            head = tail = newNode;
            //If list is not empty, then add new node to tail
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
//==============================================================================
    // (2): Search and return node that have same valueString
    Node searchByName(String value) {
        Node curr = head;
        while (curr != null) {
            if (curr.info.name.compareTo(value) == 0) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
//==============================================================================
    // (3): Add new node to the head of list
    void addFirst(Person info) {
        if (info == null) {
            return;
        }
        Node newNode = new Node(info);
        //If list is empty, then add new node to head and tail
        if (isEmpty()) {
            head = tail = newNode;
            //If list is not empty, then add new node to head
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
//==============================================================================
    // (4): Add new node after node needInsertAfter
    void insertAfter(Node needInsertAfter, Person info) {
        //If list is empty or node need insert after is null or info is null, then return
        if (isEmpty() || needInsertAfter == null || info == null) {
            return;
        }
        //Declare newNode with info and point to next node of node need insert after
        Node newNode = new Node(info, needInsertAfter.next);
        //Set needInsertAfter to point to newNode
        needInsertAfter.next = newNode;
        //If node need insert after is tail, then set tail to newNode
        if (needInsertAfter == tail) {
            tail = newNode;
        }
    }
//==============================================================================
    // (5): Add new node before node needInsertBefore
    void insertBefore(Node needInsertBefore, Person info) {
        if (isEmpty() || needInsertBefore == null || info == null) {
            return;
        }
        //Declare newNode with info and point to node need insert before
        Node newNode = new Node(info, needInsertBefore);
        Node curr = head, prev = null;
        //Loop until curr is node need insert before
        while (curr != null) {
            if (curr == needInsertBefore) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        //If prev == null that means node needInsertBefore is head, then simply add newNode to head
        if (prev == null) {
            newNode.next = curr;
            head = newNode;
        } else {
            prev.next = newNode;
            newNode.next = curr;
        }
    }
//==============================================================================
    // (6): Remove node from the list
    Node remove(Node needRemove) {
        if (isEmpty() || needRemove == null) {
            return needRemove;
        }
        //If node need remove is head, then remove from head
        if(needRemove == head){
            removeHead();
            return needRemove;
        }
        //If node need remove is tail, then remove from tail
        if(needRemove == tail){
            removeTail();
            return needRemove;
        }
        //If node need remove is not head or tail, then remove from middle
        Node curr = head;
        while (curr != null) {
            //If curr.next is node need remove, then remove it
            if (curr.next.info == needRemove.info) {
                curr.next = curr.next.next;
                return needRemove;
            }
            curr = curr.next;
        }
        return needRemove;
    }
    
    //delete the head and return its info.
    Node removeHead(){
        if(isEmpty()) return null;
        Node deleted = head;
        head = head.next;
     	return deleted;
	}         

    //delete the tail and return its info.
    Node removeTail(){
        Node deleted = tail, curr = head;
        //loop use to traverse list
        while(curr != null){
            //if curr.next is tail, then set curr.next to null and set tail to curr   
            if(curr.next == tail){
                curr.next = null;
                tail = curr;
                return deleted;
            }
            curr = curr.next;
        }
        return null;
    }
//==============================================================================
    // (7): Remove node that have name need to remove
    void removeByString(String nameNeedRemove) {
        if (isEmpty()) {
            return;
        }
        Node curr = head;
        //Loop until find curr that have name equal to nameNeedRemove
        while (curr != null) {
            if (curr.info.name.compareTo(nameNeedRemove) == 0) {
                remove(curr);
                break;
            }
            curr = curr.next;
        }        
    }
//==============================================================================
    // (8): Remove node that have age need remove
    void removeByInteger(int ageNeedRemove) {
        if (isEmpty()) {
            return;
        }
        Node curr = head;
        //Loop until find currNode that have age equal to ageNeedRemove
        while (curr != null) {
            if (curr.info.age == ageNeedRemove) {
                remove(curr);
                break;
            }
            curr = curr.next;
        }
    }
//==============================================================================
    // (9): Remove all node that have the same age value to ageNeedRemove

    void removeAllHave(int ageNeedRemove) {
        if (isEmpty()) {
            return;
        }
        Node curr = head;
        while (curr != null) {
            //If currNode have age equal to ageNeedRemove, then remove it
            if (curr.info.age == ageNeedRemove) {
                //Remove currNode and set curr to next node
                curr = remove(curr).next;
                continue;
            }
            curr = curr.next;
        }
    }
//==============================================================================
    // (10): Return node at the position index
    Node atPostion(int index) {
        if (isEmpty() || index < 0) {
            return null;
        }
        Node currNode = head;
        int indexInLoop = 0;
        //Loop until find node at index
        while (currNode != null) {
            if (indexInLoop == index) {
                return currNode;
            }
            currNode = currNode.next;
            indexInLoop++;
        }
        return null;
    }
//==============================================================================
    // (11): Remove node at the position index
    void removeAtPosition(int index) { 
        if (isEmpty() || index < 0) {
            return;
        }
        remove(atPostion(index));
    }
//==============================================================================
    // (12): Sort (swap only data): sort ascending, less value up to head
    void sortByName() {
        if (isEmpty()) {
            return;
        }
        Person tempInfo;
        Node nodeI = head, nodeJ;
        //Selection sort (swap only data)
        //Loop use to traverse the list. After each loop, node have smallest name (info) will be at head 
        while (nodeI != null) {
            //Loop use to traverse the list from nodeI.next to tail to find node have smallest name (info) and swap it with nodeI
            nodeJ = nodeI.next;
            while (nodeJ != null) {
                //Ascending order of name
                if (nodeI.info.name.compareTo(nodeJ.info.name) > 0) {
                    tempInfo = nodeI.info;
                    nodeI.info = nodeJ.info;
                    nodeJ.info = tempInfo;
                }
                nodeJ = nodeJ.next;
            }
            nodeI = nodeI.next;
        }
        /*
        //Bubble sort (swap only data). Need method atPostion(int index) and size()
        //Loop use to traverse the list. After each loop, node have biggest name (info) will be at tail 
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size()-i-1; j++) {
                //Compare name each pair of node, therefore, when loop finish, node have biggest name (info) will be at tail
                if(atPostion(j).info.name.compareTo(atPostion(j+1).info.name) > 0){
                    tempInfo = atPostion(j).info;
                    atPostion(j).info = atPostion(j+1).info;
                    atPostion(j+1).info = tempInfo;
                }
            }
        } 
        */
    }

    // Sort (swap only data): sort descending, less value down to tail
    void sortByNameInRange(int from, int to) {
        if (isEmpty()) {
            return;
        }
        if(from < 0 || to < 0 || from > to || to > size()) return;
        Person tempInfo;
        for (int i = 0; i < this.size(); i++) {
            for (int j = from; j <  to-i; j++) {
                if(atPostion(j).info.name.compareTo(atPostion(j+1).info.name) > 0){
                    tempInfo = atPostion(j).info;
                    atPostion(j).info = atPostion(j+1).info;
                    atPostion(j+1).info = tempInfo;
                }
            }
        } 
    }
//==============================================================================
    // (13): Sort (swap only data): sort ascending, less value up to head
    void sortByAge() {
        if (isEmpty()) {
            return;
        }
        Person tempInfo;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < this.size() - i - 1; j++) {
                if (atPostion(j).info.age > atPostion(j + 1).info.age) {
                    tempInfo = atPostion(j).info;
                    atPostion(j).info = atPostion(j + 1).info;
                    atPostion(j + 1).info = tempInfo;
                }
            }
        }
    }

    // (20): Sort from position k to position h (the position of the first element is 0)
    void sortByAgeInRange(int from, int to) {
        if (isEmpty()) {
            return;
        }
        if(from < 0 || to < 0 || from > to || to > size()) return;
        Person tempInfo;
        //Require size(), atPosition()
        for (int i = 0; i < this.size(); i++) {
            for (int j = from; j < to - i; j++) {
                if (atPostion(j).info.age > atPostion(j + 1).info.age) {
                    tempInfo = atPostion(j).info;
                    atPostion(j).info = atPostion(j + 1).info;
                    atPostion(j + 1).info = tempInfo;
                }
            }
        }
    }
//==============================================================================
    // (14): Return size of linked list
    int size() {
        if (isEmpty()) {
            return 0;
        }
        Node currNode = head;
        int size = 0;
        while (currNode != null) {
            currNode = currNode.next;
            size++;
        }
        return size;
    }
//==============================================================================
    // (15): Return array of Person
    Person[] toArray() {
        if (isEmpty()) {
            return null;
        }
        Node currNode = head;
        Person[] result = new Person[this.size()];
        int index = 0;
        while (currNode != null) {
            result[index] = currNode.info;
            currNode = currNode.next;
            index++;
        }
        return result;
    }
//==============================================================================
    // (16): Reverse the list, using swap head and tail
    void reverse() {
        if (isEmpty()) {
            return;
        }
        Person tempInfo;
        for (int i = 0, j = this.size() - 1; i < j; i++, j--) {
            tempInfo = atPostion(i).info;
            atPostion(i).info = atPostion(j).info;
            atPostion(j).info = tempInfo;
        }
    }

    // (21): Reverse from position k to position h (the position of the first element is 0) 
    void reverseInRange(int from, int to) {
        if (isEmpty()) {
            return;
        }
        if(from < 0 || to < 0 || from > to || to > size()) return;
        Person tempInfo;
        //Require atPosition()
        for (int i = from, j = to; i < j; i++, j--) {
            tempInfo = atPostion(i).info;
            atPostion(i).info = atPostion(j).info;
            atPostion(j).info = tempInfo;
        }
    }
//==============================================================================
    // (17): Find node have max age
    Node findMaxAge() {
        if (isEmpty()) {
            return null;
        }
        Node currNode = head.next, maxAgeNode = head;
        while (currNode != null) {
            if (currNode.info.age > maxAgeNode.info.age) {
                maxAgeNode = currNode;
            }
            currNode = currNode.next;
        }
        return maxAgeNode;
    }
//==============================================================================
    // (18): Find node have min age
    Node findMinAge() {
        if (isEmpty()) {
            return null;
        }
        Node currNode = head.next, minAgeNode = head;
        while (currNode != null) {
            if (currNode.info.age < minAgeNode.info.age) {
                minAgeNode = currNode;
            }
            currNode = currNode.next;
        }
        return minAgeNode;
    }
//==============================================================================
    // (19): Replace data of node with new data
    void setData(Node needSetData, Person infoReplace) {
        if (isEmpty()) {
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            if (currNode == needSetData) {
                currNode.info = infoReplace;
                break;
            }
            currNode = currNode.next;
        }

    }
//==============================================================================
}
