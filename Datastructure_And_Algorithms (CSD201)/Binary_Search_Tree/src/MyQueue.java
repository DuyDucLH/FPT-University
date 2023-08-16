import java.util.LinkedList;
/*
 * DuyDuc94
 */

/**
 *
 * @author duy20
 */
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
