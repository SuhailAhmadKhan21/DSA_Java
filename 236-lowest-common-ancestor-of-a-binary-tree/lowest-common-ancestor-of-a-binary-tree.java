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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(root == null || root == p || root == q)
        //     return root;
        // TreeNode lf = lowestCommonAncestor(root.left, p ,q);
        // TreeNode rf = lowestCommonAncestor(root.right, p ,q);

        // if(lf != null && rf != null)
        //     return root;
        // return (lf != null) ? lf : rf;

        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode l = lowestCommonAncestor(root.left, p ,q);
        TreeNode r = lowestCommonAncestor(root.right, p ,q);
        if(l != null && r != null)
            return root;
        if(l == null && r != null)
        return r;
        if(l != null && r == null)
            return l;
        return null;
    }
}