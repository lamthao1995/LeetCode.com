/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return head;
        RandomListNode p = head;
        while(p != null){
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }
        p = head;
        //copy random pointer for each new node
        while(p != null){
            if(p.random != null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head;
        RandomListNode newHead = head.next;
        while(p != null){
            RandomListNode tmp = p.next;
            p.next = tmp.next;
            if(tmp.next != null)
                tmp.next = tmp.next.next;
            p = p.next;
        }
        return newHead;
    }
}