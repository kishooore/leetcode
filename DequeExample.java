import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.offerFirst("Kishore");
        deque.offerLast("Garapati");

        for (String s:deque.pollFirst());
    }
}
