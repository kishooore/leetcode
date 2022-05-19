
public class InsertInterval {
    public static void main(String[] args) {
        InsertInterval tester = new InsertInterval();
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {20,23};
        tester.insert(intervals, newInterval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int lower = insertPosition(intervals, newInterval[0]);
        int upper = insertPosition(intervals, newInterval[1]);
        System.out.println("lower: " + lower + " upper: " + upper);
        int[][] inserted = new int[intervals.length+1][2];
        for (int i=0; i<intervals.length; i++) {
            inserted[i] = intervals[i];
        }
        inserted[lower] = newInterval;
        inserted[upper] = newInterval;
        return inserted;
    }
    
    private int insertPosition(int[][] intervals, int low) {
        int start = 0;
        int end = intervals.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            int index = overlap(intervals[mid], low);
            if (index == 0) {
                return mid;
            } else if (index > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    private int overlap(int[] interval, int element) {
        if (element < interval[0] && element < interval[1]) {
            return 1;
        }
        else if (element > interval[0] && element > interval[1]) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
