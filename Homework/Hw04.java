package Algo2023.Homework;

import java.util.Arrays;

class ArrayQueue {
     int[] queue;
     int maxLength;
     int head, rear, length;

    ArrayQueue(int arrLength) {
        this.head = 0;
        this.rear = 0;
        this.length = 0;
        this.maxLength = arrLength;
        this.queue = new int[arrLength];
    }

    public boolean isFull() {
        return (rear + 1) % maxLength == head;
    }

    public boolean isEmpty() {
        return head == rear;
    }

    public void enqueue(int val) {
        if ( !isFull() ) {
            queue[rear] = val;
            rear = (rear + 1) % maxLength;
            length++;
        }
    }

    public void dequeue() {
        if ( !isEmpty() ) {
            queue[head] = 0;
            head = (head + 1) % maxLength;
            length--;
        }
    }

    public String toString() {
        return Arrays.toString(this.queue);
    }

}

public class Hw04 {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(4);
        try {
            aq.enqueue(1);
            aq.enqueue(2);
            aq.enqueue(3);
            aq.dequeue();
            aq.dequeue();
            System.out.println(aq.head + " " + aq.rear);
            aq.enqueue(4);
            aq.enqueue(1);
//            aq.enqueue(2);
            System.out.println(aq.head + " " + aq.rear);
//            aq.enqueue(5);
        } catch (Exception ignored) {

        }

//        aq.enqueue(4);
//        aq.enqueue(5);
        System.out.println(aq);
    }

}
