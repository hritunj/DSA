// LEETCODE: SWAP NODES IN PAIRS
// https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapPairs {
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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode left = head , res = null, prevLeft = null, right, nextLeft;
        while(true){
            right = left;
            int grp = 2;
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
