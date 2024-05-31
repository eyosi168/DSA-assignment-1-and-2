package Assignment2;

public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to insert a node at a given position
    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to delete a node at a given position
    public void deleteAtPosition(int position) {
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        }

        if (position == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        if (current.next == null) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        current.next = current.next.next;
    }

    // Method to delete the node after a given node
    public void deleteAfterNode(Node node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Invalid node or no node to delete after");
        }

        node.next = node.next.next;
    }

    // Method to search for a node with a specific value
    public boolean searchNode(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Testing insertAtPos
        list.insertAtPos(1, 1);
        list.insertAtPos(2, 2);
        list.insertAtPos(3, 3);
        list.insertAtPos(4, 2); // Insert 4 at position 2
        list.printList(); // Expected: 1 -> 4 -> 2 -> 3 -> null

        // Testing deleteAtPosition
        list.deleteAtPosition(3); // Delete node at position 3
        list.printList(); // Expected: 1 -> 4 -> 3 -> null

        // Testing deleteAfterNode
        Node secondNode = list.head.next;
        list.deleteAfterNode(secondNode); // Delete node after second node
        list.printList(); // Expected: 1 -> 4 -> null

        // Testing searchNode
        System.out.println(list.searchNode(4)); // Expected: true
        System.out.println(list.searchNode(5)); // Expected: false
    }
}
