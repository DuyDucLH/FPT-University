/*
 * DuyDuc94.
 */
public class ArrayQueue {
    Object[] array;
    int size, front, rear;
    // size: số lượng phần tử tối đa, front: vị trí đầu, front: vị trí cuối

    public ArrayQueue() {
    }

    public ArrayQueue(int max) {
        array = new Object[max];
        size = 0;
        clear();
    }

    public void clear() {
        front = rear = -1;
    }

    public boolean isEmpty() {
        return size == 0; //front == -1;
    }

    public boolean isFull() {
        return size == array.length; //rear == array.length - 1;
    }

    public boolean grow() {
        int i, j;
        int max1 = size + size / 2;
        Object[] a1 = new Object[max1];
        if (a1 == null)
            return (false);
        if (rear >= front)
            for (i = front; i <= rear; i++)
                a1[i - front] = array[i];
        else {
            for (i = front; i < size; i++)
                a1[i - front] = array[i];
            for (j = 0; j <= rear; j++)
                a1[i + j] = array[j];
        }
        array = a1;
        size = max1;
        int count;
        if (front <= rear)
            count = rear - front + 1;
        else
            count = size - front + rear;
        front = 0;
        rear = count - 1;
        return (true);
    }

    public void enqueue(Object value) {
        if (isFull() && !grow())
            return;
        //If there is space left in the array, the 'rear' variable is incremented by 1 and then wrapped around using the modulo operator (%) to ensure that it stays within the bounds of the array. This allows us to treat the array as a circular buffer.
        rear = (rear + 1) % array.length;
        array[rear] = value;
        size++;
    }

    public Object dequeue() throws Exception {
        // Nếu Queue rỗng
        if (isEmpty())
            throw new Exception();
        Object value = array[front];
        front = (front + 1) % array.length;
        size--;
        return value;
    }
}
