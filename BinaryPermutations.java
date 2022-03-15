public class BinaryPermutations {
    public static void main(String[] args) {
        BinaryPermutations tester = new BinaryPermutations();
        tester.permutate("", "", 4);
    }

    void permutate(String s, String suffix, int n) {
        if (n == 0) {
            System.out.println(s+suffix);
            return;
        }
        permutate(s + suffix, "0", n-1);
        permutate(s + suffix, "1", n-1);
    }
}
