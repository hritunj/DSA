// LC : SUM FROM ROOT TO LEAF
// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
public class SumRootLeaf{
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
    int res=0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return res= res*10+ root.val;
        res = res*10 + root.val; int temp = res;
        int left = sumNumbers(root.left);
        res = temp;
        int right = sumNumbers(root.right);
        return left + right;
    }
}