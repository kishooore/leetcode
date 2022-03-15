public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);
        ReverseLinkedList list = new ReverseLinkedList();
        head = list.reverse(head, 1, 2);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("NULL");
    }

    private ListNode reverse(ListNode head, int m, int n) {
        if (head.next == null) return head; 
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode slow = head;
        ListNode fast = head;
        while (m - 1 > 0) {
            slow = slow.next;
            fast = fast.next;
            m--;
            n--;
        }
        while (n - 1 > 0) {
            fast = fast.next;
            n--;
        }
        ListNode temp1 = slow.next;
        slow.next = fast;
        ListNode temp2 = fast.next;
        ListNode tail = reverse(temp1, fast);
        tail.next = temp2;
        return head.next;
    }

    private ListNode reverse(ListNode head, ListNode fast) {
        if (head == fast) {
            return fast;
        }
        ListNode tail = reverse(head.next, fast);
        tail.next = head;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
