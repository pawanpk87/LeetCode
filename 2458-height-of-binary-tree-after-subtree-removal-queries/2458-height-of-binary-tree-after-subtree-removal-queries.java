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
    private Map<Integer, Integer> heighOfLeftSubtree = new HashMap<>();
    private Map<Integer, Integer> heighOfRighSubtree = new HashMap<>();
    private Map<Integer, Integer> maxHeight = new HashMap<>();
    
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        calHeight(root, 0);
        calHeightAfterRemovedSubtree(root, 0);
        
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            ans[i] = maxHeight.get(queries[i]);
        }
        
        return ans;
    }
    
    private void calHeightAfterRemovedSubtree(TreeNode root, int height) {
        if(root == null) {
            return;
        }
        
        maxHeight.put(root.val, height);
        
        calHeightAfterRemovedSubtree(root.left, Math.max(height, heighOfRighSubtree.get(root.val)));
        calHeightAfterRemovedSubtree(root.right, Math.max(height, heighOfLeftSubtree.get(root.val)));
    }
    
    private int calHeight(TreeNode node, int height) {
        if(node == null) {
            return height - 1;
        }
        
        heighOfLeftSubtree.put(node.val, calHeight(node.left, height + 1));
        heighOfRighSubtree.put(node.val, calHeight(node.right, height + 1));
        
        return Math.max(heighOfLeftSubtree.get(node.val), 
                        heighOfRighSubtree.get(node.val));
    }
    
    /*
    ================== Not Optimized =========================
    
    private int calHeight(TreeNode root, int targetNodeNum) {
        if(root == null) {
            return -1;
        }
        
        if(root.val == targetNodeNum) {
            return -1;
        }
        
        int leftMaxHeight = calHeight(root.left, targetNodeNum);
        int rightMaxHeight = calHeight(root.right, targetNodeNum);
        
        return 1 + Math.max(leftMaxHeight, rightMaxHeight);
    }
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        int qn = queries.length;
        
        int[] ans = new int[qn];
        
        for(int i = 0; i < qn; i++) {
            ans[i] = calHeight(root, queries[i]);
        }
        
        return ans;
    }
    */
}