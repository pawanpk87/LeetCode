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
    private int countSwaps(List<Integer> list) {
        int n = list.size();
        
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        
        Map<Integer, Integer> index = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            index.put(sortedList.get(i), i);
        }
        
        int swaps = 0;
        
        for(int i = 0; i < n; i++) {
            while(i != index.get(list.get(i))) {
                swap(list, i, index.get(list.get(i)));
                swaps++;
            }
        }
        
        return swaps;
    }
    
    public int minimumOperations(TreeNode root) {
        List<List<Integer>> levelOrderTrav = levelOrder(root);
        
        int swaps = 0;
        
        for(List<Integer> nodes : levelOrderTrav) {
            swaps += countSwaps(nodes);
        }
        
        return swaps;
    }
    
    private List<List<Integer>> levelOrder(TreeNode root) {
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
    
    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
/*

    [4,5,6,7]
       |
     
    [4,5,6,7]
    
    
    swap = 1 + 1
    
    

*/