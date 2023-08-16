package LinkedList;
/*
 * DuyDuc94
 */

/**
 *
 * @author duy20
 */
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

    void visit(Node needVisit) {
        if (needVisit != null) {
            System.out.print(needVisit.info);
        }
    }
//==============================================================================

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
            addLast(new Node(new Person(a[i], b[i])));
        }
    }
//==============================================================================

    void addLast(Node nodeNeedInsert) {
        if (nodeNeedInsert == null) {
            return;
        }
        //If list is empty, then add new node to head and tail
        if (isEmpty()) {
            head = tail = nodeNeedInsert;
            //If list is not empty, then add new node to tail
        } else {
            tail.next = nodeNeedInsert;
            tail = nodeNeedInsert;
        }
    }

    void addFirst(Node nodeNeedInsert) {
        if (nodeNeedInsert == null) {
            return;
        }
        //If list is empty, then add new node to head and tail
        if (isEmpty()) {
            head = tail = nodeNeedInsert;
            //If list is not empty, then add new node to head
        } else {
            nodeNeedInsert.next = head;
            head = nodeNeedInsert;
        }
    }

    void insertAtPosition(Node nodeNeedInsert, int index) {
        if (nodeNeedInsert == null || index < 0) {
            return;
        }
        int indexInLoop = 0;
        Node curr = head, prev = null;
        while (curr != null) {
            if (indexInLoop == index) {
                if (prev == null) {
                    addFirst(nodeNeedInsert);
                    return;
                }
                prev.next = nodeNeedInsert;
                nodeNeedInsert.next = curr;
            }
            indexInLoop++;
            prev = curr;
            curr = curr.next;
        }
    }

    void insertAtNth(Node nodeNeedInsert, int nth) {
        if (nodeNeedInsert == null || nth < 1) {
            return;
        }
        int indexInLoop = 0;
        Node curr = head, prev = null;
        while (curr != null) {
            if (indexInLoop == (nth - 1)) {
                if (prev == null) {
                    addFirst(nodeNeedInsert);
                    return;
                }
                prev.next = nodeNeedInsert;
                nodeNeedInsert.next = curr;
            }
            indexInLoop++;
            prev = curr;
            curr = curr.next;
        }
    }

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

    Node removeHead() {
        if (isEmpty()) {
            return null;
        }
        Node deleted = head;
        head = head.next;
        return deleted;
    }

    Node removeTail() {
        if (isEmpty()) {
            return null;
        }
        Node deleted = tail, curr = head;
        while (curr != null) {
            //if curr.next is tail, then set curr.next to null and set tail to curr   
            if (curr.next == tail) {
                curr.next = null;
                tail = curr;
                return deleted;
            }
            curr = curr.next;
        }
        return null;
    }

    Node remove(Node needRemove) {
        if (isEmpty() || needRemove == null) {
            return needRemove;
        }
        if (needRemove == head) {
            removeHead();
            return needRemove;
        }
        if (needRemove == tail) {
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

    void removeAtPosition(int index) {  //need atPosition()
        if (isEmpty() || index < 0) {
            return;
        }
        remove(atPostion(index));
    }

    Node removeNth(int value, int nth) {
        Node deleted = null;
        int count = 0;
        Node curr = head;
        while (curr != null) {
            if (curr.info.age == value) {
                count++;
                if (count == nth) {
                    deleted = curr;
                    remove(curr);
                    return deleted;
                }
            }
            curr = curr.next;
        }
        return deleted;
    }

    void removeAllHave(int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.info.age == value) {
                curr = remove(curr).next;
                continue;
            }
            curr = curr.next;
        }
    }
//==============================================================================

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

    Node atPostion(int index) {
        if (isEmpty() || index < 0) {
            return null;
        }
        Node currNode = head;
        int indexInLoop = 0;
        while (currNode != null) {
            if (indexInLoop == index) {
                return currNode;
            }
            currNode = currNode.next;
            indexInLoop++;
        }
        return null;
    }

    void sortFromPosToPos(int from, int to) {//the position of the first element is 0
        if (isEmpty() || from < 0 || to < 0 || from > to || to > size()) {
            return;
        }
        /*Change object*/ Person tempInfo;
        for (int i = 0; i < this.size(); i++) {
            for (int j = from; j < to - i; j++) {
                //Ascending: >
                //Descending: <
                //Change condition
                if (atPostion(j).info.age > atPostion(j + 1).info.age) {
                    tempInfo = atPostion(j).info;
                    atPostion(j).info = atPostion(j + 1).info;
                    atPostion(j + 1).info = tempInfo;
                }
            }
        }
    }

    void sortFromPosToPosByStringAndInt(int from, int to) { //the position of the first element is 0
        if (isEmpty() || from < 0 || to < 0 || from > to || to > size()) {
            return;
        }
        /*Change object*/ Person tempInfo;
        //Change 'name' and 'age' follow question
        for (int i = 0; i < this.size(); i++) {
            for (int j = from; j < to - i; j++) {
                //Ascending: >
                //Descending: <
                if (atPostion(j).info.name.compareTo(atPostion(j + 1).info.name) > 0) {
                    tempInfo = atPostion(j).info;
                    atPostion(j).info = atPostion(j + 1).info;
                    atPostion(j + 1).info = tempInfo;
                } else if (atPostion(j).info.name.compareTo(atPostion(j + 1).info.name) == 0) {
                    //Ascending: >
                    //Descending: <
                    if (atPostion(j).info.age > atPostion(j + 1).info.age) {
                        tempInfo = atPostion(j).info;
                        atPostion(j).info = atPostion(j + 1).info;
                        atPostion(j + 1).info = tempInfo;
                    }
                }
            }
        }
    }

    void sortAllList() {
        if (isEmpty()) {
            return;
        }
        /*Change Object*/ Person tempInfo;
        //Change 'age' follow question
        Node nodeI = head, nodeJ;
        while (nodeI != null) {
            nodeJ = nodeI.next;
            while (nodeJ != null) {
                //Ascending: >
                //Descending: <
                if (nodeI.info.age > nodeJ.info.age) {
                    tempInfo = nodeI.info;
                    nodeI.info = nodeJ.info;
                    nodeJ.info = tempInfo;
                }
                nodeJ = nodeJ.next;
            }
            nodeI = nodeI.next;
        }
    }

    void sortAllListByStringAndInt() {
        if (isEmpty()) {
            return;
        }
        /*Change Object*/ Person tempInfo;
        //Change 'name' and 'age' follow question
        Node nodeI = head, nodeJ;
        while (nodeI != null) {
            nodeJ = nodeI.next;
            while (nodeJ != null) {
                //Ascending: >
                //Descending: <
                if (nodeI.info.name.compareTo(nodeJ.info.name) > 0) {
                    tempInfo = nodeI.info;
                    nodeI.info = nodeJ.info;
                    nodeJ.info = tempInfo;
                } else if (nodeI.info.name.compareTo(nodeJ.info.name) == 0) {
                    //Ascending: >
                    //Descending: <
                    if (nodeI.info.age > nodeJ.info.age) {
                        tempInfo = nodeI.info;
                        nodeI.info = nodeJ.info;
                        nodeJ.info = tempInfo;
                    }
                }
                nodeJ = nodeJ.next;
            }
            nodeI = nodeI.next;
        }
    }
//==============================================================================

    Node search(int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.info.age == value) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    Node searchNth(int value, int nth) {
        Node curr = head;
        int count = 0;
        while (curr != null) {
            if (curr.info.age == value) {
                count++;
                if (count == nth) {
                    return curr;
                }
            }
            curr = curr.next;
        }
        return null;
    }

    public int getIndexOf(Node needSearch) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.info == needSearch.info) {
                break;
            }
            index++;
            curr = curr.next;
        }
        return index;
    }
//==============================================================================

    String findMaxString() {
        String max = head.info.name;
        Node curr = head;
        while (curr != null) {
            if (curr.info.name.compareTo(max) > 0) {
                max = curr.info.name;
            }
            curr = curr.next;
        }
        return max;
    }

    String findMinString() {
        String min = head.info.name;
        Node curr = head;
        while (curr != null) {
            if (curr.info.name.compareTo(min) < 0) {
                min = curr.info.name;
            }
            curr = curr.next;
        }
        return min;
    }

    int findMaxInt() {
        int max = head.info.age;
        Node curr = head;
        while (curr != null) {
            if (curr.info.age > max) {
                max = curr.info.age;
            }
            curr = curr.next;
        }
        return max;
    }

    int findMinInt() {
        int min = head.info.age;
        Node curr = head;
        while (curr != null) {
            if (curr.info.age < min) {
                min = curr.info.age;
            }
            curr = curr.next;
        }
        return min;
    }

    Node findNodeMaxNthString(int nth) {
        if (nth < 1) {
            return null;
        }
        int count = 0;
        Node curr = head;
        while (curr != null) {
            if (curr.info.name.compareTo(findMaxString()) == 0) {
                if (count == (nth - 1)) {
                    return curr;
                }
                count++;
            }
            curr = curr.next;
        }
        return null;
    }

    Node findNodeMinNthString(int nth) {
        if (nth < 1) {
            return null;
        }
        int count = 0;
        Node curr = head;
        while (curr != null) {
            if (curr.info.name.compareTo(findMinString()) == 0) {
                if (count == (nth - 1)) {
                    return curr;
                }
                count++;
            }
            curr = curr.next;
        }
        return null;
    }

    Node findNodeMaxNthInt(int nth) {
        if (nth < 1) {
            return null;
        }
        int count = 0;
        Node curr = head;
        while (curr != null) {
            if (curr.info.age == findMaxInt()) {
                if (count == (nth - 1)) {
                    return curr;
                }
                count++;
            }
            curr = curr.next;
        }
        return null;
    }

    Node findNodeMinNthInt(int nth) {
        if (nth < 1) {
            return null;
        }
        int count = 0;
        Node curr = head;
        while (curr != null) {
            if (curr.info.age == findMinInt()) {
                if (count == (nth - 1)) {
                    return curr;
                }
                count++;
            }
            curr = curr.next;
        }
        return null;
    }
//==============================================================================

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

    void reverseInRange(int from, int to) {
        if (isEmpty()) {
            return;
        }
        if (from < 0 || to < 0 || from > to || to > size()) {
            return;
        }
        Person tempInfo;
        //Require atPosition()
        for (int i = from, j = to; i < j; i++, j--) {
            tempInfo = atPostion(i).info;
            atPostion(i).info = atPostion(j).info;
            atPostion(j).info = tempInfo;
        }
    }
//==============================================================================

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
}
