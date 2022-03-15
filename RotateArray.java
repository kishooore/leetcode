public class RotateArray {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {-1,-100,3,99};
        int k = 2;
        rotateArray.rotate(nums, k);
    }

    void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int newPos = (i + k) % nums.length;
            result[newPos] = nums[i];
        }
        for(int i=0; i<result.length; i++) {
            nums[i] = result[i];
        }
    }
}
