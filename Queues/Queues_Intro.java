// QUEUE IMPLEMENTATION USING ARRAYS

public class Queues_Intro {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(2);
        q.add(3);
        q.add(4);
        q.display();
    }
}

class Queue{
    static int[] arr; 
    static int rear = -1; static int size;
    Queue(int size){
        arr = new int[size];
        this.size = size;
    }

    static void add(int element){ // Enqueue
        if(rear==size-1){
            System.out.println("QUEUE FULL"); return;
        }
        rear++;
        arr[rear] = element;
    }

    static int remove(){ // Dequeue
        if(rear==-1) return -1;
        int front = arr[0];
        for(int i=0;i<rear;i++){
            arr[i] = arr[i+1];
        }
        rear--;
        return front;
    }

    static int peek(){
        if(rear==-1) return -1;
        int front = arr[0];
        return front;
    }

    static void display(){
        for(int i=0; i<=rear; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
