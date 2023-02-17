/*
 * DuyDuc94
 */
package Function;

import Object.Customer;
import Object.Node;
import Object.Product;

/**
 *
 * @author duy20
 * @param <T>
 */
public class MyLinkedList<T> {
    Node head, tail;
    
    public MyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }
    
    //Check duplicated of code
    public boolean checkDuplicate(T newData){
        Product newProduct = (Product) newData;
        //Check unique value (check key is already exist or not)
        Node curNode = head;
        while(curNode != null){
            if(newProduct.getPrimaryKey().compareTo(curNode.getKey()) == 0){
                System.out.println("Data has exist! " + newProduct.getPrimaryKey());
                return true;
            }
            curNode = curNode.getNextNode();
        }
        return false;
    }
    
    ////Add new node to the end of list
    public void addLast(T newData){
        if(newData == null){
            return;
        }
        Node newNode = new Node(newData);
        if (isEmpty()) {
            head = tail = newNode;
            System.out.println("Add " + newNode.getData() + " successfully!");
        } else {
            if(!checkDuplicate(newData)){
                tail.setNextNode(newNode);
                tail = newNode;
                System.out.println("Add " + newNode.getData() + " successfully!");
            }
        }
    }
    
    //Traverse and display all node of list
    public void traverseIn(String type) {
        //type: code <=> display code
        //type: product <=> display product
        //type: customer <=> display customer
        Node current = head;
        while (current != null) {
            visitWithFormat(current, type);
            current = current.getNextNode();
        }
    }
    public void visitWithFormat(Node needVisit, String type) {
        if (needVisit != null ) {
            if(type.compareTo("product") == 0){
                Product tempProduct = (Product) needVisit.getData();
                tempProduct.display();
            }
            if(type.compareTo("customer") == 0){
                //...//
            }
            if(type.compareTo("code") == 0){
                Product tempProduct = (Product) needVisit.getData();
                System.out.print(tempProduct.getProductCode() + "->");
            }
        }
    }
    
    //Return String to write file
    public String getData(String type) {
        //type: product <=> write product data
        //type: customer <=> write customer data
        String result = "";
        Node currNode = head;
        while (currNode != null) {
            result += getDataLineOf(currNode, type);
            currNode = currNode.getNextNode();
        }
        return result;
    }
    public String getDataLineOf(Node needVisit, String type) {
        if (needVisit != null ) {
            if(type.compareTo("product") == 0){
                Product tempProduct = (Product) needVisit.getData();
                return tempProduct.getDataLine();
            }
            if(type.compareTo("customer") == 0){
                //...//
            }
        }
        return "";
    }
    
    //Search and return Node has same Code (Key)
    public Node search(String xCode, String type) {
        if(isEmpty()){
            System.out.println("\nList is empty");
            return null;
        }
        //type: product <=> search by product code
        //type: customer <=> search by customer code
        Node currNode = head;
        if(type.compareTo("product") == 0){
            while (currNode != null) {
                Product tempProduct = (Product) currNode.getData();
                if (tempProduct.getPrimaryKey().compareTo(xCode) == 0) return currNode;
                currNode = currNode.getNextNode();
            }
        }
        if(type.compareTo("customer") == 0){
            while (currNode != null) {
                Customer tempCustomer = (Customer) currNode.getData();
                if (tempCustomer.getPrimaryKey().compareTo(xCode) == 0) return currNode;
                currNode = currNode.getNextNode();
            }
        }
        return null;
    }
    
    //Remove node that have code need to delete
    public void delete(String xCode) {     
        this.delete(search(xCode, "product"));
    }
    
    public void deleteAfter(Node node){
        if(node == null){
            System.out.println("\nNot found!");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            if(currNode == node){
                break;
            }
            currNode = currNode.getNextNode();
        }
        if(currNode.getNextNode() == null){
            System.out.println("\nDon't exist its after node!");
            return;
        }
        delete(currNode.getNextNode());
    }
    
    //Remove node from the list
    public void delete(Node needRemove) {   
        //Check if node need delete is exist or not
        if (needRemove == null) {
            System.out.println("\nNot found!");
            return;
        }
        //If list empty, do nothing
        if (isEmpty()) {
            System.out.println("\nList is empty!");
            return;
        }
        Node currNode = head, beforeCurrNode = null;
        //Loop until find currPoint that equal to node needRemove
        while (currNode != null) {
            if (currNode.getData() == needRemove.getData()) break;
            beforeCurrNode = currNode;
            currNode = currNode.getNextNode();
        }
        //If beforeCurrPoint == null that means node needRemove is head, then simply delete the head
        if (beforeCurrNode == null) {
            head = head.getNextNode();
        } else {
            beforeCurrNode.setNextNode(currNode.getNextNode());
        }
        
        Product tempProduct = (Product) needRemove.getData();
        System.out.println("\nDelete " + tempProduct + " successfully!");
    }
    
    //Bubble sort (swap only data): sort ascending, less value up to head
    public void sortByCode() {     
        if (isEmpty()) {
            System.out.println("\nList is empty!");
            return;
        }
        
        Product dataI, dataJ;
        Node NodeI = head, NodeJ;
        
        //Using while
        while (NodeI != null) {          
            dataI = (Product) NodeI.getData();
            NodeJ = NodeI.getNextNode();
            while (NodeJ != null) {                
                //Swap data ascending by name
                dataJ = (Product) NodeJ.getData();
                if(dataI.getProductCode().compareTo(dataJ.getProductCode()) > 0){
                    //Algorithm test
                    //System.out.println(""); this.traverseIn("code");
                    //System.out.print(" - Swap: i:" + dataI.getProductCode() + ", j:" + dataJ.getProductCode());
                    NodeI.setData(dataJ);
                    NodeJ.setData(dataI);
                    dataI = (Product) NodeI.getData();
                    //System.out.print("\nAfter sort: "); this.traverseIn("code");
                    //System.out.println("");
                }
                NodeJ = NodeJ.getNextNode();
            }
            NodeI = NodeI.getNextNode();
        }
        System.out.println("\nComplete the ascending sort by code");
    }
    
    //Return node at the position index
    public Node atPosition(int index) {   
        if (isEmpty()) {
            return null;
        }
        Node currNode = head;
        int indexInLoop = 0;
        while (currNode != null) {
            if (indexInLoop == index) {
                return currNode;
            }          
            currNode = currNode.getNextNode();
            indexInLoop++;
        }
        return null;
    }
    
    //Add new node after current node
    public void insertAfter(Node needInsertAfter, T newData) {    
        if(!checkDuplicate(newData)){
            Node newNode = new Node(newData);
            Node tempNode = needInsertAfter.getNextNode();
            needInsertAfter.setNextNode(newNode);
            newNode.setNextNode(tempNode);
            System.out.println("\nAdd " + newData + " successfully!");
        }
    }
}
    