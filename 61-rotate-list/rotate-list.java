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
        if(head==null)return null;
        int n=1;
        ListNode temp = head;
        while(temp.next!=null){
            n++;
            temp=temp.next;
        }
        k%=n;
        temp.next = head;
        for(int i=0;i<n-k;i++)temp=temp.next;
        ListNode newNode = temp.next;
        temp.next = null;
        return newNode;
    }
}