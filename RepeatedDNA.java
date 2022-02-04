import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RepeatedDNA {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAA";
        RepeatedDNA dna = new RepeatedDNA();
        List<String> result = dna.findRepeatedDnaSequences(s);
        System.out.print(result);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0, j=9; j<s.length(); i++, j++) {
            if (map.containsKey(s.substring(i, j+1))) {
                int count = map.get(s.substring(i, j+1));
                map.put(s.substring(i, j+1), count + 1);
            } else {
                map.put(s.substring(i, j+1), 1);
            }
        }
        for (Entry<String, Integer> entry:map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
