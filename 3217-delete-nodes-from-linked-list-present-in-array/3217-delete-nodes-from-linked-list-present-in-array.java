class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> st = new HashSet<>();
        for(int num : nums){
            st.add(num);
        }
        
        ListNode headNode = new ListNode(-1);
        ListNode prevNode = headNode;
        
        while(head != null){
            if(st.contains(head.val) == false){
                prevNode.next = head;
                prevNode = prevNode.next;
            } else {
                prevNode.next = null;
            }
            head = head.next;
        }
        
        return headNode.next;
    }
}