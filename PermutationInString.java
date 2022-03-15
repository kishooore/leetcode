import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString string = new PermutationInString();
        String s1 = "dcda";
        String s2 = "adc";
        boolean present = string.isPresent(s1, s2);
        System.out.print(present);
    }

    public boolean isPresent(String s1, String s2) {
        boolean result = false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            if (map.containsKey(s2.charAt(i))) {
                int count = map.get(s2.charAt(i));
                map.put(s2.charAt(i), count + 1);
            } else {
                map.put(s2.charAt(i), 1);
            }
        }
        int i = 0;
        int j = 0;
        while (j < s2.length()) {
            if (map.containsKey(s1.charAt(j))) {
                int count = map.get(s1.charAt(j));
                map.put(s1.charAt(j), count - 1);
            }
            j++;
        }
        while (j < s1.length()) {
            int mapSize = map.size();
            for (Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 0) {
                    mapSize = mapSize - 1;
                }
            }
            if (mapSize == 0) {
                result = true;
                break;
            } else if (mapSize > 0) {
                if (map.containsKey(s1.charAt(i))) {
                    int i_count = map.get(s1.charAt(i));
                    map.put(s1.charAt(i), i_count + 1);
                }
                i++;
                if (map.containsKey(s1.charAt(j))) {
                    int j_count = map.get(s1.charAt(j));
                    map.put(s1.charAt(j), j_count - 1);
                }
                j++;
            }
        }

        return result;
    }
}
