/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if(root == null || root == p || root == q)
    //         return root;
    //     TreeNode l = lowestCommonAncestor(root.left, p, q);
    //     TreeNode r = lowestCommonAncestor(root.right, p, q);

    //     if(l != null && r != null)
    //         return root;
    //     return (l != null) ? l : r;
    // }

    //EASY ONE
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        TreeNode current = root;

            while (current != null) {
                if (p.val > current.val && q.val > current.val) {
                    current = current.right;
                }
                else if (p.val < current.val && q.val < current.val) {
                    current = current.left;
                }
                else {
                    return current;
                }
            }
            
            return null;
    }
}