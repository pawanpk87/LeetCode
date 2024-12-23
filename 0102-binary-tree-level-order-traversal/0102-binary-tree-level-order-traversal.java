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
    private void traverse(TreeNode root, int level, Map<Integer, List<Integer>> mp) {
        if(root == null) {
            return;
        }    
        
        mp.putIfAbsent(level, new ArrayList<>());
        mp.get(level).add(root.val);
        
        traverse(root.left, level + 1, mp);
        traverse(root.right, level + 1, mp);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> mp = new TreeMap<>();
        
        traverse(root, 0, mp);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(List<Integer> nodes : mp.values()) {
            res.add(nodes);
        }
        
        return res;
    }
}