package queue;

public class CircularQueue {
    private String[] items;
    private int n;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        if ((tail+1) % n == head) return false;
        items[tail] = item;
        tail = (tail+1) % n;
        return true;
    }

    public String dequeue() {
        if (head == tail) return null;
        String rat = items[head];
        head = (head+1)%n;
        return rat;
    }
}
