public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome tester = new ValidPalindrome();
        tester.isPalindrome("A man, a plan, a canal: Panama");
    }

    public boolean isPalindrome(String s) {
        //s = s.toLowerCase();
        System.out.println(s);

        int N = s.length();
        int i = 0;
        while (i < N && !isAlphaNumeric(s.charAt(i))) {
            i++;
        }
        int j = N - 1;
        while (j >= 0 && !isAlphaNumeric(s.charAt(j))) {
            j--;
        }
        if (j - i + 1 <= 1)
            return true;
        int first = s.charAt(i);
        if (first >= 'a' && first <= 'z') {
            first = first - 'a';
        }
        if (first >= 'A' && first <= 'Z') {
            first = first - 'A';
        }
        int sec = s.charAt(j);
        if (sec >= 'a' && sec <= 'z') {
            sec = sec - 'a';
        }
        if (sec >= 'A' && sec <= 'Z') {
            sec = sec - 'A';
        }
        if (first == sec) {
            return isPalindrome(s.substring(i + 1, j));
        }
        return false;
    }

    private boolean isAlphaNumeric(Character c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}
