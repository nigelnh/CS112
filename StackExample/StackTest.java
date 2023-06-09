import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("("); // Push 5 onto the stack
        stack.push("{"); // Push 10 onto the stack
        stack.push("}"); // Push 15 onto the stack
        stack.push(")"); // Push 15 onto the stack
        
        String top = stack.peek(); // Get the top element (15)
        System.out.println("Top element: " + top);

//        int poppedElement = stack.pop(); // Pop the top element (15)
//        System.out.println("Popped element: " + poppedElement);
//        
//        poppedElement = stack.pop();
//        System.out.println("Popped element: " + poppedElement);
//        
//        poppedElement = stack.pop();
//        System.out.println("Popped element: " + poppedElement);

        boolean isEmpty = stack.isEmpty(); // Check if the stack is empty (false)
        System.out.println("Is the stack empty? " + isEmpty);
        System.out.println(stack);
        
        
    }
}