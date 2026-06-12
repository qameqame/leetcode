import java.util.PriorityQueue;

public class KthLargestClass {
    private final int k;
    private final PriorityQueue<Integer> minHeap;

    public KthLargestClass(int k, int[] nums){
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int num: nums){
            add(num);
        }
    }
    public int add(int val){
        minHeap.offer(val);
        if(minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args){
        int k =3;
        int[] initialScores = {4, 5, 8, 2};
        KthLargestClass kthLargest = new KthLargestClass(k, initialScores);

        System.out.printf("%-10s %-35s %-15s %-10s%n", "add(val)", "All scores (desc)", "3rd largest", "Expected");
        System.out.println("-".repeat(75));

        testAdd(kthLargest,  3, "8, 5, 4, 3, 2",              4);
        testAdd(kthLargest,  5, "8, 5, 5, 4, 3, 2",           5);
        testAdd(kthLargest, 10, "10, 8, 5, 5, 4, 3, 2",       5);
        testAdd(kthLargest,  9, "10, 9, 8, 5, 5, 4, 3, 2",    8);
        testAdd(kthLargest,  4, "10, 9, 8, 5, 5, 4, 4, 3, 2", 8);

    }
    private static void testAdd(KthLargestClass obj, int val, String sortedDesc, int expected) {
        int result = obj.add(val);
        String status = (result == expected) ? "PASS" : "FAIL";
        System.out.printf("add(%-3d)   [%-33s]  %-15d %s%n", val, sortedDesc, result, status);
    }
}
