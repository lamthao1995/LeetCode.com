/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        Stack<ListNode> result = new Stack(); 
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int hold = 0;
        while(s1.isEmpty() == false && s2.isEmpty() == false){
            int rs = hold + s1.pop() + s2.pop();
            if(rs >= 10){
     			result.push(new ListNode(rs % 10));
                hold = 1;
            }else{
                hold = 0;
				result.push(new ListNode(rs));
            }
        }
        if(!s1.isEmpty()){
            while(!s1.isEmpty()){
                int rs = hold + s1.pop();
                if(rs >= 10){
                    hold = 1;
                	result.push(new ListNode(rs % 10));
                }else{
                    hold = 0;
          			result.push(new ListNode(rs));
                }
               
            }
        }else if(!s2.isEmpty()){
             while(!s2.isEmpty()){
                int rs = hold + s2.pop();
                if(rs >= 10){
                    hold = 1;
                	result.push(new ListNode(rs % 10));
                }else{
                    hold = 0;
                	result.push(new ListNode(rs));
                }
               
             }
        }
        if(hold == 1) result.push(new ListNode(hold));
        ListNode root = result.pop();
        ListNode temp = root;
        while(result.isEmpty() == false){
            temp.next = result.pop();
            temp = temp.next;
        }
        return root;
    }
}