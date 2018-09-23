package java8.producerConsumer;

import java.util.Queue;

public class Producer1 implements Runnable{
    private Queue<Integer> buffer;
    private int capacity;

    public Producer1(Queue buffer, int capacity){

        this.buffer = buffer;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        try {
            int i=1;
            while(true){
                synchronized (buffer){
                    System.out.println(buffer.size());
                    while(buffer.size()==capacity){
                        System.out.println("Queue full! Waiting for consumer to consume");
                        buffer.wait();
                    }
                    System.out.println("Producing :"+i);
                    buffer.add(i++);
                    buffer.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
