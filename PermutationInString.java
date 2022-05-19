import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString string = new PermutationInString();
        String s2 = "bcba";
        String s1 = "cbb";
        boolean present = string.checkInclusion(s1, s2);
        System.out.print(present);
    }

    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int N = s2.length();
        Map<Character, Integer> map = countMap(s1);        
        int left = 0;
        int right = 0;
        while (right < k) {
            if (map.containsKey(s2.charAt(right))) {
                int count = map.get(s2.charAt(right));
                map.put(s2.charAt(right), count - 1);
            }
            right++;
        }
        if (isValid(map)) return true;
        while (right < N) {
            if (map.containsKey(s2.charAt(left))) {
                map.put(s2.charAt(left), map.get(s2.charAt(left)) + 1);
            }
            if (map.containsKey(s2.charAt(right))) {
                map.put(s2.charAt(right), map.get(s2.charAt(right)) - 1);
            }
            if (isValid(map)) return true;
            left++;
            right++;
        }
        return false;
    }

    public Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c:s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        return map;
    }

    public boolean isValid(Map<Character, Integer> map) {
        for (Integer value:map.values()) {
            if (value > 0) return false;
        }
        return true;
    }
}
