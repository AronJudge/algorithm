package Stack.ArrayStack;

public class ArrayStack {
    private String[] items; // array
    private int count;     // size of element
    private int n;         // size of stack

    // initial array
    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    // push stack
    public boolean push(String item) {
        if (count == n) return false;
        items[count] = item;
        ++count;
        return true;
    }

    // pop stack
    public String pop() {
        if (count == 0) {
            return null;
        }
        String temp = items[count-1];
        --count;
        return temp;
    }
}
