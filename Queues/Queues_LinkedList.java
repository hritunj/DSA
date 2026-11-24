// QUEUE USING LINKED LIST
import java.util.*; 
public class Queues_LinkedList {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data; next = null;
        }
    }

    static class Queue{
        static Node head; // head is front
        static Node tail; // tail is rear

        public static boolean isEmpty(){
            return head==tail;
        }

        public static void add(int data){ // Enqueue
            Node newNode = new Node(data);
            if(tail==null){ // for first element
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public static int remove(){ // Dequeue
            if(isEmpty()) {
                System.out.println("Empty Node"); return -1;
            }
            if(head == tail){ // single element
                tail= null;
            }
            int front = head.data;
            head = head.next;
            return front;
        }
    }

}
