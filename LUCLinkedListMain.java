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

    public int sumList() {
        Node currNode = head;
        int sum = 0;
        while (currNode != null){
            sum += currNode.data;
            currNode = currNode.next;
        }
        return sum;
    }

    public int maxData() {
        Node currNode = head;
        int max = currNode.data;
        while (currNode.next != null){
            if (currNode.next.data > currNode.data){
                max = currNode.next.data;
            }
            currNode = currNode.next;
        }
        return max;
    }

    public String printEvens(){
        Node currNode = head;
        String evens = "";
        while (currNode.next != null){
            if (currNode.data %2 == 0) {
                evens += currNode.data + " ";
            }
            currNode = currNode.next;
        }
        return evens;
    }
    public void removeValue(int val)
        {
            Node currNode = head;
            Node prevNode = null;
            while (currNode != null && currNode.data == val) 
            {
                head = currNode.next;
                currNode = head; 
            }
            while (currNode != null) 
            {
                while (currNode != null && currNode.data != val) 
                {
                    prevNode = currNode;
                    currNode = currNode.next;
                }
                if (currNode == null)
                    return;
                prevNode.next = currNode.next;
                currNode = prevNode.next;
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
        list.insert(9);
        list.printList(); // Print the LinkedList
        System.out.println();
        System.out.println("the sum is: " + list.sumList());
        System.out.println("the max value is " + list.maxData());
        System.out.println("the even values are: " + list.printEvens());
        list.removeValue(2);
        list.printList();


    }
}