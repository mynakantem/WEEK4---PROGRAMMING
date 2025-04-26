import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ReverseQueue {

    public static <T> void reverse(Queue<T> queue) {
        Stack<T> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        reverse(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}
