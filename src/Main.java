import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(5,23,6,0,12,123,6,5,1,99,3,4,1,2);
        //Sum of elements
        //1 way
        long sum = list1.stream().mapToInt(x -> Integer.valueOf(x)).sum();
        //2 way
        long sum1 = IntStream.range(0,list1.size()).map(x -> list1.get(x)).sum();

        double avarage = list1.stream().mapToInt(x -> Integer.valueOf(x)).average().getAsDouble();

        //Finding duplicate values
        //1 way
        Set<Integer> set = new HashSet<>();
        long countOfRepeat1 = list1.stream().filter(x -> !set.add(x)).count();

        //2 way
        List<Integer> list2 = new ArrayList<>(list1);
        List<Integer> list2_1 = list2.stream().distinct().toList();
        for (Integer elem: list2_1) {
            list2.remove(elem);
        }

        //3 way
        List<Integer> list3 = new ArrayList<>(list1);
        List<Integer> list3_1 = list3.stream().distinct().toList();
        list3_1.stream().filter(x -> list3.remove(x)).toList();

        //4 way
        List<Integer> list4 = new ArrayList<>(list1);
        Set<Integer> set1 = list4.stream().collect(Collectors.toSet());
        for (Integer elem: set1) {
            list4.remove(elem);
        }

        //5 way
        List<Integer> list5 = new ArrayList<>(list1);
        List<Integer> list5_1 = new ArrayList<>();
        long countOfRepeat5 = IntStream
                .range(0, list5.size())
                .filter(x -> list5.subList(x + 1, list5.size()).contains(list5.get(x)))
                .mapToObj(x -> list5_1.add(list5.get(x)))
                .count();

        System.out.printf("Sum (1 way): %d \nSum (2 way): %d \nAvarage: %f", sum, sum1, avarage);
        System.out.printf("\nNumber of repetitions \n1 way: %d \n2 way: %d \n3 way: %d \n4 way: %d \n5 way: %d", countOfRepeat1, list2.size(), list3.size(), list4.size(), countOfRepeat5);
    }
}