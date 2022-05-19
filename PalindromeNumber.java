public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber test = new PalindromeNumber();
        System.out.print(test.isPalindrome(1000021));
    }

    public boolean isPalindrome(int x) {
        return isPalindrome(Integer.toString(x));
    }

    public boolean isPalindrome(String str) {
        System.out.println(str);
        if (str.length() == 0 || str.length() == 1) return true;

        if (str.charAt(0) == str.charAt(str.length()-1)) {
            return isPalindrome(str.substring(1, str.length()-1));
        }
        return false;
    }


}
