import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharacterInAStreamOfCharacters {
    public static void main(String[] args) {
        FirstNonRepeatingCharacterInAStreamOfCharacters tester = new FirstNonRepeatingCharacterInAStreamOfCharacters();
        System.out.println(tester.solve("jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"));
    }

    private String solve(String str) {
        String ans = "";
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> counts = new HashMap<>();
        int i = 0;
        while (i<str.length()) {
            Integer count = counts.get(str.charAt(i));
            if (count != null) {
                counts.put(str.charAt(i), count+1);
            } else {
                counts.put(str.charAt(i), 1);
            }

            if (!queue.isEmpty() && queue.peek() == str.charAt(i)) {
                queue.poll();
            } else {
                queue.add(str.charAt(i));
            }
            while(counts.get(queue.peek()) > 1) {
                queue.poll();
            }
            Character ch = queue.peek() == null ? '#':queue.peek();
            ans += ch;
            i++;
        }
        return ans;
    }
}
