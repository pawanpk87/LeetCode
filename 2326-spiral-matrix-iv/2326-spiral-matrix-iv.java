/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int n, int m, ListNode head) {
        int[][] matrix = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], -1);
        }
        
        int lColLimit = 0, rColLimit = m - 1;
        int uRowLimit = 0, dRowLimit = n - 1;
        
        while(head != null && lColLimit <= rColLimit && uRowLimit <= dRowLimit) {
            for(int j = lColLimit; head != null && j <= rColLimit; j++) {
                matrix[uRowLimit][j] = head.val;
                head = head.next;
            }
            
            uRowLimit++;
            
            for(int i = uRowLimit; head != null && i <= dRowLimit; i++) {
                matrix[i][rColLimit] = head.val;
                head = head.next;
            }
            
            rColLimit--;
            
            if(uRowLimit <= dRowLimit) {
                for(int j = rColLimit; head != null && j >= lColLimit; j--) {
                    matrix[dRowLimit][j] = head.val;
                    head = head.next;
                }
                
                dRowLimit--;
            }
        
            if(lColLimit <= rColLimit) {
                for(int i = dRowLimit; head != null && i >= uRowLimit; i--) {
                    matrix[i][lColLimit] = head.val;
                    head = head.next;
                }
                
                lColLimit++;
            }
        }
        
        return matrix;
    }
}