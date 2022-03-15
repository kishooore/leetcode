public class Power {
    public static void main(String[] args) {
        Power tester = new Power();
        System.out.println(tester.calculate(3, 9));
        System.out.print(Math.pow(3, 9));
    }

    // base=3, power=9
    public int calculate(int base, int power) {
        int ans = 1;
        while (power > 0) { // 1001 // 0100 // 0010 // 0001 // 0000
            int lsb = power&1; // 1 // 0 // 0 // 1
            if (lsb == 1) { 
                ans *= base; // 1*3 // 1*3 // 1*3 // 1*3*3^8
            }
            power = power >> 1; //0100 // 0010 // 0001 // 0000
            base = base * base; //3*3 // 3*3*3*3 // 3^8 // 3^16
        }
        return ans; // 3^9
    }
}
