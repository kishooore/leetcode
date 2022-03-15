import java.util.HashMap;
import java.util.Map;

public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        boolean isHappy = happyNumber.isHappy(2);
        System.out.print(isHappy);
    }

    private Map<Integer, Integer> map = new HashMap<>();

    private boolean isHappy(int number) {
        String s = Integer.toString(number);
        String[] digits = s.split("");
        int sum = 0;
        for (String digit:digits) {
            int num = Integer.valueOf(digit);
            sum += num * num;
        }
        if (sum == 1) {
            return true;
        } else {
            if (map.get(sum) != null) {
                return false;
            } else {
                map.put(number, sum);
                return isHappy(sum);
            }
        }
    }
}
