public class JumpGame {
    public static void main(String[] args) {
        JumpGame game = new JumpGame();
        int[] nums = {2,3,1,1,4};
        int totalJumps = game.jump(nums, 0);
        System.out.print(totalJumps);
    }

    public int jump(int[] nums, int start) {
        if (start == nums.length-1) {
            return 0;
        }
        int maxSteps = nums[start];
        int minJumps = Integer.MAX_VALUE;
        int index = 1;
        while (maxSteps != 0) {
            if (nums[start+index] != 0) {
                minJumps = Math.min(minJumps, 1 + jump(nums, start+index));
                maxSteps--;
                index++;
            }
        }
        return minJumps;
    }
}
