public class BinarySearchV2 {
    public static void main(String[] args) {
        BinarySearchV2 tester = new BinarySearchV2();
        int[] nums = {1,2,2,2,3,3,3,3,3,4,5,6,7};
        int target = 3;
        System.out.println(tester.floor(nums, target));
        System.out.println(tester.ceiling(nums, target));
    }

    private int floor(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private int ceiling(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                ans = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
