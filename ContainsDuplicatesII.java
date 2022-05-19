import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicatesII {
    public static void main(String[] args) {
        ContainsDuplicatesII tester = new ContainsDuplicatesII();
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.print(tester.containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < k) {
            map.put(nums[right], map.containsKey(nums[right]) ? map.get(nums[right]) + 1 : 1);
            right++;
            if (isValid(map)) return true;
        }
        int i = 0;
        while(i < k) {
            if (isValid(map)) {
                return true;
            } else {
                map.put(nums[left], map.containsKey(left) ? map.get(left) - 1: 0);
                left++;
                right = right < nums.length - 1 ? right+1 : 0;
                i++;
                map.put(nums[right], map.containsKey(right) ? map.get(right) + 1 : 1);
            }
        }
        return false;
    }

    private boolean isValid(Map<Integer, Integer> map) {
        return map.values().stream().filter(e -> e==2).findFirst().isPresent();
    }
}
