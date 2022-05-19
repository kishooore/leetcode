public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers test = new AddTwoNumbers();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode result = test.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.println("");
        String str = "255";
        System.out.println(Integer.valueOf(str));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode r = new ListNode();
        ListNode result = r;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int val;
            if (sum > 9) {
                val = sum % 10;
                carry = sum / 10;
            } else {
                carry = 0;
                val = sum;
            }
            r.next = new ListNode(val);
            r = r.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            int val;
            if (sum > 9) {
                val = sum % 10;
                carry = sum / 10;
            } else {
                carry = 0;
                val = sum;
            }
            r.next = new ListNode(val);
            r = r.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            int val;
            if (sum > 9) {
                val = sum % 10;
                carry = sum / 10;
            } else {
                carry = 0;
                val = sum;
            }
            r.next = new ListNode(val);
            r = r.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            r.next = new ListNode(carry);
        }
        return result.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
