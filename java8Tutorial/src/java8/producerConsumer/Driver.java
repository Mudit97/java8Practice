package java8.producerConsumer;


import java.util.LinkedList;
import java.util.Queue;

public class Driver {
    public static void main(String[] args) {

        Queue<Integer> buffer = new LinkedList<>();
        int capacity = 5;
        /*Thread producer = new Thread(new Producer1(queue, 10));
        Thread consumer = new Thread(new Consumer1(queue, 10));

        //        Thread consumer2 = new Thread(new Consumer());
        producer.start();
        consumer.start();*/

        Thread producer = new Thread(()->{
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
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();
        new Thread(()->{
            try {
            while(true){
                synchronized (buffer){
                    while(buffer.size()==0){
                        System.out.println("Queue empty! Waiting for producer to produce");
                        buffer.wait();
                    }
                    System.out.println("Consuming:"+buffer.remove());
                    buffer.notify();
                    Thread.sleep(1000);
                }
            }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
