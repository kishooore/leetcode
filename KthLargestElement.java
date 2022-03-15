import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement tester = new KthLargestElement();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.print(tester.findKthLargest(nums, k));
    }

    private int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x,y) -> Integer.compare(y, x));
        minHeap.offer(Integer.MIN_VALUE);
        for (int i=0; i<nums.length; i++) {
            minHeap.offer(nums[i]);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}
