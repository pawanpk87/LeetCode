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
    int ans = 0;
    
    private List<Integer> traverseTree(TreeNode root, int distance) {
        List<Integer> res = new ArrayList<>();
        
        if(root == null) {
            return res;
        }    
        
        List<Integer> leftChildLeafNodes = traverseTree(root.left, distance);
        List<Integer> rightChildLeafNodes = traverseTree(root.right, distance);
        
        if(root.left == null && root.right == null) {
            res.add(1);
            return res;
        }
        
        for(int i = 0; i < leftChildLeafNodes.size(); i++) {
            for(int j = 0; j < rightChildLeafNodes.size(); j++) {
                if(leftChildLeafNodes.get(i) + rightChildLeafNodes.get(j) <= distance) {
                    ans++;
                }
            }
        }
        
        for(int i = 0; i < leftChildLeafNodes.size(); i++) {
            res.add(leftChildLeafNodes.get(i) + 1);    
        }
        for(int i = 0; i < rightChildLeafNodes.size(); i++) {
            res.add(rightChildLeafNodes.get(i) + 1);    
        }
        
        return res;
    }
    
    public int countPairs(TreeNode root, int distance) {
        traverseTree(root, distance);
        return ans;
    }
}