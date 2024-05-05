/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        ListNode prevNode = node;
        while(nextNode != null){
            prevNode = node;
            node.val = nextNode.val;
            node = node.next;
            nextNode = nextNode.next;
        }
        prevNode.next = null;
    }
}