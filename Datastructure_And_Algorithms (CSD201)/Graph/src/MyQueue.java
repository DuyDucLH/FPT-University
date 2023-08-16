import java.util.LinkedList;
/*
 * DuyDuc94
 */

/**
 *
 * @author duy20
 */
public class MyQueue {
    
    public LinkedList<Integer> queue;
    
    public MyQueue() {
        queue = new LinkedList<>();
    }
    
    public void clear() {
        queue.clear();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue(Integer x) {
        queue.addLast(x);
    }

    public Integer dequeue() {
        return queue.removeFirst();
    }

    public Integer front() {
        if(isEmpty())
            return null;
        else
            return queue.getFirst();
    }
}
