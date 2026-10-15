import java.util.*;

class Solution {
    private static class QueueNode {
        TreeNode treeNode;
        int col;

        QueueNode(TreeNode treeNode, int col) {
            this.treeNode = treeNode;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        TreeMap<Integer, List<Integer>> columnMap = new TreeMap<>();
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            Map<Integer, List<Integer>> rowMap = new HashMap<>();

            for (int i = 0; i < size; i++) {
                QueueNode curr = queue.poll();
                TreeNode node = curr.treeNode;
                int col = curr.col;

                rowMap.putIfAbsent(col, new ArrayList<>());
                rowMap.get(col).add(node.val);

                if (node.left != null) {
                    queue.offer(new QueueNode(node.left, col - 1));
                }
                if (node.right != null) {
                    queue.offer(new QueueNode(node.right, col + 1));
                }
            }

            for (Map.Entry<Integer, List<Integer>> entry : rowMap.entrySet()) {
                int col = entry.getKey();
                List<Integer> values = entry.getValue();
                
                Collections.sort(values);
                
                columnMap.putIfAbsent(col, new ArrayList<>());
                columnMap.get(col).addAll(values);
            }
        }

        for (List<Integer> colList : columnMap.values()) {
            result.add(colList);
        }

        return result;
    }
}
