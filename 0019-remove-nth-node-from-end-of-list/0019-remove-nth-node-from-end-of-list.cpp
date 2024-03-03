class Solution {
public:
    ListNode* getNthNode(ListNode* head, int n){
        while(--n){
            head = head->next;
        }    
        return head;
    }
    
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* newList = new ListNode(-1);
        ListNode* prevNode = newList;
        
        ListNode* fastNode = getNthNode(head, n);
        ListNode* slowNode = head;
        
        
        while(fastNode->next){
            prevNode->next = slowNode;
            prevNode = slowNode;
            slowNode = slowNode->next;
            fastNode = fastNode->next;
        }
        
        prevNode->next = slowNode->next;
        
        return newList->next;
    }
};