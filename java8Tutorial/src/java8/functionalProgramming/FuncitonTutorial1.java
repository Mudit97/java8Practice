package java8.functionalProgramming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class FuncitonTutorial1 {
    public static void main(String[] args) {
        /*Function<Integer, Integer> add1 = x->x+1;
        int a=  add1.apply(5);
        System.out.println(a);

        //  Static method reference
        Function<Integer, Integer> add2 = Utils::add;
        int b= add2.apply(10);
        System.out.println(b);

        Function<Integer,Integer> mul1 = x->x*3;
        BinaryOperator<Function<Integer, Integer>> compose = (a1, m1)->x ->a1.apply(m1.apply(x));
        Function<Integer, Integer> h = compose.apply(add1, mul1);
        System.out.println(h.apply(5));


        Function<Integer, Integer> compose2 = mul1.compose(add1);
        System.out.println(compose2.apply(5));*/

    // Example to show that we can't throw exception from inside lambda expression of an inbuilt function interface

        /*Function<Integer, Integer> divide = (x) -> {
            BufferedReader br = new BufferedReader(new FileReader("home/abc.txt"));
            String line;

            while((line = br.readLine())!=null) System.out.println(line);

        };
        System.out.println(divide.apply(5));*/
        int x =5;
//        AtomicInteger x = new AtomicInteger(5);
        Function<Integer, Integer> change = (y)->{
            int z = x;
            return z;
        };
//        x++;
//        int z = x.get();
        System.out.println(change.apply(x));
    }
}
