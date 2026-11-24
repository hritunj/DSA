// LEETCODE 61: ROTATE LL BY K PLACES
// https://leetcode.com/problems/rotate-list/description/
public class RotateLL {
    class ListNode {
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next ==null || k==0) return head;
        ListNode last = head; int n =1;
        while(last.next!=null){
            n++;
            last=last.next;
        }
        k = k%n;
        if(k==0) return head;
        ListNode p= head , newLast = head , newHead = head;;
        for(int i = 1; i<=n-k;i++){
            if(i==n-k) {
                newLast = p;
                newHead = p.next;
                break;
            }
            p = p.next;
        }
        last.next = head;
        newLast.next = null;
        return newHead;

    }
}
