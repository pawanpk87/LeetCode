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
    private boolean isEqual(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return true;
        }
        
        if((node1 == null && node2 != null) || 
           (node1 != null && node2 == null)) {
            return false;
        }
        
        return node1.val == node2.val;
    }
    
    private boolean flipEquivUtil(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        
        if(!isEqual(root1, root2)) {
            return false;
        }
        
        if(isEqual(root1.left, root2.left)) {
            return flipEquivUtil(root1.left, root2.left) &&
                   flipEquivUtil(root1.right, root2.right);
        } else {
            return flipEquivUtil(root1.left, root2.right) &&
                   flipEquivUtil(root1.right, root2.left);
        }
    }
    
    
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return flipEquivUtil(root1, root2);
    }
} 