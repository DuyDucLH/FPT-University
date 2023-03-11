import java.util.*;

/*
 * DuyDuc94.
 */

public class ArrayStack {
    Object[] array; // mảng các phần tử
    int top, max; // top: chỉ số của phần tử cuối, max: kích thước tối đa của stack.

    public ArrayStack() {
    }

    public ArrayStack(int max) {
        this.max = max;
        // Khởi tạo mảng có kích thước max
        array = new Object[max];
        // Khai báo rằng stack chưa có phần tử nào
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1; // Nếu top vẫn là -1, thì stack trống
    }

    public boolean isFull() {
        // Vì bắt đầu từ 0 nên chỉ số của phần tử cuối là max-1
        return top == max - 1;
    }

    public void clear() {
        this.top = -1;
    }

    //Hàm này dùng để mở rộng kích thước của stack lên 1/2 kích thước hiện tại
    public boolean grow() {
        // Tăng kích thước max của stack lên 1/2 kích thước hiện tại
        int newMax = max + max / 2;
        // Khởi tạo mảng mới có kích thước mới
        Object[] newArray = new Object[newMax];
        //
        if (newArray == null)
            return false;
        for (int i = 0; i < top; i++) {
            newArray[i] = array[i];
            array = newArray;
        }
        return true;
    }

    // push an element into a full stack called: underflow
    public void push(Object x) {
        // Nếu stack chưa đầy và mở rộng thành công thì thêm phần tử vào
        if (!isFull() && grow())
            array[++top] = x;
    }

    // pop an empty stack called: overflow
    public Object pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return array[top--];
    }

    // Return top element of stack
    public Object top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    public void insertAtPosition(int index, Object value) { //Chỉ số index bắt đầu tính từ 0
        // Create an temp array use to store element after index-1 position
        ArrayStack arrayTemp = new ArrayStack(max);
        // Get all element after index-1 position need add into temp array
        while (this.top != index - 1) {
            arrayTemp.push(this.pop());
        }
        // Adding new element into index position
        this.push(value);
        // Add all element in temp array back into stack
        while (!arrayTemp.isEmpty()) {
            this.push(arrayTemp.pop());
        }
    }

    public Object deleteAtPosition(int index) { //Chỉ số index bắt đầu tính từ 0
        // Create an temp array
        ArrayStack arrayTemp = new ArrayStack(max);
        // Get all element after index-1 position need add into temp array
        while (this.top != index - 1) {
            arrayTemp.push(this.pop());
        }
        // Delete and get deleted element
        Object deleted = this.pop();
        // Add all element in temp array back into stack
        while (!arrayTemp.isEmpty()) {
            this.push(arrayTemp.pop());
        }
        return deleted;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
