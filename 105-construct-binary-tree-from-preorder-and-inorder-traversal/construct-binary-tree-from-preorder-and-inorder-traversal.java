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
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode node = construct(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return node;
    }
    TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie)
    {
        if(ps>pe || is>ie)
            return null;
        TreeNode root = new TreeNode(pre[ps]);

        //TO OPTIMIZE WE HASHMAP FOR INORDER KEY AND VALUE(POS)
        // int idx = 0;
        // for(int i=is; i<=ie; i++)
        // {
        //     if(in[i] == pre[ps])
        //     {
        //         idx = i;
        //         break;
        //     }
        // }

        int idx = map.get(pre[ps]);
        int c = idx-is;
        root.left = construct(pre, ps+1, ps+c, in, is, idx-1);
        root.right = construct(pre, ps+c+1, pe, in, idx+1, ie);

        return root;
    }
}