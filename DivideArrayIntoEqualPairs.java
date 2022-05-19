import java.util.HashMap;
import java.util.Map;

public class DivideArrayIntoEqualPairs {
    public static void main(String[] args) {
        DivideArrayIntoEqualPairs tester = new DivideArrayIntoEqualPairs();
        int[] nums = {18,19,5,5,18,19,5,6,12,19,13,4,16,11,4,16,10,8,12,8,2,1,8,17,4,18,3,5,16,2,16,12,17,16,7,16,2,17,19,9,1,20,17,17,4,6};
        boolean ans = tester.divideArray(nums);
        System.out.print(ans);
    }

    boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
        }
        return !map.values().stream().filter(e -> e%2 == 1).findFirst().isPresent();
    }
}
