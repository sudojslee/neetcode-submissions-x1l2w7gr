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
    public boolean isBalanced(TreeNode root) {

        return dfs(root)[1] == 1;
        // if (root == null) {
        //     return true;
        // }

        // int[] left = height(root.left);
        // int[] right = height(root.right);
        

        // return isBalanced(root.left) && isBalanced(root.right);
    }

    // [height, 0/1] 0: not balanced
    int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 1};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int heightL = left[0];
        int heightR = right[0];

        int height = 1 + Math.max(heightL, heightR);
        if (left[1] == 0 || right[1] == 0) {
            return new int[]{height, 0};
        }
        if (Math.abs(heightL - heightR) > 1) {
            return new int[]{height, 0};
        }
        return new int[]{height, 1};
    }

    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }
}
