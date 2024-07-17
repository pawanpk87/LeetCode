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
    List<TreeNode> res = new ArrayList<>();
    
    private TreeNode deleteNode(TreeNode root, Set<Integer> st) {
        if(root == null){
            return null;
        }
        
        TreeNode leftNode = deleteNode(root.left, st);
        TreeNode rightNode = deleteNode(root.right, st);
        
        if(st.contains(root.val)) {
            if(leftNode != null) res.add(leftNode);
            if(rightNode != null) res.add(rightNode);
            return null;
        } else {
            root.left = leftNode;
            root.right = rightNode;
            return root;
        }
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> st = new HashSet<>();
        for(int num : to_delete){
            st.add(num);   
        }
        TreeNode resRootNode = deleteNode(root, st);
        if(resRootNode != null) res.add(resRootNode);
        return res;
    }
}