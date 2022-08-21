package BinarySearch;

public class LeftMost {
    public static void main(String[] args) {
        LeftMost tester = new LeftMost();
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

    public int search(int[] A, int x) {
        int left = 0;
        int right = A.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return A[left] == x ? left:-1;
    }
}
