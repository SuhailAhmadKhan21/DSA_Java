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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null)
            return list;
        dfs(root, "", list);
        return list;
    }
    public void dfs(TreeNode root, String curr, List<String> res)
    {
        if(curr.isEmpty())
            curr += root.val;
        else
            curr += "->" + root.val;
        if(root.right == null && root.left == null)
        {
            res.add(curr);
            return;
        }
        if (root.left != null) {
            dfs(root.left, curr, res);
        }
        if (root.right != null) {
            dfs(root.right, curr, res);
        }
    }
}