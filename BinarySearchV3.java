public class BinarySearchV3 {
    public static void main(String[] args) {
        BinarySearchV3 tester = new BinarySearchV3();
        int[] nums = {1,3,5,6};
        int target = 7;
        int result = tester.search(nums, target);
        System.out.print(result);
    }

    private int search(int[] nums, int target) {
        int N = nums.length;
        int start = 0;
        int end = N - 1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (mid+1 < N && nums[mid] <= target && target <= nums[mid+1]) {
                return mid + 1;
            } else if (mid-1 >= 0 && nums[mid-1] <= target && target <= nums[mid]) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return target < nums[0] ? 0 : nums.length; 
    }
}
