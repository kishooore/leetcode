import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = { 2, 7 };
        int target = 9;
        int[] result = twoSum.twoSumTwoPointers(nums, target);
        System.out.print(result[0] + ", " + result[1]);
    }

    public int[] twoSumTwoPointers(int[] nums, int target) {

        int[] result = new int[2];

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return result;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = i + 1;
                result[1] = map.get(nums[i]) + 1;
                break;
            }
        }
        return result;
    }
}
