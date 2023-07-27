class Node {
       int data; 
       Node next;  
       Node(int d) // Constructor
       { 
               data = d; 
               next = null; 
       } 
} 

class LUCLinkedList {// a Singly Linked List
    Node head; // head of list

    public void insert (int data) // Method to insert a new node
    {
        Node new_node = new Node(data); // Create a new node with given data
        new_node.next = null;
        if (head == null) { // If the Linked List is empty, then make the new node as head
            head = new_node;
        } else {// Else traverse till the last node and insert the new_node there
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node; // Insert the new_node at last node
        }
    }

    public void printList() // Method to print the LinkedList.
    {
        Node currNode = head;
        System.out.print("LinkedList: ");
        while (currNode != null) { // Traverse through the LinkedList
            System.out.print(currNode.data + " "); // Print the data at current node
            currNode = currNode.next; // Go to next node
        }
    }
    // Method to sum the data in each node
    public int addData(){
        //initialize the sum
        int sum = 0;
        //check if there's any data
        if(head == null){
            sum = 0;
            System.out.println("List is empty");
        //assuming there is, iterate over the list and add all the data
        } else {
            Node iterator = head;
            while (iterator != null){
                sum = sum + iterator.data;
                iterator = iterator.next;
            }
        } 
        //return the sum
        return sum;
    }
    
    //Method to determine the maximum data value in the list
    public int maxData(){
        //intialize the max variable
        int max = 0; 
        //check if theres anything in the list
        if (head == null){
            max = 0;
            System.out.println("List is empty");
        //assumign there is, iterate the list and check if each data value is greater than the stored max
        } else {
            Node iterator = head;
            max = head.data;
            while (iterator != null){
                if(iterator.data > max){
                    max = iterator.data; 
                }
            iterator = iterator.next;
            }
        }
        //return the maximum value
        return max;
    }
    public void printEvens(){
        //check if theres anything in the list
        if (head == null){
            System.out.println("List is empty");
        //assumign there is, iterate the list and check if each data value is greater than the stored max
        } else {
            Node iterator = head;
            while (iterator != null){
                if(iterator.data %2 == 0){
                    System.out.println(iterator.data);
                }
                iterator = iterator.next;
            }
        }
        
    }

    public void removeValue(int target){
        // Check if the list is empty
        if (head == null) {
            return;
        }

        // Handle cases where the target value is at the beginning of the list
        while (head != null && head.data == target) {
            head = head.next;
        }

        Node current = head;
        Node prev = null;

        // Traverse the list and remove nodes with matching data
        while (current != null) {
            if (current.data == target) {
                // Remove the current node
                prev.next = current.next;
                current = current.next;
            } else {
                // Move to the next node
                prev = current;
                current = current.next;
            }
        }
    }

    

}




public class LUCLinkedListMain {
    public static void main(String[] args)
    {
        LUCLinkedList list = new LUCLinkedList();/* Start with the empty list. */
        // Insert the values
        list.insert(2);
        list.insert(2);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(2);
        list.insert(2);
        list.printList(); // Print the LinkedList
        System.out.println();
        System.out.println("the sum is: " + list.addData());
        System.out.println("the max value is: " + list.maxData());
        list.printEvens();
        list.removeValue(2);
        list.printList();
    }
}
