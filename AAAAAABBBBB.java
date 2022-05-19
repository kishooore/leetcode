import java.util.HashMap;
import java.util.Optional;

@SuppressWarnings("unused")
public class AAAAAABBBBB {
    public static void main(String[] args) {
        AAAAAABBBBB test = new AAAAAABBBBB();
        //int min = test.minimum("bbbbbbbbbbbbbbb");
        //System.out.print(min);
        Object str = new HashMap<>();
        String tenantId = (String) str;
        boolean isEmpty = tenantId == null || tenantId.length() == 0;
        Optional<String> tenant = isEmpty ? Optional.empty() : Optional.of(tenantId);
        System.out.println(tenant.isPresent());
    }

    public int minEdit(String str) {
        int N = str.length();
        if (N < 2)
            return 0;

        // handle BA, AA, BB

        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i < N; i++)
            if (str.charAt(i) == 'a')
                aCount++;
        bCount = N - aCount;

        int[] leftB = new int[N];
        int[] rightA = new int[N];

        if (str.charAt(0) == 'b') {
            leftB[0] = 1;
            rightA[0] = aCount;
        } else {
            leftB[0] = 0;
            rightA[0] = aCount - 1;
        }

        for (int i = 1; i < N; i++) {
            if (str.charAt(i) == 'b') {
                leftB[i] = leftB[i - 1] + 1;
                rightA[i] = rightA[i - 1];
            } else {
                leftB[i] = leftB[i - 1];
                rightA[i] = rightA[i - 1] - 1;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            min = Math.min(min, leftB[i] + rightA[i]);
        }

        if (min == 1 && rightA[N-1] == 0) min = 0;

        return min;
    }

    public int minimum(String str) {
        int N = str.length();
        int ta = 0;
        int tb = 0;
        for (int i=0; i<N; i++) if (str.charAt(i) == 'a') ta++;
        tb = N - ta;

        int min = Math.min(ta, tb);
        int ca = 0;
        int cb = 0;
        for (int i=0; i<N; i++) {
            if (str.charAt(i) == 'a') ca++;
            else cb++;
            min = Math.min(min, cb+ta-ca);
        }
        return min;
    }




}
