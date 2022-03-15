import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ArrayIntersection {
    public static void main(String[] args) {
        ArrayIntersection element = new ArrayIntersection();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] result = element.intersection(nums1, nums2);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (counts.containsKey(nums1[i])) {
                counts.put(nums1[i], counts.get(nums1[i]) + 1);
            } else {
                counts.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            Integer count = counts.get(nums2[i]);
            if (count != null) {
                counts.put(nums2[i], --count);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Entry<Integer, Integer> entry:counts.entrySet()) {
            if (entry.getValue() > 1 && entry.getValue() % 2 == 0) {
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
