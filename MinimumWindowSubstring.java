import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring tester = new MinimumWindowSubstring();
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        String ans = tester.minWindow(s, t);
        System.out.print(ans);
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> table = lookup(t);
        int left=0;
        int right=-1;
        String minWindow = "";
        while (true) {
            if (isValid(table)) {
                if ("".equals(minWindow) || minWindow.length() > right - left + 1) {
                    minWindow = s.substring(left, right+1);
                }
                if (table.containsKey(s.charAt(left)))
                    table.put(s.charAt(left), table.get(s.charAt(left)) + 1);
                left++;
            } else if (right < s.length()-1){
                right++;
                if (table.containsKey(s.charAt(right)))
                    table.put(s.charAt(right), table.get(s.charAt(right)) - 1);
            } else {
                break;
            }
        }
        return minWindow;
    }

    private boolean isValid(Map<Character, Integer> table) {
        return !table.values().stream().filter(e -> e > 0).findFirst().isPresent();
    }

    private Map<Character, Integer> lookup(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c:t.toCharArray()) 
            map.put(c, map.containsKey(c) ? map.get(c) + 1: 1);
        return map;
    }
}
