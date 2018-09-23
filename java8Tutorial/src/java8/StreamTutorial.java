package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTutorial {
    public static void main(String[] args) {

    List<Integer> integerList = Arrays.asList(5,4,8,7);
    List<Integer> squareList = integerList.stream().map(x->x*x).collect(Collectors.toList());
    squareList.stream().forEach(System.out::println);
    List<Integer> sortedIntegerList = integerList.stream().sorted().collect(Collectors.toList());
    System.out.println(sortedIntegerList);
    List<Integer> evenList = integerList.stream().filter(x->x%2==0).collect(Collectors.toList());
    System.out.println(evenList);
    }
}
