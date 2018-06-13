import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExpressions {
    public static double average(List<Integer> list) {
        return list.stream()
                .mapToInt(value -> value)
                .average()
                .orElse(0);
    }

    public static List<String> upperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static List<String> startsWithSAndHasFourLetters(List<String> list) {
        return list.stream()
                .filter(element -> (element.startsWith("s") || element.startsWith("S")) && element.length() == 4)
                .collect(Collectors.toList());
    }

    public static String modifyAccordingToOddOrEven(List<Integer> list) {
        return list.stream()
                .map(element -> element % 2 == 0 ? "p" + element : "n" + element)
                .collect(Collectors.joining(", "));
    }

    public static List<String> sortAlphabetically(List<String> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> sortReverseAlphabetically(List<String> list) {
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static List<String> sortOnlyAccordingToFirstChar(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(e -> e.charAt(0)))
                .collect(Collectors.toList());
    }

    public static List<String> sortIfStartsWithE(List<String> list) {
        return list.stream()
                .sorted((e1, e2) -> {
                    int sortFlag = 0;
                    if (e1.charAt(0) == 'e' && e2.charAt(0) != 'e') {
                        sortFlag = -1;
                    } else if (e1.charAt(0) != 'e' && e2.charAt(0) == 'e') {
                        sortFlag = 1;
                    }
                    return sortFlag;
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        //average
        List<Integer> integerList = Arrays.asList(-20, 4, 6, 10, 20);
        System.out.println(average(integerList));

        //upperCase
        List<String> stringList = Arrays.asList("asd", "DeS", "DES", "DsdasdSdS", "asdD");
        System.out.println(upperCase(stringList));

        //startsWithSAndHasFourLetters
        List<String> stringListStartingWithS = Arrays.asList("asd", "SeSd", "SES", "ssdS", "sasdD");
        System.out.println(startsWithSAndHasFourLetters(stringListStartingWithS));

        //modifyAccordingToOddOrEven
        List<Integer> evenOddIntegers = Arrays.asList(-20, 3, 5, 10, 20, 123);
        System.out.println(modifyAccordingToOddOrEven(evenOddIntegers));

        //sortAlphabetically
        List<String> listToSort = Arrays.asList("ac", "aa", "asd");
        System.out.println(sortAlphabetically(listToSort));

        //sortReverseAlphabetically
        List<String> listToSortReverse = Arrays.asList("ac", "aa", "asd");
        System.out.println(sortReverseAlphabetically(listToSortReverse));

        //sortOnlyAccordingToFirstChar
        List<String> listToSortFirstChar = Arrays.asList("ac", "aa", "asd");
        System.out.println(sortOnlyAccordingToFirstChar(listToSortFirstChar));

        //sortIfStartsWithE
        List<String> listToSortE = Arrays.asList("ed", "asd", "edsa", "dfrfw", "ead", "eda");
        System.out.println(sortIfStartsWithE(listToSortE));
    }
}
