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
    
    private TreeNode constructBST(int startIndex, int endIndex, List<Integer> nodes){
        if(startIndex <= endIndex){
            int mid = (startIndex + endIndex)/2;
            
            TreeNode currRoot = new TreeNode(nodes.get(mid));
            
            currRoot.left = constructBST(startIndex, mid - 1, nodes);
            currRoot.right = constructBST(mid + 1, endIndex, nodes);
            
            return currRoot;
        } else{
            return null;
        }
    }
    
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        return constructBST(0, nodes.size()-1, nodes);
    }
    
    private void inorder(TreeNode root, List<Integer> nodes){
        if(root != null){
            inorder(root.left, nodes);
            nodes.add(root.val);
            inorder(root.right, nodes);
        }    
    }
}