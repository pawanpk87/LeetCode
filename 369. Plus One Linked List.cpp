Given a non-negative integer represented as a linked list of digits, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list.

 

Example 1:

Input: head = [1,2,3]
Output: [1,2,4]
Example 2:

Input: head = [0]
Output: [1]
 

Constraints:

The number of nodes in the linked list is in the range [1, 100].
0 <= Node.val <= 9
The number represented by the linked list does not contain leading zeros except for the zero itself. 

class Solution {
private:
    ListNode* reverseList(ListNode* head)
    {
        ListNode* prev=NULL;
        ListNode* curr=head;        
        while(curr)
        {
            ListNode* next=curr->next;
            curr->next=prev;
            prev=curr;
            curr=next;
        }        
        return prev;
    }
    
public:
    ListNode* plusOne(ListNode* head) {            
        ListNode* rHead=reverseList(head);
        
        int rem=1;
        ListNode* prevNode=rHead;
        ListNode* root=rHead;
        
        while(rHead)
        {
            int currSum=rem+rHead->val;
            rHead->val=currSum%10;
            rem=currSum/10;
            prevNode=rHead;
            rHead=rHead->next;
        }
        
        if(rem != 0)
        {
            prevNode->next=new ListNode(rem);
        }
        
        return reverseList(root);
    }
};
  
