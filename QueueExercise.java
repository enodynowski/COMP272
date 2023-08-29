import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack; 

public class QueueExercise {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        //add elements
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        System.out.println("Original queue: " + queue);
        //reverse K elements test
        int k = 3;
        reverseKElements(queue, k);
        System.out.println("The queue with the first "+ k + " elements reversed is: " + queue );
        
        //reverse whole queue test
        reverseQueue(queue);
        System.out.println("The reversed queue is: " + queue);


        //canComplete operations test
        int[] input1 = {1, 1, 0, 0, 0};
        int[] input2 = {1, 1, 0, 0, 1};
        int[] input3 = {1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1};
        
        boolean result1 = canCompleteOperations(input1);
        boolean result2 = canCompleteOperations(input2);
        boolean result3 = canCompleteOperations(input3);

        System.out.println("Output for input1: " + result1); // Output: false
        System.out.println("Output for input2: " + result2); // Output: true
        System.out.println("Output for input3: " + result3);

    }


    public static void reverseQueue(Queue<Integer> queue){
        if (queue.isEmpty()){
            return;
        }
        //dequeue the front element
        int front = queue.poll();
        //reverse the remining elements in the queue
        reverseQueue(queue);
        //enqueue the front element at the rear of the reversed queue.
        queue.add(front);

    }
    //method to reverse a certain amount, K, elements of a queue
    public static void reverseKElements(Queue<Integer> queue, int k) {
        if (k <= 0 || k > queue.size()) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        // Create a temporary stack to reverse the first k elements
        Stack<Integer> stack = new Stack<>();

        // Push the first k elements from the queue onto the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Enqueue the reversed elements back into the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // Enqueue the remaining elements back into the queue
        for (int i = 0; i < queue.size() - k; i++) {
            queue.offer(queue.poll());
        }
    }
    //method to check if a given input array of 0s and 1s is a valid operational input for a queue
    public static boolean canCompleteOperations(int[] operations) {
        int offerCount = 0;
        int pollCount = 0;
            for (int i : operations) {
                if ( i == 1 ){
                    offerCount++;
                } else {
                    pollCount++;
                }
                
                if (offerCount < pollCount){
                    return false;
                }
            } 
            return true;


    }
}
