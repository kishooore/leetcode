import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ContainsDuplicates {

    public static void main (String[] args) {
        ContainsDuplicates duplicates = new ContainsDuplicates();
        int[] nums = {1};
        int k = 1;
        boolean contains = duplicates.containsNearbyDuplicate(nums, k);
        System.out.print(contains);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1) {
            return true;
        }
        boolean contains = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<=k; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int i=0, j=i+k; j<nums.length-1; i++, j++) {
            //remove head
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]) - 1;
                map.put(nums[i], count);
            }
            //add tail
            if (map.containsKey(nums[j+1])) {
                int count = map.get(nums[j+1]) + 1;
                map.put(nums[j+1], count);
            } else {
                map.put(nums[j+1], 1);
            }
        }
        for (Entry<Integer, Integer> entry:map.entrySet()) {
            if (entry.getValue() > 1) {
                contains = true;
            }
        }
        return contains;
    }
}
