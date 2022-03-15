
public class SmallerOrEqual {
    public static void main(String[] args) {
        SmallerOrEqual tester = new SmallerOrEqual();
        int[] nums = {};
        int target = 43;
        int count = tester.solve(nums, target);
        System.out.print(count);
    }

    public int solve(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end + 1;
    }
}
