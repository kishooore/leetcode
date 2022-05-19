import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        MaxSlidingWindow test = new MaxSlidingWindow();
        int[] nums = {1, 2};
        int k = 2;
        int[] result = test.maxWindow(nums, k);
        for (int i=0; i<result.length; i++) System.out.print(result[i] + ", ");
    }

    public int[] maxWindow(int[] nums, int k) {
        int N = nums.length;
        int[] result = new int[N-k+1];
        int i = 0;

        int left = 0;
        int right = 0;
        PriorityQueue<Element> maxHeap = new PriorityQueue<>(new ElementComparator());
        while (right < k) {
            maxHeap.offer(new Element(right, nums[right]));
            right++;
        }

        while (right < N) {
            Element peek = maxHeap.peek();
            while(!(peek.position >= left && peek.position <= right)) {
                maxHeap.poll();
                peek = maxHeap.peek();
            }
            result[i] = peek.value;
            i++;
            maxHeap.offer(new Element(right, nums[right]));
            right++;
            left++;
        }
        Element peek = maxHeap.peek();
        while(!(peek.position >= left && peek.position <= right)) {
            maxHeap.poll();
            peek = maxHeap.peek();
        }
        result[i] = peek.value;
        return result;
    }

}
class Element {
    int position;
    int value;

    public Element(int position, int value) {
        this.position = position;
        this.value = value;
    }
}
class ElementComparator implements Comparator<Element> {

    @Override
    public int compare(Element arg0, Element arg1) {
        return Integer.compare(arg1.value, arg0.value);
    }

}
