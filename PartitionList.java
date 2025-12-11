import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // Dummy heads for two lists
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        // Pointers to build lists
        ListNode before = beforeHead;
        ListNode after = afterHead;

        // Traverse the original list
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // End the 'after' list
        after.next = null;

        // Connect before list with after list
        before.next = afterHead.next;

        // Return the head of new partitioned list
        return beforeHead.next;
    }

    // Utility method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Method to build linked list from user input
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Main method to test with user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in list: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter value of x: ");
        int x = sc.nextInt();

        ListNode head = createList(arr);

        System.out.println("\nOriginal List:");
        printList(head);

        PartitionList solution = new PartitionList();
        ListNode result = solution.partition(head, x);

        System.out.println("Partitioned List (x = " + x + "):");
        printList(result);
    }
}