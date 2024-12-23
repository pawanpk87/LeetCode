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
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) {
            return res;
        }
        
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        
        while(!bfs.isEmpty()) {
            int size = bfs.size();
            
            List<Integer> nodes = new ArrayList<>();
            
            while(size-- > 0) {
                TreeNode currNode = bfs.poll();
                
                nodes.add(currNode.val);
                
                if(currNode.left != null) {
                    bfs.add(currNode.left);
                }
                
                if(currNode.right != null) {
                    bfs.add(currNode.right);
                }
            } 
            
            res.add(nodes);
        }
        
        return res;
    }
}