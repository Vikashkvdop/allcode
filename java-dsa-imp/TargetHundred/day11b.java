package TargetHundred;

public class day11b {
    public static class CircularQueue {
        private int[] queue;
        private int front;
        private int rear;
        private int size;
        private int count; // number of elements

        public CircularQueue(int size) {
            this.size = size;
            queue = new int[size];
            front = 0;
            rear = -1;
            count = 0;
        }

        // Add element
        public boolean enqueue(int value) {
            if (isFull()) {
                System.out.println("Queue is full");
                return false;
            }
            rear = (rear + 1) % size;
            queue[rear] = value;
            count++;
            return true;
        }

        // Remove element
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int removed = queue[front];
            front = (front + 1) % size;
            count--;
            return removed;
        }

        // Peek front
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return queue[front];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == size;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.print("Queue: ");
            for (int i = 0; i < count; i++) {
                int index = (front + i) % size;
                System.out.print(queue[index] + " ");
            }
            System.out.println();
        }
    }
     public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        cq.display(); // Queue: 10 20 30 40 50

        cq.dequeue(); // removes 10
        cq.dequeue(); // removes 20
        cq.display(); // Queue: 30 40 50

        cq.enqueue(60);
        cq.enqueue(70);
        cq.display(); // Queue: 30 40 50 60 70

        cq.enqueue(80); // Queue full
    }

}
