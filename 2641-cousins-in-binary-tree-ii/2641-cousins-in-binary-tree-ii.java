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
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            
            int size = q.size();
            while(size-- > 0) {
                nodes.add(q.poll());
            }
            
            int totalSum = getSumOfChildNode(nodes);
            
            for(TreeNode node : nodes) {
                int sumOfCousins = totalSum;
                
                if(node.left != null) {
                    sumOfCousins -= node.left.val;
                }
                
                if(node.right != null) {
                    sumOfCousins -= node.right.val;    
                }
                
                if(node.left != null) {
                    node.left.val = sumOfCousins < 0 ? 0 : sumOfCousins;
                    q.add(node.left);
                }
                
                if(node.right != null) {
                    node.right.val = sumOfCousins < 0 ? 0 : sumOfCousins;
                    q.add(node.right);
                }
            }
        }
        
        return root;
    }
    
    private int getSumOfChildNode(List<TreeNode> list) {
        int sum = 0;
        
        for(TreeNode node : list) {
            if(node.left != null) {
                sum += node.left.val;
            }
            
            if(node.right != null) {
                sum += node.right.val;
            }
        }
        
        return sum;
    }
}