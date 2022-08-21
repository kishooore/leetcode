package BinarySearch;

public class LeftMostInsert {
    public static void main(String[] args) {
        LeftMostInsert tester = new LeftMostInsert();
        int[] A = {1,2,3,5};
        int result = tester.search(A, 4);
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
            int mid = left + (right - left) / 2;
            if (A[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
