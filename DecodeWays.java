import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        DecodeWays tester = new DecodeWays();
        System.out.print(tester.numDecodings("2*"));
    }

    public int numDecodings(String s) {
        if ("".equals(s)) return 1;
        if (s.charAt(0) == '0') return 0; 
        if (s.length() == 1 && s.charAt(0) != '*') return 1;

        int ways = 0;
        if (s.charAt(0) == '*') {
            int i = 9;
            while (i > 0) {
                ways = ways + numDecodings(s.substring(1));
                i--;
            }
        } else {
            ways = numDecodings(s.substring(1));
        }

        if (s.charAt(0) == '1' && s.charAt(1) == '*') {
            int i = 9;
            while (i > 0) {
                ways = ways + numDecodings(s.substring(2));
                i--;
            }
        } else if (s.charAt(0) == '2' && s.charAt(1) == '*') {
            int i = 6;
            while (i > 0) {
                ways = ways + numDecodings(s.substring(2));
                i--;
            }
        } else if (Integer.valueOf(s.substring(0, 2)) < 27) {
            ways = ways + numDecodings(s.substring(2));
        }
        return ways;
    }
}
