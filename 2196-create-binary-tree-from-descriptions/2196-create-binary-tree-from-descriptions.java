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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Integer> leftNode = new HashMap<>();
        Map<Integer, Integer> rightNode = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        
        for(int[] description : descriptions){
            if(description[2] == 1){
                leftNode.put(description[0], description[1]);
            } else {
                rightNode.put(description[0], description[1]);
            }
            
            indegree.put(description[1], indegree.getOrDefault(description[1], 0) + 1);
            
            if(indegree.containsKey(description[0]) == false){
                indegree.put(description[0], 0);
            }
        }
        
        int rootNode = -1;
        
        for(Map.Entry<Integer, Integer> data : indegree.entrySet()){
            if(data.getValue() == 0){
                rootNode = data.getKey();
                break;
            }
        }
        
        return constructTree(rootNode, leftNode, rightNode);
    }
    
    private TreeNode constructTree(int currNode,  Map<Integer, Integer> leftNode,  Map<Integer, Integer> rightNode){
        TreeNode node = new TreeNode(currNode);
        node.left = leftNode.containsKey(currNode) ? constructTree(leftNode.get(currNode), leftNode, rightNode) : null;
        node.right = rightNode.containsKey(currNode) ? constructTree(rightNode.get(currNode), leftNode, rightNode) : null;
        return node;
    }
}