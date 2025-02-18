import java.util.Arrays;

public class DynamicArray { //this should be like a List.
    int[] arr;
    int capacity;
    int size = 0;
    public DynamicArray(int capacity) {
        arr = new int[capacity - 1];
        this.capacity = capacity;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int value) {
        arr[i] = value;
    }

    public void pushback(int n) {
        if (capacity == size) {
            resize();
        }
        arr[capacity - 1] = n;
        size++;
    }

    public int popback() {
        int popped = arr[--size];
        arr[size] = 0;
        return popped;
    }

    public void resize() {
        capacity *= 2;
        arr = Arrays.copyOf(arr, capacity);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }




}
