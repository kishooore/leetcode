public class PatternMatch {
    public static void main(String[] args) {
        String[] s1 = {"kishore", "naresh", "suresh", "gopi", "ali", "nanda", "praveen", "tension"};
        String[] s2 = {"nareshh", "sureshh", "gopii", "nanda", "praveen", "time"};
        PatternMatch match = new PatternMatch();
        String[] matched = match.match(s1, s2);
        for (int i=0; i<matched.length; i++) {
            System.out.println(matched[i]);
        }
    }

    private String[] match(String[] s1, String[] s2) {
        int max = 0;
        int start = -1;
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if (s1[i].equals(s2[j])) {
                    int len = compare(s1, s2, i, j);
                    if (len > max) {
                        start = i;
                        max = len;
                    }
                }
            }
        }
        String[] result = new String[max];
        for (int i = 0, j = start; i < max; i++, j++) {
            result[i] = s1[j];
        }
        return result;
    }

    private int compare(String[] s1, String[] s2, int i, int j) {
        int len = 0;
        while (i < s1.length && j < s2.length) {
            if (s1[i].equals(s2[j])) {
                i++;
                j++;
                len++;
            } else {
                break;
            }
        }
        return len;
    }
}
