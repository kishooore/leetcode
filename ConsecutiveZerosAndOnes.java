public class ConsecutiveZerosAndOnes {

    public static void main(String[] args) {
        ConsecutiveZerosAndOnes tester = new ConsecutiveZerosAndOnes();
        String s = "100110011101";
        System.out.print(tester.count(s));
    }

    public int count(String s) {
        int N = s.length();
        if (N == 1) return 0;
        int i=0;
        int j=1;
        int total=0;

        while(j<N) {
            if (s.charAt(i) != s.charAt(j)) {
                total += explore(s, i, j);
            }
            i++;
            j++;
        }
        return total;
    }

    public int explore(String s, int i, int j) {
        int N = s.length();
        int left = i;
        int right = j;
        int count = 0;
        while (left >= 0 && right < N && s.charAt(i) == s.charAt(left) && s.charAt(j) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
