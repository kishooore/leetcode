
public class LinkedList {
    public static void main(String[] args) {
        LinkedList tester = new LinkedList();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        tester.print(tester.reverse(head));
    }

    public void print(Node head) {
        while(head != null) {
            System.out.print(head.data);
            head = head.next;
        }
    }

    public Node reverse(Node head) {
        Node curr = head;
        Node next = curr.next;
        curr.next = null;
        return recursion(curr, next);
    }

    public Node recursion(Node curr, Node next) {
        if (next == null) {
            return curr;
        }
        Node temp = next.next;
        next.next = curr;
        curr = next;
        next = temp;
        return recursion(curr, next);
    }
}

class Node {
    Integer data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

/*
 * 1 -> 2 -> 3 -> 4 -> 5
 *
 */
