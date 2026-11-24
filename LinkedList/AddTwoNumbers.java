// LC: ADD TWO NUMBERS
// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2 == null) return null;
        if(l1==null || l2==null) return l2==null? l1 :l2;
        ListNode h1 = l1 , h2 = l2; int carry = 0 ;
        int s = h1.val + h2.val;
        ListNode res = new ListNode(s%10);
        ListNode r = res;
        carry = s/10;
        h1 = h1.next ; h2 = h2.next;
        while(h1!=null || h2!=null || carry >0){
            int sum = carry;
            if(h1!=null){
                sum+= h1.val;
                h1 = h1.next;
            }
            if(h2!=null){
                sum+=h2.val;
                h2 = h2.next;
            }
            carry = sum/10;
            res.next = new ListNode(sum%10);
            res = res.next;
        }
        // while(h1!=null){
        //     int sum = h1.val+carry;
        //     int d = sum%10;
        //     carry = sum/10;
        //     res.next = new ListNode(d);
        //     res = res.next;
        //     h1 = h1.next ;
        // }
        // while(h2!=null){
        //     int sum = h2.val+carry;
        //     int d = sum%10;
        //     carry = sum/10;
        //     res.next = new ListNode(d);
        //     res = res.next;
        //     h2 = h2.next ;
        // }
        // while(carry>0){
        //     int d = carry%10;
        //     res.next = new ListNode(d);
        //     res = res.next;
        //     carry = carry/10;
        // }
        return r;
    }
}
