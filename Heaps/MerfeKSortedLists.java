// LC 23: MERGE K SORTED LISTS
// https://leetcode.com/problems/merge-k-sorted-lists/description/
import java.util.*;
public class MerfeKSortedLists {
    public class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b)-> a.val - b.val
        );
        // add first
        for(int i = 0 ; i<lists.length;i++){
           if(lists[i] !=null) pq.offer(lists[i]);
        }
        if(pq.isEmpty()) return null;
        ListNode res = pq.poll();
        if(res.next!=null) pq.offer(res.next);
        ListNode p = res;
        while(!pq.isEmpty()){
            ListNode n = pq.poll();
            p.next = n;
            p = p.next;
            if(n.next!=null) pq.offer(n.next);
        }
        return res;
    }
}
