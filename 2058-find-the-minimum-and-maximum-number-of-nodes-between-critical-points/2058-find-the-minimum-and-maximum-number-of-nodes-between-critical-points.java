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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return new int[]{-1, -1};
        }
        
        int minDistance = Integer.MAX_VALUE;
        
        int startIndex = Integer.MAX_VALUE;
        int endIndex = Integer.MIN_VALUE;
        
        int prevNum = head.val; head = head.next;
        int currNum = head.val; head = head.next;
        
        int currIndex = 1;
        
        while(head != null){
            int nextNum = head.val;
            
            if(isCriticalPoint(prevNum, currNum, nextNum)){
                startIndex = Math.min(startIndex, currIndex);
                
                if(endIndex != Integer.MIN_VALUE){
                    minDistance = Math.min(minDistance, currIndex - endIndex);
                }
                
                endIndex = Math.max(endIndex, currIndex);
            }
            
            prevNum = currNum;
            currNum = nextNum;
            
            head = head.next;
            
            currIndex++;
        }
        
        if(startIndex == Integer.MAX_VALUE || startIndex == endIndex){
            return new int[]{-1, -1};
        }
        
        return new int[]{minDistance, endIndex - startIndex};
    }
    
    private boolean isCriticalPoint(int prevNum, int currNum, int nextNum){
        return prevNum < currNum && currNum > nextNum ||
               prevNum > currNum && currNum < nextNum;
    }
}