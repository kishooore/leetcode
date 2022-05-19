public class ECTKTV {
    public static void main(String[] args) {
        ECTKTV tester = new ECTKTV();
        int result = tester.solution("0011100");
        System.out.print(result);
    }

    public int solution(String S) {
        int i=0;
        int N = S.length();
        while (i<N) {
            if (S.charAt(i) == '1') {
                break;
            }
            i++;
        }
        int NLZ = i;
        int N1 = 0;
        while (i < N) {
            if (S.charAt(i) == '1') {
                N1++;
            }
            i++;
        }
        int NVZ = N-NLZ-N1;
        if (2*N1 + NVZ == 0) {
            return 0;
        }
        return 2*N1 + NVZ - 1;
    }
}
