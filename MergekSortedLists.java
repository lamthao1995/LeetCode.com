/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int nums = lists.length - 1;
        if(nums == -1) return null;
        if(nums == 0) return lists[0];
        while(nums != 0 ){
            int i = 0, j = nums;
            while(i < j){
                lists[i] = merge2(lists[i], lists[j]);
                i++;j--;
                if(i >= j) nums = j;
            }
            
        }
        return lists[0];
    }
    public ListNode merge2(ListNode node1, ListNode node2){
        
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        ListNode rs = null;
        if(node1.val <= node2.val){
            rs = node1;
            rs.next = merge2(node1.next, node2);
        }else{
            rs = node2;
            rs.next = merge2(node1, node2.next);
        }
        return rs;
    }
}