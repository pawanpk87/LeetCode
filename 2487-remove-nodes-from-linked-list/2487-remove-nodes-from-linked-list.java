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
    private ListNode removeNodesUtil(ListNode head){
        if(head.next == null){
            return head;
        }
        
        ListNode nextNode = removeNodesUtil(head.next);
        
        if(head.val >= nextNode.val){
            head.next = nextNode;
            return head;
        } else{
            return nextNode;
        }
    }
    
    public ListNode removeNodes(ListNode head) {
        return removeNodesUtil(head);
    }
}