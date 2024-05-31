package Assignment1;

public class Node {

    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null; // By default, the next node is null.
    }
}

