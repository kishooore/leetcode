public class JumpGame2 {
    public static void main(String[] args) {
        JumpGame2 tester = new JumpGame2();
        int[] nums = {2,3,1,1,4};
        boolean res = tester.jump(nums);
        System.out.print(res);
    }

    public boolean jump(int[] nums) {
        return jump(nums, 0);
    }
    
    private boolean jump(int[] nums, int start) {
        if (start >= nums.length - 1) return true;
        if (nums[start] == 0) return false;

        int maxJumpLength = nums[start];
        while (maxJumpLength > 0) {
            if (jump(nums, start+maxJumpLength)) {
                return true;
            }
            maxJumpLength = maxJumpLength - 1;
        }

        return false;
    }
}
