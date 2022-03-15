import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {
    public static void main(String[] args) {
        GraphTraversal tester = new GraphTraversal();
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", List.of("C", "B"));
        graph.put("B", List.of("D"));
        graph.put("C", List.of("E"));
        graph.put("D", List.of("F"));
        graph.put("E", List.of());
        graph.put("F", List.of());
        tester.printDfs(graph, "A");
        System.out.println("");
        tester.printRecurssiveDfs(graph, "A");
        System.out.println("");
        tester.printBfs(graph, "A");
    }

    private void printBfs(Map<String, List<String>> graph, String start) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");
            List<String> neighbors = graph.get(current);
            neighbors.forEach(queue::add);
        }
    }

    void printDfs(Map<String, List<String>> graph, String start) {
        Stack<String> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            System.out.print(current + " ");
            List<String> neighbors = graph.get(current);
            neighbors.forEach(stack::push);
        }
    }

    void printRecurssiveDfs(Map<String, List<String>> graph, String start) {
        System.out.print(start + " ");
        List<String> neighbors = graph.get(start);
        if (neighbors.isEmpty()) return;
        for (String neighbor:neighbors) {
            printRecurssiveDfs(graph, neighbor);
        }
    }
}
