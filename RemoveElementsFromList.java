public class RemoveElementsFromList {
    public static void main(String[] args) {
        RemoveElementsFromList tester = new RemoveElementsFromList();
        ListNode head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next.next = new ListNode(6);
    }

    public ListNode removeElements(ListNode head, ListNode prev, ListNode curr, int val) {
        if (curr == null) {
            return head;
        }
        if (curr.val == val) {
            prev.next = curr.next;
        }
        return removeElements(head, curr, curr.next, val);
    }
}




class ListNode {
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
