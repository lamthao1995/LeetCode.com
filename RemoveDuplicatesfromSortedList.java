/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode root = head.next;
        ListNode prev = head;
        while(root != null){
            if(root.val == prev.val){
                //delete
             	//root = root.next;
                prev.next = root.next;
                root = prev.next;
            }else{
                 prev = root;
            	root = root.next;
            }
           
        }
        return head;
        
    }
}