import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(); 
        int[] timestamps = {1,100,3001,3002};
        for (int timestamp:timestamps) {
            queue.add(timestamp);
        }
        while(!queue.isEmpty()) {
            System.out.print(queue.poll() + ",");
        }
    }
}
