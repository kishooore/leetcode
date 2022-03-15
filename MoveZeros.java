
public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = {0,1,0,3,12};
        moveZeros.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]!=0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        for (int i=insertPos; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.print(nums);
    }
}
