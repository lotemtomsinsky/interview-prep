package LinkedList;
// https://neetcode.io/problems/reverse-a-linked-list


public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // at the beginning there's no prev
        ListNode current = head; // we start at the head

        while (current != null) // while we're not at the end of the list 
        {
            ListNode next  = current.next; // store the next node in the list
            current.next = prev; // reverse the pointer 
            prev = current; // the previous becomes the current node
            current = next; // current node becomes the next
        }

        // at the end of the loop, this will be what used to be the final
        // node but since the pointers are reversed, is now the head
        return prev; 
    }
}
