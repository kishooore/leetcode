
public class SquareRootOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        SquareRootOfSortedArray array = new SquareRootOfSortedArray();
        array.sortedSquares(nums);
    }

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        for (int i=0, j=nums.length-1, k=nums.length - 1 ; i <= j ; k--) {
            if (nums[i]*-1 >= nums[j]) {
                result[k] = nums[i] * nums[i];
                i++;
            } else {
                result[k] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }
}
