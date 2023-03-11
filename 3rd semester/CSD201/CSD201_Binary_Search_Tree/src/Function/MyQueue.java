package Function;

import Object.Node;
import java.util.LinkedList;

public class MyQueue {

    public LinkedList<Node> queue;

    public MyQueue() {
        queue = new LinkedList();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue(Node x) {
        queue.addLast(x);
    }

    public Node dequeue() {
        return queue.poll();
    }
}
