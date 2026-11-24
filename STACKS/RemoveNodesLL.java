// LC : REMOVE NODES FROM LINKED LIST
// https://leetcode.com/problems/remove-nodes-from-linked-list/description/

// import java.util.Stack;

public class RemoveNodesLL {
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

    public ListNode rev(ListNode head){
        ListNode curr = head, prev = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        // APPROACH 1: USING STACK O(n) time, O(n) space

        // Stack<ListNode> s = new Stack<>();
        // ListNode curr = head; ListNode newHead = head;
        // while (curr != null) {
        //     while (!s.isEmpty() && s.peek().val < curr.val) {
        //         s.pop();
        //     }
        //     if (s.isEmpty()) {
        //         newHead = curr;
        //         s.push(curr);
        //     } else {
        //         s.peek().next = curr;
        //         s.push(curr);
        //     }
        //     curr = curr.next;
        // }
        // return newHead;

        // APPROACH 2: O(N) TIME O(1) SPACE
        if(head==null) return null;
        ListNode revNode = rev(head);
        ListNode curr = revNode.next , prev = revNode;
        while (curr!=null) {
            ListNode next = curr.next;
            if(curr.val>=prev.val){
                prev.next = curr;
                prev = curr;
            } 
            curr = next;
        }
        prev.next = null;
        return rev(prev);
    }

    public static void main(String[] args) {
        // ListNode head = new ListNode(5);
        // head.next = new ListNode(6);
        // head.next.next = new ListNode(7);
        // System.out.println(removeNodes(head));
    }
}
