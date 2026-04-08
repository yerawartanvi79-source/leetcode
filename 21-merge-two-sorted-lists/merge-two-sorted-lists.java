class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        // Step 1: Create dummy node
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Step 2: Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Step 3: Attach remaining elements
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Step 4: Return result
        return dummy.next;
    }
}