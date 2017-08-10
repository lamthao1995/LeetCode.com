/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode root;
    int k;
    int counter = 0;
    public ListNode reverseKGroup(ListNode head, int k) {
        root = head;
        this.k = k;
        int length = 0;
        ListNode t = root;
        while(t != null){
            length++;
            t = t.next;
        }
        if(k == 1 || length < k) return head;
        reverse(length);
        return root;
    }
     public void reverse(int length){
        ListNode trace = null; ListNode tail = null;
        ListNode curr = root;
        ListNode prev = null;
        ListNode temp = null;
         int count = 1;
        while(curr != null){
             ListNode temp_tail = null;
            if(counter == (int) (length / k)){
                tail.next = curr;
                break;
            }
                while(count <= k){
                     if(count == 1){
                        temp_tail = curr;
                    }
                    count++;
                    temp = prev;
                     prev = curr;
                     curr = curr.next;
                     prev.next = temp;
                     if(curr == null){
                         count = this.k + 1;
                         break;
                     }
                }
                if(count > k){
                    count  = 1;
                    counter++;
                        if(trace == null) {
                            trace = prev;
                            tail = temp_tail;
                        }
                        else{
                            tail.next = prev;
                            tail = temp_tail;
                        }
                        
                     
                         prev = null; temp = null;
                      //   System.out.println("trace = " + trace.key) 
                }
         
        }
        root = trace;
    }
}