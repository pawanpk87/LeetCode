/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
private:
    ListNode* reverseList(ListNode* head) {
        ListNode* prev = NULL;
        ListNode* next = NULL;
        ListNode* curr = head;

        while(curr){
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    
public:
    void reorderList(ListNode* head) {
        if(!head || !head->next){
            return;
        }
        
        ListNode *slow = head, *fast = head, *prev = head;
        while(fast && fast->next){
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        
        prev->next = NULL;
        
        slow = reverseList(slow);
        
        prev = NULL;
        
        while(head){
            ListNode* headNext = head->next;
            
            if(prev){
                prev->next = head;
            }
            head->next = slow;
            
            prev = slow;
            
            head = headNext;
            slow = slow->next;
        }
        
        if(slow){
            prev->next = slow;
        }
    }
};