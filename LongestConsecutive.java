import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    public static void main(String[] args) {
        LongestConsecutive tester = new LongestConsecutive();
        tester.longestConsecutive(null);
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> valToIndex = new HashMap<>();
        DS ds = new DS(nums.length);
        for (int i=0; i<nums.length; i++) {
           if (valToIndex.containsKey(nums[i])) {
               continue;
           }
           if (valToIndex.containsKey(nums[i] - 1)) {
               ds.union(i, valToIndex.get(nums[i]-1));
           }
           if (valToIndex.containsKey(nums[i] + 1)) {
               ds.union(i, valToIndex.get(nums[i]+1));
           }

           valToIndex.put(nums[i], i);
        }
        return ds.largestConsecutive();
    }
}
