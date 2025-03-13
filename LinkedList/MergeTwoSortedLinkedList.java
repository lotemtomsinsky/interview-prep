package LinkedList;

public class MergeTwoSortedLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2; 

        ListNode dummy = new ListNode(); // dont yet know what the head is, placehlolder
        ListNode curr3 = dummy; // at the beginning we don't have anything yet
        

        // make the new linked list 
        // while theyre equal lengths, pick the smaller value as curr
        while (curr1 != null && curr2 != null)
        {
            if (curr1.val < curr2.val)
            {
                curr3.next = curr1; // set this as next for l3
                curr1 = curr1.next; // advance pointer for l1
            }
            else
            {
                curr3.next = curr2;
                curr2 = curr2.next;
            }
            curr3 = curr3.next; // move pointer forward for l3
        }

        // if theyre unequal, add whatever leftovers to the end
        if (curr1 != null)
        {
            curr3.next = curr1;
        }
        if (curr2 != null)
        {
            curr3.next = curr2;
        }

        // since we start from dummy, whatever the next value is will be the new head of the list 
        return dummy.next; 
    }
}
