// LC: ODD EVEN LINKED LIST
// https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLL {
    static class ListNode {
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

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head, o = odd.next.next, even = head.next, e = o != null ? o.next : null; // o: pointer for odd
                                                                                                 // nodes, odd: head of
                                                                                                 // odd nodes, e :
                                                                                                 // pointer for even
                                                                                                 // nodes, even: head
                                                                                                 // for even LL
        odd.next = o;
        while (o != null || e != null) {
            if (o != null) {
                if (o.next != null) {
                    o.next = o.next.next;
                    o = o.next;
                } else {
                    o.next = even;
                }
            }
            if (e != null) {
                if (e.next != null) {
                    e.next = e.next.next;
                    e = e.next;
                }else{
                    e = null;
                }
            }
        }
        return odd;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode res = oddEvenList(head);
        while (res != null) {
            System.err.print(res.val + " -> ");
            res = res.next;
        }

    }
}
