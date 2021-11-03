package addtwonumbers;


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode current = null;
        boolean carry = false;

        while (l1 != null || l2 != null) {
            var l1Digit = l1 == null ? 0 : l1.val;
            var l2Digit = l2 == null ? 0 : l2.val;

            var digitSum = l1Digit + l2Digit + ((carry) ? 1 : 0);
            if (digitSum >= 10) {
                digitSum -= 10;
                carry = true;
            } else {
                carry = false;
            }
            var nextDigit = new ListNode(digitSum);
            if (head == null) {
                head = nextDigit;
                current = head;
            } else {
                current.next = nextDigit;
                current = nextDigit;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry) {
            current.next = new ListNode(1);
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}