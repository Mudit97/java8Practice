package java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@FunctionalInterface
interface  book {
    void show_book() throws IOException;       // only 1 abstract method possible

    default boolean isBook() {
        return true;
    }
    static void book_name(){

    }
}
@FunctionalInterface
interface addable{
    int add(int a, int b);
}
@FunctionalInterface
interface PerformOperation{
    boolean check(int num);
}
@FunctionalInterface
interface Calculator{
    int calculate(int a, int b);
}
public class Lambda1 {
    public static void main(String[] args) {
        /*book exp1 = new book(){
            public void show_book(){System.out.println("The Godfather");}
        };
        exp1.show_book();
        book exp2 = ()->{
            System.out.println("And then there were none");
        };
        exp2.show_book();
        System.out.println(exp2.isBook());
        */
       /* addable add1 = (a,b)->(a+b);
        System.out.println(add1.add(5,6));
        book exp3 = ()->("The God Delusion");
        System.out.println(exp3.show_book());
        PerformOperation isOdd = (num )-> (num%2==0? false:true);
        System.out.println(isOdd.check(7));*/

        Calculator expression1 = (a,b)->{
            a++;
            System.out.println(a/b);
            return  a/b;
        };
        System.out.println(expression1.calculate(2,0));         // can't throw an exception from lambda expression
                                                        // either catch it or add throw in the interface  abstract method

        book expression2 = ()->{
            BufferedReader br = new BufferedReader(new FileReader("home/abc.txt"));
            String line;

            while((line = br.readLine())!=null) System.out.println(line);
        };

    }
}

