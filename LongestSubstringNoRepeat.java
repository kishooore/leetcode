import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestSubstringNoRepeat {

    public static void main(String[] args) {
        LongestSubstringNoRepeat longest = new LongestSubstringNoRepeat();
        String str = "hkcpmprxxxqw";
        int ans = longest.length(str);
        System.out.print(ans);
    }

    public int length(String s) {
        int largestSoFar = 0;
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                int count = map.get(s.charAt(j));
                map.put(s.charAt(j), count + 1);
            } else {
                map.put(s.charAt(j), 1);
            }
            int mapSize = map.size();
            for (Entry<Character, Integer> entry:map.entrySet()) {
                if (entry.getValue() == 0) {
                    mapSize = mapSize - 1;
                }
            }
            if (mapSize == j - i + 1) {
                if (largestSoFar < j - i + 1) {
                    largestSoFar = j - i + 1;
                }
            } else if (mapSize < j - i + 1) {
                while (mapSize < j - i + 1) {
                    int count = map.get(s.charAt(i));
                    map.put(s.charAt(i), count - 1);
                    i++;
                }
            }
            j++;
        }
        return largestSoFar;
    }
}
