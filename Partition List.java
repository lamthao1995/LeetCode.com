/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        List<ListNode> lessX = new ArrayList<>();
        List<ListNode> moreX = new ArrayList<>();
        ListNode tmp = head;
        while(tmp != null){
            if(tmp.val < x){
                lessX.add(tmp);
            }else{
                moreX.add(tmp);
            }
            tmp = tmp.next;
        }
        ListNode root = new ListNode(0);
        tmp = root;
        while(!lessX.isEmpty()){
            tmp.next = lessX.remove(0);
            tmp = tmp.next;
        }
        while(!moreX.isEmpty()){
            tmp.next = moreX.remove(0);
            tmp = tmp.next;
        }
        tmp.next = null;
        return root.next;
    }
}