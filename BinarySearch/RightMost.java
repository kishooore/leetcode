package BinarySearch;

public class RightMost {
    public static void main(String[] args) {
        RightMost tester = new RightMost();
        int[] A = {1,2,3,4};
        int result = tester.search(A, 5);
        System.out.println(result);
        A = new int[]{1,2,3,4,5};
        result = tester.search(A, 4);
        System.out.println(result);
        A = new int[]{1,2,3,4,4,4,5};
        result = tester.search(A, 4);
        System.out.println(result);
    }

    private int search(int[] A, int x) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int mid = left + 1 + (right - left) / 2;
            if (A[mid] > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return A[left] == x ? left : -1;
    }
}
