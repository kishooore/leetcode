import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeSubstring2 {
    Map<String, String> memo = new HashMap<>();

    public static void main(String[] args) {
        LongestPalindromeSubstring2 tester = new LongestPalindromeSubstring2();
        System.out.print(tester.longestPalindrome("civilwartestingwhetherthatnaptionoaaranynaraationsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

    public String longestPalindrome(String str) {
        if (memo.containsKey(str)) return memo.get(str);
        if (str.length() == 0 || str.length() == 1) return str;
        if (str.charAt(0) == str.charAt(str.length() -1 )) {
            String innerStr = longestPalindrome(str.substring(1, str.length()-1));
            if (innerStr.length() + 2 == str.length()) {
                memo.put(str, str);
                return str;
            }
        }
        String innerStr = longestPalindrome(str.substring(1, str.length()-1));
        String leftStr = longestPalindrome(str.substring(0, str.length()-1));
        String rightStr = longestPalindrome(str.substring(1, str.length()));
        String res = leftStr.length() > rightStr.length() ? leftStr:rightStr;
        res = res.length() > innerStr.length() ? res:innerStr;
        memo.put(str, res);
        return res;
    }

    public int longestPalindromeTab(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int i=0; i<str.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i=0; i<str.length()-1; i++) {
            dp[i][i+1] = str.charAt(i) == str.charAt(i+1) ? 2:1;
        }
        for (int i=0; i<str.length()-2; i++) {
            for (int j=2; j<str.length(); j++) {
                dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 + dp[i+1][j-1] : dp[i+1][j-1];
            }
        }
        return dp[0][str.length()-1] > dp[1][str.length()-2] ? dp[0][str.length()-1]:dp[1][str.length()-2];
    }
}
