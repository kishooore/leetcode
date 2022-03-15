public class LCM  {
    public static void main(String[] args) {
        LCM  lcm = new LCM ();
        int[] nums = {2, 7, 3, 9, 4};
        int ans = lcm.of(nums);
        System.out.print(ans);
    }

    public int of(int[] nums) {
        int max = nums[0];
        for (int i=1; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int multiplier = 1;
        for (int i=0;i<nums.length; i++) {
            while(multiplier*max % nums[i] != 0) multiplier += 1;
        }
        System.out.println(max);
        System.out.println(multiplier);
        return max*multiplier;
    }
}
