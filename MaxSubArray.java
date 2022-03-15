public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray tester = new MaxSubArray();
        int[] nums = {5,4,-1,7,8};
        System.out.print(tester.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[][] dp = new int[nums.length][nums.length];
        for (int i=0; i<nums.length; i++) {
            dp[i][i] = nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int j=1; j<nums.length; j++) {
            for (int i=0; i<nums.length-j; i++) {
                dp[i][i+j] = dp[i][i+j-1] + nums[i+j];
                max = Math.max(max, dp[i][i+j]);
            }
        }
        return max;
    }
}
