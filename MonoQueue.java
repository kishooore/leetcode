import java.util.ArrayDeque;
import java.util.Deque;

public class MonoQueue {

    public static void main(String[] args) {
        MonoQueue queue = new MonoQueue();
        int[] arr = {1,3,-1};
        for (int i=0; i < arr.length; i++) {
            queue.push(arr[i]);
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.pop());
        }
    }
    
    Deque<Integer> deque = new ArrayDeque<>();
    
    int max() {
        return deque.getLast();
    }
    
    void push(int el) {
        while (!deque.isEmpty() && deque.getFirst() < el) {
            deque.removeFirst();
        }
        deque.addFirst(el);
    }
    
    int pop() {
        return deque.pollFirst();
    }

    boolean isEmpty() {
        return deque.isEmpty();
    }
}
