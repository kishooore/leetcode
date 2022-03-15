import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement element = new MajorityElement();
        int[] nums = {3,2,3};
        System.out.print(element.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            Integer count = counts.get(nums[i]);
            count = count != null ? count + 1 : 1;
            counts.put(nums[i], count);
        }
        int majorityElementCount = Integer.MIN_VALUE;
        int majorityElement = Integer.MIN_VALUE;
        for (Entry<Integer, Integer> entry:counts.entrySet()) {
            if (entry.getValue() > majorityElementCount) {
                majorityElementCount = entry.getValue();
                majorityElement = entry.getKey();
            }
        }
        return majorityElement;
    }
}
