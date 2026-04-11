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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root, 0, result);
        return result;
    }

    void dfs(TreeNode root, int index, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (result.size() <= index) {
            result.add(index, new ArrayList<>());
        }
        
        result.get(index).add(root.val);

        dfs(root.left, index + 1, result);
        dfs(root.right, index + 1, result);
    }
}
