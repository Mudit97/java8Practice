package java8.producerConsumer;

import java.util.ArrayList;
import java.util.List;

public class DataBuffer {

    private final List<Integer> queue = new ArrayList<>();
    private boolean consume = false;
    private static DataBuffer dataBuffer = new DataBuffer();
    private int  max_size=5;

    private DataBuffer(){

    }

    public static DataBuffer getInstance(){
        return dataBuffer;
    }

    void produce(int i){
        try {
            while(queue.size()==max_size){
                synchronized (queue){
                    System.out.println("Queue full! Waiting for consumer to consume");
                    queue.wait();

                }
            }
            synchronized (queue){
                System.out.println("Producing :"+i);
                queue.add(i);
                queue.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    void consume()  {
        try {
            while(queue.size()<=0){
                synchronized (queue){
                    System.out.println("Queue empty. Waiting for producer to produce");
                    queue.wait();
                }
            }
            synchronized (queue){
                System.out.println("Consuming :"+ queue.get(0));
                queue.remove(0);
                queue.notify();
            }
        }catch (InterruptedException e) {
            System.out.println("Interrupted exception "+e);
        }
    }
}
