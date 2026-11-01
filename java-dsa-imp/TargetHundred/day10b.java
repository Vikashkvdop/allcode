package TargetHundred;

public class day10b {
    //Implement queue using array
    public static class Queue{
        private int front;
        private int rear;
        private int count;
        private int[] queueArray;
        private int maxSize;

        //constructor for initialzation queue
        public Queue(int size){
            maxSize=size;
            count=0;
            front=0;
            rear=-1;
            queueArray=new int[size];
        }
        public boolean isFull(){
            return count==maxSize;
        }
        public boolean isEmpty(){
            return count==0;
        }
        //enqueue add to queue
        public void enqueue(int value){
            if (isFull()) {
                System.out.println("Queue overflow! cant't enqueue"+value);
            }else{
                rear=(rear+1)%maxSize;
                queueArray[rear]=value;
                count++;
                System.out.println("Enqueue:"+value);
            }
        }
        // Dequeue removing to queue
        public int dequeue(){
            if (isEmpty()) {
                System.out.println("Queue is underflow! can't dequeue or empty");
                return -1;
            }else{
                front=(front+1)%maxSize;
                int Dequeue=queueArray[front];
                
                count--;
                return Dequeue;
            }
        }
        //peek
        public int peek(){
            if (isEmpty()) {
                System.out.println("Queue is empty! Can't peek");
                return -1;
            }else{
                return queueArray[front];
                
            }
        }
        //Display elements
        public void display(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
            }else{
                System.out.print("Queue elements: ");
                for(int i=0; i<count; i++){
                    int index=(front+i)%maxSize;
                    System.out.print(queueArray[index]+" ");
                }
                System.out.println();

            }
        }
    }
    public static void main(String[] args) {
        Queue queue=new Queue(5);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(9);
        queue.display();

        queue.dequeue();
        queue.display();
        System.out.println(queue.peek());
    }
}
