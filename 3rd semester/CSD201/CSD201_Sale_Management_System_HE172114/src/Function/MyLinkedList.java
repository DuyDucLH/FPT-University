/*
 * DuyDuc94
 */
package Function;

import Object.Customer;
import Object.Node;
import Object.Order;
import Object.Product;

/**
 *
 * @author duy20
 * @param <T>
 */
public class MyLinkedList<T> {

    Node<T> head, tail;

    public MyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    //Check duplicated by code (key)
    public boolean checkDuplicate(T newData) {
        Node<T> needCheck = new Node<>(newData);
        Node<T> curNode = head;
        while (curNode != null) {
            if (curNode.getKey().compareTo(needCheck.getKey()) == 0) {
                System.out.println("\nData has exist! " + needCheck.getKey());
                return true;
            }
            curNode = curNode.getNextNode();
        }
        return false;
    }

    public boolean checkDuplicate(String needCheck) {
        Node<T> curNode = head;
        while (curNode != null) {
            if (curNode.getKey().compareTo(needCheck) == 0) {
                System.out.println("\nData has exist! " + needCheck);
                return true;
            }
            curNode = curNode.getNextNode();
        }
        return false;
    }

    ////Add new node to the end of list
    public void addLast(T newData) {
        if (newData == null) {
            return;
        }
        Node<T> newNode = new Node<>(newData);
        if (isEmpty()) {
            head = tail = newNode;
            System.out.println("Add " + newNode.getData() + " successfully!");
        } else {
            if (!checkDuplicate(newData)) {
                tail.setNextNode(newNode);
                tail = newNode;
                System.out.println("Add " + newNode.getData() + " successfully!");
            }
        }
    }

    //Traverse and display all node of list
    public void traverse() {
        Node<T> current = head;
        while (current != null) {
            printWithFormat(current);
            current = current.getNextNode();
        }
    }

    public void printWithFormat(Node needVisit) {
        if (needVisit != null) {
            if (needVisit.getData() instanceof Product) {
                Product tempProduct = (Product) needVisit.getData();
                tempProduct.display();
            }
            if (needVisit.getData() instanceof Customer) {
                Customer tempCustomer = (Customer) needVisit.getData();
                tempCustomer.display();
            }
            if (needVisit.getData() instanceof Order) {
                Order tempOrder = (Order) needVisit.getData();
                tempOrder.display();
            }
        }
    }

    //Return String to write file
    public String getData() {
        String result = "";
        Node<T> currNode = head;
        while (currNode != null) {
            result += getDataLineOf(currNode);
            currNode = currNode.getNextNode();
        }
        return result;
    }

    public String getDataLineOf(Node needVisit) {
        if (needVisit != null) {
            if (needVisit.getData() instanceof Product) {
                Product tempProduct = (Product) needVisit.getData();
                return tempProduct.getDataLine();
            }
            if (needVisit.getData() instanceof Customer) {
                Customer tempCustomer = (Customer) needVisit.getData();
                return tempCustomer.getDataLine();
            }
        }
        return "";
    }

    //Search and return Node has same Code (Key)
    public Node search(String xCode) {
        if (isEmpty()) {
            System.out.println("\nList is empty");
            return null;
        }
        Node currNode = head;
        while (currNode != null) {
            if (currNode.getKey().compareTo(xCode) == 0) {
                return currNode;
            }
            currNode = currNode.getNextNode();
        }
        return null;
    }

    //Remove node that have code need to delete
    public void delete(String xCode) {
        this.delete(search(xCode));
    }

    public void deleteAfter(Node node) {
        if (node == null) {
            System.out.println("\nNot found!");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            if (currNode == node) {
                break;
            }
            currNode = currNode.getNextNode();
        }
        if (currNode.getNextNode() == null) {
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
            if (currNode.getData() == needRemove.getData()) {
                break;
            }
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

        Node NodeI = head, NodeJ, tempNode = new Node(null);

        //Using while
        while (NodeI != null) {
            NodeJ = NodeI.getNextNode();
            while (NodeJ != null) {
                //Swap data ascending by name
                if (NodeI.getKey().compareTo(NodeJ.getKey()) > 0) {
                    tempNode.setData(NodeI.getData());
                    NodeI.setData(NodeJ.getData());
                    NodeJ.setData(tempNode.getData());
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
        if (!checkDuplicate(newData)) {
            Node newNode = new Node(newData);
            Node tempNode = needInsertAfter.getNextNode();
            needInsertAfter.setNextNode(newNode);
            newNode.setNextNode(tempNode);
            System.out.println("\nAdd " + newData + " successfully!");
        }
    }

    public void subtractQuantityOrder(String pCode, int quantityOrder){
        Product tempProduct = (Product) search(pCode).getData();
        try {
            search(pCode).setData(new Product(tempProduct.getProductCode(), tempProduct.getProductName(), tempProduct.getQuantity(), tempProduct.getSaled()+quantityOrder, tempProduct.getPrice()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }  
}


