import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        SubStringWithConcatenationOfAllWords tester = new SubStringWithConcatenationOfAllWords();
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> output = tester.findSubstring(s, words);
        System.out.print(output);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int WS = words.length * words[0].length();
        List<Integer> output = new ArrayList<>();
        int i=0, j=WS;
        while (j<=s.length()) {
            if (matchWords(s.substring(i, i+WS), words, words[0].length())) {
                output.add(i);
            }
            i = i + 1;
            j = j + 1;
        }
        return output;
    }

    public boolean matchWords(String sub, String[] words, int wordSize) {
        int i = 0;
        Map<String, Integer> map = prepareMap(words);
        while (i < sub.length()) {
            String word = sub.substring(i, i+wordSize);
            if (map.containsKey(word) && map.get(word) > 0) {
                Integer count = map.get(word);
                map.put(word, count-1);
            } else {
                return false;
            }
            i = i + wordSize;
        }
        return map.values().stream().filter(e -> e>0).count() == 0;
    }

    public Map<String, Integer> prepareMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word:words) {
            map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
        }
        return map;
    }
}
