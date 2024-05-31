package Assignment2;

public class Stack {

    private Node top;

    public Stack() {
        this.top = null;
    }

    // Method to push an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Method to pop an element from the stack
    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    // Method to peek the top element of the stack
    public int peek() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        // Testing push
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Testing peek
        System.out.println(stack.peek()); // Expected: 3

        // Testing pop
        System.out.println(stack.pop()); // Expected: 3
        System.out.println(stack.pop()); // Expected: 2
        System.out.println(stack.pop()); // Expected: 1

        // Testing isEmpty
        System.out.println(stack.isEmpty()); // Expected: true
    }
}
