package java8.producerConsumer;

import java.util.Queue;

public class Consumer1 implements Runnable{
    private Queue<Integer> buffer;
    private int capacity;

    public Consumer1(Queue buffer, int capacity){
        this.buffer = buffer;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        try {
//            while(true){
                synchronized (buffer){
//                    System.out.println(buffer.size());
                    while(buffer.size()==0){
                        System.out.println("Queue empty! Waiting for producer to produce");
                        buffer.wait();
                    }
                    System.out.println("Consuming:"+buffer.remove());
                    buffer.notify();
//                    Thread.sleep(1000);
                }
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
