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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()) {
            long levelSum = 0;
            
            int size = q.size();
            
            while(size-- > 0) {
                TreeNode currNode = q.poll();
                
                levelSum += currNode.val;
                
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            
            maxHeap.add(levelSum);
        }
        
        if(maxHeap.size() < k) {
            return -1;
        }
        
        while(maxHeap.size() > k) {
            maxHeap.poll();
        }
        
        return maxHeap.peek();
    }
}