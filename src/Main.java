import java.util.*;

public class Main {
    public static void main(String[] args) {
        MaxPQ testPQ = new MaxPQ(99);
        MinPQ testMinPQ = new MinPQ(99);
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            int newRand = rand.nextInt(0, 99);
            testPQ.insert(newRand);
            testMinPQ.insert(newRand);
        }

        List<Integer> sortedByPQ = new ArrayList<>();
        while(!testPQ.isEmpty()){
            Integer i = (Integer) testPQ.delMax();
            sortedByPQ.add(i);
        }

        List<Integer> sortedByMinPQ = new ArrayList<>();
        while(!testMinPQ.isEmpty()){
            Integer i = (Integer) testMinPQ.delMin();
            sortedByMinPQ.add(i);
        }


        System.out.println("As delivered:             "+ sortedByPQ);
        Collections.sort(sortedByPQ, Collections.reverseOrder());
        System.out.println("After Reversed Java Sort: "+sortedByPQ);

        System.out.println("As delivered:    "+ sortedByMinPQ);
        Collections.sort(sortedByMinPQ);
        System.out.println("After Java Sort: "+sortedByMinPQ);
    }
}