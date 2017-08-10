/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    int k = 2;
    public ListNode swapPairs(ListNode head) {
 //  if(k == 0 || head == null || k == 1) return head;
        int numberOfElement = 0;
        ListNode end = null;
        ListNode current = head;
        while(current != null){
            numberOfElement++;
            current = current.next;
        }
        current = head;
        int b = numberOfElement / k;
        if(b == 0) return head;
        int i = 1;
        ListNode rs[] = new ListNode[3];
      //  end = current;
        while(i <= b){
           rs = split(current, k);
          // end.next = rs[1];
           if(i == 1) {
               head = rs[1];
               end = head;
                while(end.next != null){
                end = end.next;
                }
           }else{
                end.next = rs[1];
            while(end.next != null){
                end = end.next;
            }
           }
           current = rs[2];
           
           
            i++;
        }
        if(current != null)
        end.next = current;
      //  printNode(head);
      //  System.out.println("i : " + i );
        return head;
    }
   
    public static ListNode[] split(ListNode head, int k) {
        ListNode[] rs = new ListNode[3];
        ListNode endOfPrev, next, prev;
        endOfPrev = head;
        prev = null;
        ListNode current = head;
        int counter = 0;
        current = head;
        while(current != null){
            counter++;
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            if(counter == k) break;
            
        }
        rs[0] = head;
        rs[1] = prev;
        rs[2] = current;
       // printNode(prev);
        
        return rs;
    }
}