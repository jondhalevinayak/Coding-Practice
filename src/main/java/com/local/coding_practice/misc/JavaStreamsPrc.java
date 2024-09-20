package com.local.coding_practice.misc;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class JavaStreamsPrc {

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple", "strawberry"};

        //count each word occurrence
        Map<String, Long> map = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("===============================================================");

        //Longest String
        Optional<String> maxLengthWord = Arrays.stream(words).max(Comparator.comparingInt(String::length));
        System.out.println(maxLengthWord.get());

        System.out.println("===============================================================");

        //remove duplicates and keep them in the descending order using streams.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 1);
        List<Integer> collect = numbers.stream().distinct().sorted(Comparator.comparingInt(Integer::intValue).reversed()).toList();
        System.out.println(collect);

        System.out.println("===============================================================");

        //find the average of a list of doubles using streams.
        List<Double> doubles = Arrays.asList(1.2, 3.5, 2.8, 4.1, 5.7);
        OptionalDouble average = doubles.stream().mapToDouble(Double::doubleValue).average();
        System.out.println((average.isPresent()) ? average.getAsDouble() : "Not Present");

        System.out.println("===============================================================");

        //Merge two lists of integers and remove duplicates using streams.
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4, 5);
        List<Integer> disctinctList = Stream.concat(list1.stream(), list2.stream()).distinct().collect(toList());
        System.out.println(disctinctList);

        System.out.println("===============================================================");

        //concatenate them into a single string using streams.
        List<String> list = Arrays.asList("Hello", " ", "world", "!");
        String contactString = list.stream().collect(Collectors.joining());
        System.out.println(contactString);

        System.out.println("===============================================================");

        //first non-repeating character in a string using streams.
        String str = "ababdrert";
        Optional<Character> firstNonRepeatingChar = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1L).map(Map.Entry::getKey).findFirst();

        System.out.println(firstNonRepeatingChar.get());

        System.out.println("===============================================================");

        //remove all strings that contain a specific character using streams.
        List<String> listStr = Arrays.asList("apple", "banana", "orange", "kiwi");
        char specificChar = 'a';

        List<String> strList = listStr.stream().filter(s -> !s.contains(String.valueOf(specificChar))).toList();
        System.out.println(strList);

        System.out.println("===============================================================");

        //list of integers, partition them into two groups: odd and even, using streams.
        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> map1 = numbersList.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        map1.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println("===============================================================");

        //array of integers, find the kth largest element.
        List<Integer> list3 = Arrays.asList(1, 12, 44, 32, 52, 81, 59, 84, 72, 37);
        int k = 4;
        Integer kthLargest = list3.stream().sorted(Comparator.reverseOrder()).limit(k).skip(k - 1).findFirst().orElse(-1);
        System.out.println(kthLargest);

        System.out.println("===============================================================");

        //perform cube on list elements and filter numbers greater than 50
        List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
        integerList.stream().map(i -> i * i * i).filter(i -> i > 50).forEach(System.out::println);

        System.out.println("===============================================================");

        //find the count of strings starting with a vowels.
        List<String> list4 = Arrays.asList("apple", "banana", "orange", "kiwi", "strawberry");
        long count = list4.stream().filter(s -> "aeiouAEIOU".contains(String.valueOf(s.charAt(0)))).count();
        System.out.println(count);

        System.out.println("===============================================================");

        //list of strings, find the longest palindrome string.
        List<String> list5 = List.of("level", "hello", "radar", "world", "madam", "java", "Malayalam");
        String longestPlaindrome = list5.stream().filter(s -> new StringBuilder(s).reverse().toString().equals(s)).max(Comparator.comparing(String::length)).orElse("");
        System.out.println(longestPlaindrome);

        System.out.println("===============================================================");

        //list of integers, find the product of all non-negative integers.
        List<Integer> integerList1 = Arrays.asList(4, 5, -6, 7, -1, 2, -3);
        long product = integerList1.stream().filter(i -> i >= 0).mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);
        System.out.println(product);

        System.out.println("===============================================================");

    }
}
