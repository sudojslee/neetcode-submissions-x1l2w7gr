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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        return 1 + left + right;
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        if (maxSoFar > node.val) {
            return dfs(node.left, maxSoFar) + dfs(node.right, maxSoFar);
        } else {
            maxSoFar = node.val;
            return 1 + dfs(node.left, maxSoFar) + dfs(node.right, maxSoFar);
        }
    }
}
