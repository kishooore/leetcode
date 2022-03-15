public class MergeSort {
    public static void main(String[] args) {
        MergeSort tester = new MergeSort();
        int[] nums = {4, 6, 9, 3, 2, 1};
        tester.sort(nums, 0, nums.length-1);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    private void merge(int[] nums, int l, int m, int r) {
        int[] L = new int[m-l+1];
        int[] R = new int[r-m];

        for (int i=0; i<L.length; i++) {
            L[i] = nums[l+i];
        }

        for (int i=0; i<R.length; i++) {
            R[i] = nums[m+1+i];
        }

        int i=0, j=0;
        int k = l;
        while (i<L.length && j<R.length) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                k++;
                i++;
            } else {
                nums[k] = R[j];
                k++;
                j++;
            }
        }

        while (i<L.length) {
            nums[k] = L[i];
            k++;
            i++;
        }

        while (j<R.length) {
            nums[k] = R[j];
            k++;
            j++;
        }
    }

    private void sort(int[] nums, int l, int r) {
        if(l < r) {
            int m = l+(r-l)/2;
            sort(nums, l,m);
            sort(nums, m+1, r);
            merge(nums, l, m, r);
        }
    }
}
