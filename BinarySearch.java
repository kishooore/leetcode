
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = 13;
        int index = binarySearch.search(nums, target);
        System.out.print(index);
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return search(nums, target, start, end);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start == end && target != nums[start]) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target > nums[mid]) {
            start = mid + 1;
            return search(nums, target, start, end);
        } else {
            end = mid - 1;
            return search(nums, target, start, end);
        }
    }
}
