
// LEECTODE 92: REVERSE LL 2
// https://leetcode.com/problems/reverse-linked-list-ii/
import java.util.*;

public class Reverse2 {
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
// EXPLANATION: https://www.youtube.com/watch?v=bRZ_Fy4zRRY
    public ListNode reverseBetween(ListNode head, int left, int right) { // left, right are positions
        if(head==null || head.next ==null) return head;
        ListNode dummy = new ListNode(-1); ListNode prev = dummy;
        dummy.next = head;
        for(int i = 1; i< left;i++){
            prev  = prev.next;
        }
        ListNode curr = prev.next;
        for(int i = 1 ; i<=right-left;i++){
            ListNode temp = prev.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = temp;
        }
        return dummy.next;
        
    }
}
