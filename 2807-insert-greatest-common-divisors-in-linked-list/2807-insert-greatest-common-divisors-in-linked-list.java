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
    private int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }    
        return gcd(b%a, a);
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode prevNode = head;
        ListNode currNode = head.next;
        
        while(currNode != null) {
            ListNode newNode = new ListNode(gcd(prevNode.val, currNode.val));
            prevNode.next = newNode;
            newNode.next = currNode;
            prevNode = currNode;
            currNode = currNode.next;
        }
        
        return head;
    }
}

/*

    [18,  6,  10, 3]
     |    |
   prev  curr
     
     newnode = new Node(gcd(num1, num2));
     prev.next = newNode
     newNode.next = currNode
     
     prevNode = currNode 
     currNdoe = currNode.next;
     
     
     gcd (num1, num2)
           |
    numbers which divides the num1
    numbers which divides the num2
    
    command = [x, y, z...]
                        |
                        greater one
                        
                        
    
    num1        num2
    
    1 to min(num1, num2)
        check if currNum divides the both num1 & num2
        
        O(min(num1, num2))
    
    
    
    
    properties of gcd
    
    num1        num2
    
            |
            
    2               8
    
            
        keep subtracting the bigger number with smaller number 
    

    
    
*/