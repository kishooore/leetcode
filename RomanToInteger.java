import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        int number = romanToInteger.convert("MCMXCIV");
        System.out.print(number);
    }

    public int convert(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] characters = s.toCharArray();
        int sum = 0;
        for (int i=0; i<characters.length; i++) {
            if (characters[i] == 'I' && i < characters.length - 1 && (characters[i+1] == 'V' || characters[i+1] == 'X')) {
                sum = sum + (map.get(characters[i+1]) - map.get(characters[i]));
                i++;
            } else if (characters[i] == 'X' && i < characters.length - 1 && (characters[i+1] == 'L' || characters[i+1] == 'C')) {
                sum = sum + (map.get(characters[i+1]) - map.get(characters[i]));
                i++;
            } else if (characters[i] == 'C' && i < characters.length - 1 && (characters[i+1] == 'D' || characters[i+1] == 'M')) {
                sum = sum + (map.get(characters[i+1]) - map.get(characters[i]));
                i++;
            } else {
                sum += map.get(characters[i]);
            }
        }
        return sum;
    }
}
