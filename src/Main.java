import java.util.*;

public class Main {
    public static void main(String[] args) {
        MaxPQ testPQ = new MaxPQ(99);
        Random rand = new Random();
        testPQ.insert(1);
        testPQ.insert(7);
        testPQ.insert(3);
        testPQ.insert(5);
        testPQ.insert(2);
        testPQ.insert(1);
        testPQ.insert(0);
        testPQ.insert(9);
        testPQ.insert(6);
        testPQ.insert(13); //Enable to break the priority queue
        for (int i = 0; i < 20; i++) {
            testPQ.insert(rand.nextInt(0,99));
        }

        List<Integer> sortedByPQ = new ArrayList<>();
        while(!testPQ.isEmpty()){
            Integer i = (Integer) testPQ.delMax();
            sortedByPQ.add(i);

        }
        System.out.println("As delivered:    "+ sortedByPQ);
        Collections.sort(sortedByPQ, Collections.reverseOrder());
        System.out.println("After Java Sort: "+sortedByPQ);
    }
}