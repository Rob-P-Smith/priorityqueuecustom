public class MinPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MinPQ(){
        pq = (Key[]) new Comparable[10];
    }
    public MinPQ(int MaxN) {
        pq = (Key[]) new Comparable[MaxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        reSize();
        pq[++N] = v;
        swim(N);
    }

    public Key delMin() {
        Key min = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return min;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swim(int k) {
        while ((k > 1) && (less(k / 2, k))) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private void reSize() {
        if (pq.length - 1 == N) {
            Key[] newPQ = (Key[]) new Comparable[pq.length * 2];
            System.arraycopy(pq, 0, newPQ, 0, pq.length);
            pq = newPQ;
        } else if (pq.length <= N/3){
            Key[] newPQ = (Key[]) new Comparable[pq.length/2];
            System.arraycopy(pq, 0, newPQ, 0, pq.length);
            pq = newPQ;
        }
    }

    @Override
    public String toString() {
        StringBuilder printer = new StringBuilder();
        for (Key val : pq) {
            if (val == null) {
                printer.append("[]");
            } else {
                printer.append("["+val+"]");
            }
        }
        return printer.toString();
    }
}
