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
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode* newFinalList = new ListNode(-1);
        ListNode* newList = new ListNode(-1);
        
        newFinalList->next = head;
        
        ListNode* currNode = head;
        ListNode* prevNode = newFinalList;
        ListNode* currNewList = newList;
        
        while(currNode){
            if(currNode->val < x){
                prevNode = currNode;                
            }else{
                currNewList->next = new ListNode(currNode->val);
                currNewList = currNewList->next;
                prevNode->next = currNode->next;
            }
            currNode = currNode->next;
        }
        
        prevNode->next = newList->next;
        
        return newFinalList->next;
    }
};

/*
(newFinalList)->1 -> 4 -> 2 -> 5 -> 2
                          | 
   
   
   newFinalList =
   newList = 0->4->3->5
   
   currNode = 3
   
   prevNode = 2
   
   
   
   

*/