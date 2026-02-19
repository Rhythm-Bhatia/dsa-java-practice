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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer>heap=new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            while(lists[i]!=null){
                heap.offer(lists[i].val);
                lists[i]=lists[i].next;
            }
        }
        if(heap.size()==0)return null;
        ListNode head=new ListNode(heap.poll());
        
        ListNode dummy=head;
        while(!heap.isEmpty()){
            ListNode something=new ListNode(heap.poll());
            dummy.next=something;
            dummy=dummy.next;
        }
        return head;
    }
}