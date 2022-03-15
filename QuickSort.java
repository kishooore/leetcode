public class QuickSort {
    public static void main(String[] args) {
        QuickSort tester = new QuickSort();
        int[] nums = {10, 80, 30, 90, 40, 50, 70};
        tester.quickSort(nums, 0, nums.length-1);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i]+",");
        }
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l<r) {
            int pi = partition(nums, l, r);
            quickSort(nums, l, pi-1);
            quickSort(nums, pi+1, r);
        }
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int min = l-1;
        for (int i=l; i<=r-1; i++) {
            if (nums[i] < pivot) {
                min++;
                swap(nums, min, i);
            }
        }
        min++;
        swap(nums, min, r);
        return min;
    }

    private void swap(int[] nums, int min, int i) {
        int temp = nums[min];
        nums[min] = nums[i];
        nums[i] = temp;
    }
}
