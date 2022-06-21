package src.task1;

import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = (ArrayList<Integer>) randomIntsGenerator();
        System.out.println(list1 + " <- New ARRAYLIST ");

        List<Integer> copiesSortedList = new ArrayList<>(list1.stream().distinct().toList());
        System.out.println(copiesSortedList);

        copiesSortedList.replaceAll(integer -> integer * 2);
        System.out.println(copiesSortedList);

        List<Integer> sortedList = copiesSortedList.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        sortedList.stream().limit(4).forEach(System.out::println);

        System.out.println(sortedList.stream().count());

        System.out.println(Task1.calculateAverage(sortedList));

    }

    private static List<Integer> randomIntsGenerator() {
        return new Random()
                .ints(20, 1, 21)
                .boxed()
                .collect(Collectors.toList());
    }

    private static double calculateAverage(List<Integer> list) {
        return list.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }

}
