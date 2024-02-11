public class LinkedListMergeSort {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Merge sort for linked list
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the list
        Node mid = findMiddle(head);

        // Split the list into two halves
        Node left = head;
        Node right = mid.next;
        mid.next = null; // Break the link

        // Recursively sort each half
        Node sortedLeft = mergeSort(left);
        Node sortedRight = mergeSort(right);

        // Merge the sorted halves
        return merge(sortedLeft, sortedRight);
    }

    // Merge two sorted linked lists
    private Node merge(Node left, Node right) {
        Node mergedList = new Node(-1); // Dummy node to simplify code
        Node temp = mergedList;

        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        // Attach the remaining nodes, if any
        if (left != null) {
            temp.next = left;
        }

        if (right != null) {
            temp.next = right;
        }

        return mergedList.next; // Skip the dummy node
    }

    // Find the middle of the linked list using the slow and fast pointers
    private Node findMiddle(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Print the linked list
    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListMergeSort list = new LinkedListMergeSort();

        list.head = new Node(6);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(5);
        list.head.next.next.next.next = new Node(9);
        list.head.next.next.next.next.next = new Node(8);

        System.out.println("Original Linked List:");
        list.printList(list.head);

        // Apply merge sort
        list.head = list.mergeSort(list.head);

        System.out.println("\nSorted Linked List:");
        list.printList(list.head);
    }
}
