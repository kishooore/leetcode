public class MaximumAverageSubArray {
    public static void main(String[] args) {
        MaximumAverageSubArray subArray = new MaximumAverageSubArray();
        int[] nums = {1, 2};
        int target = 1;
        double avg = subArray.findMaxAverage(nums, target);
        System.out.print(avg);
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i=0; i<k; i++) {
            sum += nums[i];
        }
        int maxSumSoFar = sum;
        for (int i=0, j=k-1;j<nums.length - 1; i++, j++) {
            sum = sum - nums[i] + nums[j+1];
            if (sum > maxSumSoFar) {
                maxSumSoFar = sum;
            }
        }
        return (double)maxSumSoFar/k;
    }
}
