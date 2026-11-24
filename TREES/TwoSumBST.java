// LC: TWO SUM IV : BST
// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
import java.util.*;
public class TwoSumBST {
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
    
    Stack<TreeNode> asc = new Stack<>();
    Stack<TreeNode> desc = new Stack<>();
    TreeNode getSmall(){
        if(asc.empty()) return null;
        TreeNode small = asc.pop();
        TreeNode rightChild = small.right;
        while(rightChild!=null){
            asc.push(rightChild);
            rightChild = rightChild.left;
        }
        return small;
    }
    TreeNode getBig(){
        if(desc.empty()) return null;
        TreeNode big = desc.pop();
        TreeNode leftChild = big.left;
        while(leftChild!=null){
            desc.push(leftChild);
            leftChild = leftChild.right;
        }
        return big;
    }
    public boolean findTarget(TreeNode root, int k) { // https://www.youtube.com/watch?v=Zr2z8DD6TuQ
        if(root==null) return false;
        TreeNode t= root;
        while(t!=null){
            asc.push(t);
            t=t.left;
        }
        t = root;
        while(t!=null){
            desc.push(t);
            t=t.right;
        }
        TreeNode i = getSmall();
        TreeNode j = getBig();
        while((i!=null && j!=null) && i.val<j.val){
            int sum = i.val+j.val;
            if(sum== k) return true;
            if(sum>k){
                j = getBig();
            } else{
                i = getSmall();
            }
        }
        return false;
    }
}
