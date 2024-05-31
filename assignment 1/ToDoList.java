package Assignment1;

public class ToDoList {
    private Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markToDoAsCompleted(String title) {
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                return;
            }
            current = current.next;
        }
        System.out.println("Task with title \"" + title + "\" not found.");
    }

    public void viewToDoList() {
        Node current = head;
        while (current != null) {
            Task task = current.task;
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
            System.out.println();
            current = current.next;
        }
    }

    public static void main(String[] args) {
        // Create an instance of ToDoList
        ToDoList toDoList = new ToDoList();

        // Add tasks to the to-do list
        toDoList.addToDo(new Task("Task 1", "Description of Task 1"));
        toDoList.addToDo(new Task("Task 2", "Description of Task 2"));
        toDoList.addToDo(new Task("Task 3", "Description of Task 3"));

        // View the to-do list
        System.out.println("To-Do List:");
        toDoList.viewToDoList();

        // Mark a task as completed
        toDoList.markToDoAsCompleted("Task 2");

        // View the updated to-do list
        System.out.println("Updated To-Do List:");
        toDoList.viewToDoList();
    }
}
