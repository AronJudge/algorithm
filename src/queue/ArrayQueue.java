package queue;

public class ArrayQueue {
    // array : item, size n
    private String[] items;
    private int n = 0;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue (int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
         // tail == n.
        if (tail == n) return false;
        items[tail] = item;
        ++tail;
        return true;
    }

    public String dequeue() {
        if (head == tail) return null;
        String ret = items[head];
        ++head;
        return ret;
    }
}
