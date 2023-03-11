import java.util.LinkedList;

public class MyStack {
    public LinkedList<Integer> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }

    public void clear() {
        stack.clear();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(Integer x) {
        stack.addLast(x);
    }

    public Integer pop() {
        if(isEmpty())
            return null;
        else
            return stack.removeLast();
    }

    public Integer top() {
        if(isEmpty())
            return null;
        else
            return stack.getLast();
    }
}
