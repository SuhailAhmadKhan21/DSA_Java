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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return -1;
        return helper(root, root.val);
    }
    public int helper(TreeNode node, int min)
    {
        if(node == null)
            return -1;
        if(node.val > min)
            return node.val;
        int leftSubtreeMin = helper(node.left, min);
        int rightSubtreeMin = helper(node.right, min);

        if (leftSubtreeMin != -1 && rightSubtreeMin != -1) {
            return Math.min(leftSubtreeMin, rightSubtreeMin);
        }

        return leftSubtreeMin != -1 ? leftSubtreeMin : rightSubtreeMin;
    }
}