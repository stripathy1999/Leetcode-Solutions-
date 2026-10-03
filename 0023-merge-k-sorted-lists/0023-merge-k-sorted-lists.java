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
        //We can use this too.. but in Java priority queues are by default min-heap
        //PriorityQueue<ListNode> minHeap = new PriorityQueue<>();
        if(lists==null || lists.length==0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));
       
        for(ListNode listHead : lists){
            if(listHead != null){
                minHeap.add(listHead);
            }
        }
        ListNode dummy_head = new ListNode(0);
        ListNode current = dummy_head;

        while(!minHeap.isEmpty()){
            ListNode smallNode = minHeap.poll();
            current.next = smallNode;
            current = current.next;

            if(smallNode.next!=null){
                minHeap.add(smallNode.next);
            }
        }
        return dummy_head.next;
    }
}