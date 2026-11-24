// LC: FIND KTH SMALLEST ELEMENT IN BST
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

import java.util.*;;

public class KthSmallestBST {
     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int res;
    public int kthSmallest(TreeNode root, int k) { 

        // APPROACH 1: 
        // if(root==null) return -1;
        // Queue<TreeNode> q =new ArrayDeque<>(); int counter =0;
        // PriorityQueue<Integer> h = new PriorityQueue<>(Collections.reverseOrder());
        // q.add(root);
        // while(!q.isEmpty()){
        //     int size = q.size();
        //     for(int i =0;i<size;i++){
        //         TreeNode t = q.poll();
        //         if(counter<k) {
        //             h.add(t.val);
        //             counter++;
        //         } else{
        //             int m = h.peek();
        //             if(m>t.val){
        //                 h.poll();
        //                 h.add(t.val);
        //             }
        //         }
        //         if(t.left!=null) q.add(t.left);
        //         if(t.right!=null) q.add(t.right);
        //     }
        // }
        // return h.peek();
    // APPROACH: 2
        fun(root, k);
        return res;
    }
    void fun (TreeNode root, int k){
        if(root==null) return;
        fun(root.left, k);
        if(--k==0) res = root.val;
        fun(root.right, k);
    }
}
