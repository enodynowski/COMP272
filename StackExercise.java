import java.util.Stack;

public class StackExercise {
    
    public static void main(String[] args){
        //create Stack using built in Java class
        Stack<Integer> newStack = new Stack<Integer>();

        
        //push elements into stack
        newStack.push(1);
        newStack.push(3);
        newStack.push(9);
        newStack.push(4);
        newStack.push(0);
        newStack.push(1);
        newStack.push(2);
        newStack.push(5);
        newStack.push(6);
        System.out.println("The stack is: " + newStack);
        newStack = (Stack<Integer>)reverseStack(newStack).clone();
        newStack = (Stack<Integer>)insertAtIndex(newStack, 3, 8).clone();
        System.out.println("The minimum index is: " + minIndex(newStack, 1));
        System.out.println(isPalindrome("racecar"));
    }

    //reverse the stack
    public static Stack reverseStack(Stack stack){
        //clone the stack into a temp one
        Stack temp = (Stack) stack.clone();
        //pop and print all the items 
        System.out.print("The stack reversed is: ");
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        //return the original stack, untouched.
        return temp;
    }
    //insert a value at a given index
    public static Stack<Integer> insertAtIndex(Stack<Integer> stack, int index, int val){
        stack.add(stack.size() - index, val);
        System.out.println("Inserted value " + val + " at index " + index + ": " + stack);
        return stack;
    }
    //retrieve the minimum index at which a value occurs
    public static int minIndex(Stack<Integer> stack, int val){
        int index;
        /*
          by default java thinks that the most recently added value in a stack is at index 0. 
          This operation fixes that and ensures that the bottom-most value is the value at index 0.
        */
        index = (stack.size() - 1) - stack.lastIndexOf(val);
        return index;
    }

    public static boolean isPalindrome(String str){
        //create some vars to store our data
        boolean b = true;
        Stack<Character> reversed = new Stack<Character>();
        Stack<Character> stack = new Stack<Character>();
        Stack<Character> temp = (Stack<Character>)stack.clone();
        //add the characters from our input string to a stack
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        //reverse the stack by popping the elements into a new one
        while (!stack.isEmpty()){
            reversed.push(stack.pop());
        }
        //for each character in the original stack...
        for (Character character : temp) {
            //check if it is the same as the corresponding character at the same index in the reversed array 
            if(reversed.elementAt(temp.indexOf(character)) != character){
                //if not, then it isnt a palindrome
                b = false;
            }
        }
        return b;
    }
}