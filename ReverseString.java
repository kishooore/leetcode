public class ReverseString {
    public static void main(String[] args) {
        ReverseString tester = new ReverseString();
        char[] string = { 'h', 'e', 'l', 'l', 'o' };
        tester.reverse(string);
    }

    public void reverse(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public void reverseRecursion(char[] s, int i, int j) {
        int size = j - i + 1;
        if (size == 0 || size == 1) {
            return;
        }
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        i++;
        j--;
        reverseRecursion(s, i, j);
    }
}
