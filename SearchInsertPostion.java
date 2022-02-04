
public class SearchInsertPostion {
    public static void main(String[] args) {
        SearchInsertPostion postion = new SearchInsertPostion();
        int[] nums = {1,3,5};
        int target = 0;
        int result = postion.searchInsert(nums, target);
        System.out.print(result);
    }

    public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}
