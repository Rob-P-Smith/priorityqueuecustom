import java.util.Arrays;

public class MaxPQ<K extends Comparable<K>> {

    private K[] priorityQueue;
    private int size;

    public MaxPQ(int capacity) {
        priorityQueue = (K[]) new Comparable[capacity + 1]; // Binary heap starts from index 1
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(K key) {
        if (size == priorityQueue.length - 1) {
            resize(2 * priorityQueue.length);
        }
        priorityQueue[++size] = key;
        swim(size);
    }

    public K delMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        K max = priorityQueue[1];
        swap(1, size--);
        sink(1);
        priorityQueue[size + 1] = null; // Avoid loitering
        if (size > 0 && size == (priorityQueue.length - 1) / 4) {
            resize(priorityQueue.length / 2);
        }
        return max;
    }

    // Helper methods for maintaining heap property

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    // Helper methods

    private boolean less(int i, int j) {
        return priorityQueue[i].compareTo(priorityQueue[j]) < 0;
    }

    private void swap(int i, int j) {
        K temp = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = temp;
    }

    private void resize(int capacity) {
        K[] temp = Arrays.copyOf(priorityQueue, capacity);
        priorityQueue = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(priorityQueue);
    }
}

