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
    // preorder: root -> left -> right
    // inorder: left -> root -> right
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);

        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                index = i;
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        
        

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int minIndex, int maxIndex) {
        if (minIndex == maxIndex) {
            return new TreeNode(preorder[minIndex]);
        }
        if (minIndex > maxIndex) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[minIndex]);

        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                index = i;
            }
        }

        root.left = buildTree(preorder, inorder, 0, index-1);
        root.right = buildTree(preorder, inorder, index+1, preorder.length-1);

        return root;
    }
}
