class Solution {
public:
    int getSize(ListNode* head){
        int size = 0;
        for(ListNode* start = head; start != NULL; start = start->next){
            size++;
        }
        return size;
    }
    
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int sizeOfList = getSize(head);
        int k = sizeOfList - n;
        
        if(sizeOfList == 1){
            return NULL;
        }
        
        ListNode* newNode = new ListNode(-1);
        ListNode* prevNode = newNode;
        ListNode* currNode = head;
        
        while(currNode){
            if(k == 0){
                break;
            }
            
            prevNode->next = currNode;
            prevNode = currNode;
            currNode = currNode->next;
            
            k--;
        }
        
        prevNode->next = currNode->next;
        
        return newNode->next;
    }
};