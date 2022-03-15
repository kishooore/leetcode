import java.util.ArrayList;
import java.util.List;

public class MinInSorted {
    public static void main(String[] args) {
        MinInSorted tester = new MinInSorted();
        int[] nums = { 40342, 40766, 41307, 42639, 42777, 46079, 47038, 47923, 48064, 48083, 49760, 49871, 51000, 51035, 53186, 53499, 53895, 59118, 60467, 60498, 60764, 65158, 65838, 65885, 65919, 66638, 66807, 66989, 67114, 68119, 68146, 68584, 69494, 70914, 72312, 72432, 74536, 77038, 77720, 78590, 78769, 78894, 80169, 81717, 81760, 82124, 82583, 82620, 82877, 83131, 84932, 85050, 85358, 89896, 90991, 91348, 91376, 92786, 93626, 93688, 94972, 95064, 96240, 96308, 96755, 97197, 97243, 98049, 98407, 98998, 99785, 350, 2563, 3075, 3161, 3519, 4176, 4371, 5885, 6054, 6495, 7218, 7734, 9235, 11899, 13070, 14002, 16258, 16309, 16461, 17338, 19141, 19526, 21256, 21507, 21945, 22753, 25029, 25524, 27311, 27609, 28217, 30854, 32721, 33184, 34190, 35040, 35753, 36144, 37342 };
        int ans = tester.min(nums);
        System.out.print(ans);
    }

    public int min(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        while (s<e) {
            int m = s+(e-s)/2;
            if (check(nums, m) == 0) {
                return m;
            } else if (check(nums, m) > 1) {
                s = m+1;
            } else {
                e = m-1;
            }
        }
        return 0;
    }

    private int check(int[] nums, int mid) {
        if (mid == 0 && nums[mid] > nums[mid+1]) {
            return 1;
        }
        if (mid == 0 && nums[mid] < nums[mid+1]) {
            return -1;
        }
        if (mid == nums.length-1 && nums[mid] > nums[mid-1]) {
            return -1;
        }
        if (mid == nums.length-1 && nums[mid] < nums[mid-1]) {
            return 1;
        }
        if (nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) {
            return -1;
        }
        if (nums[mid] < nums[mid+1] && nums[mid] > nums[mid-1]) {
            return 1;
        }
        return 0;
    }
}
