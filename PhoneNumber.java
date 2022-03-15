import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {
    Map<Character, String> map = new HashMap<>();

    public static void main(String[] args) {
        PhoneNumber tester = new PhoneNumber();
        tester.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return Collections.emptyList();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        recurse(digits, 0, "", ans);
        return ans;
    }

    public void recurse(String digits, int pos, String prefix, List<String> ans) {
        if (pos == digits.length()) {
            ans.add(prefix);
            return;
        }
        Character digit = digits.charAt(pos);
        String letters = map.get(digit);
        for (Character letter:letters.toCharArray()) {
            recurse(digits, pos+1, prefix+letter, ans);
        }
    }
}
