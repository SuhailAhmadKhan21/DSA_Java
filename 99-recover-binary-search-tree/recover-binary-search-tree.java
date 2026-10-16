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
    TreeNode f, s, prev;
    public void recoverTree(TreeNode root){
        inorder(root);
        int temp = f.val;
        f.val = s.val;
        s.val = temp;
    }
    public void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        if(prev != null && prev.val > root.val && f == null)
        {
            f = prev;
            s = root;
        }
        else if(prev != null && prev.val > root.val && f != null)
        {
            s = root;
        }
        prev = root;
        inorder(root.right);
    }
}