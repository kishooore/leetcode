import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    Map<String, Boolean> mem = new HashMap<>();

    public static void main(String[] args) {
        WordBreak tester = new WordBreak();
        tester.wb();
    }

    public void wb() {
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> dict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        System.out.print(wordBreak(str, dict));
    }
    
    public boolean wordBreak(String str, List<String> dict) {
        if (str.length() == 0) return true;

        if (mem.containsKey(str)) {
            return mem.get(str);
        }

        for (int i=0; i<str.length(); i++) {
            if (dict.contains(str.substring(0, i+1))) {
                if (wordBreak(str.substring(i+1), dict)) {
                    mem.put(str, true);
                    return true;
                }
            }
        }
        mem.put(str, false);
        return false;
    }

}
