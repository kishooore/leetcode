import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum tester = new SlidingWindowMaximum();
        int[] nums = {-7,-8,7,5,7,1,6,0};
        int k = 4;
        int[] result = tester.maxSlidingWindow(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = -1;
        int N = nums.length;
        int[] result = new int[N - k + 1];
        int i = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        while (right < k - 1) {
            right++;
            maxHeap.add(nums[right]);
        }
        while (right < N - 1) {
            result[i] = maxHeap.peek();
            i++;
            int peek = maxHeap.peek();
            if (peek == nums[left]) {
                maxHeap.poll();
                peek = maxHeap.peek() == null ? 0 : maxHeap.peek();
            }
            left++;
            right++;
            maxHeap.add(nums[right]);
        }
        result[i] = maxHeap.peek();
        return result;
    }
}
