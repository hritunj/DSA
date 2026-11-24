// LEETCODE 25: REVERSE BY K GROUP
// https://leetcode.com/problems/reverse-nodes-in-k-group/

public class SwapByKgrp {
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
    public ListNode reverseKGroup(ListNode head, int k) {
         if(head==null || head.next==null|| k==1) return head;
        ListNode left = head , res = null, prevLeft = null, right, nextLeft;
        while(true){
            right = left;
            int grp = k;
            for(int i = 0 ;i<grp-1; i++){
                if(right==null) break;
                right = right.next;
            }
            if(right!=null){
                nextLeft = right.next;
                ListNode curr = left , prev = null ;
                while(grp>0){
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr= next;
                    grp--;
                }
                if(prevLeft!=null) prevLeft.next = right;
                left.next = nextLeft;
                prevLeft = left;
                if(res==null) res= right;
                left = nextLeft;

            } else{
                if(prevLeft!=null) prevLeft.next = left;
                break;
            }
        }
        return res;  
    }
}
