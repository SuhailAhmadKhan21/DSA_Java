/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return sum;
    }
    int helper(TreeNode root)
    {
        if(root == null)
            return 0;
        int ls = helper(root.left);
        int rs = helper(root.right);

        ls = Math.max(ls, 0);
        rs = Math.max(rs, 0);

        int currSum = root.val + ls + rs;

        sum = Math.max(sum, currSum);

        return root.val + Math.max(ls, rs);
    }
}