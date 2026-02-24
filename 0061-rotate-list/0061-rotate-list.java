/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        int n=1;
        ListNode tail=head;
        while(tail.next!=null){
            tail=tail.next;
            n++;
        }
        k=k%n;
        if(k==0)return head;
        ListNode dummy2=head;
        int forward=n-k;
        int i=1;
        while(i!=forward){
            dummy2=dummy2.next;
            i++;
        }
        tail.next=head;
        head=dummy2.next;
        dummy2.next=null;

        return head;


    }
}