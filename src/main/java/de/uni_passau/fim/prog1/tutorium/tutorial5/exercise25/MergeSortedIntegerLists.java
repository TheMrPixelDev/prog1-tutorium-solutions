package de.uni_passau.fim.prog1.tutorium.tutorial5.exercise25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create a method {@link #mergeSortedIntegerLists(List, List) mergeSortedIntegerLists(List<Integer>, List<Integer>)}
 * which takes two sorted lists as parameters and returns a merged (also sorted) list.
 * If one of the two lists is empty the other one will be printed.
 * Please mind that both list most not be of the same size.
 * Example: ([1,3,5,7,8],[2,4,6,9,10]) => [1,2,3,4,5,6,7,8,9,10]
 *
 * @author <a href="https://github.com/werli">Phil Werli<a/>
 */
public class MergeSortedIntegerLists {
    public static void main(String[] args) {
        final List<Integer> first = Arrays.asList(1, 3, 5, 7, 8);
        final List<Integer> second = Arrays.asList(2, 4, 6, 9, 10);
        System.out.println("first = " + first);
        System.out.println("second = " + second);
        System.out.println("mergeSortedIntegerLists(first, second) = " + mergeSortedIntegerLists(first, second));
    }

    /**
     * Merges two lists from the parameters into a sorted list and returns is.
     *
     * @param first first list.
     * @param second second list.
     * @return a sorted list which consists of the elements from the two lists from the parameters.
     */
    @SuppressWarnings("Duplicates")
    private static List<Integer> mergeSortedIntegerLists(final List<Integer> first, final List<Integer> second) {
        if (first.isEmpty()) {
            return second;
        }
        if (second.isEmpty()) {
            return first;
        }

        final List<Integer> resultingList = new ArrayList<>();

        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < first.size() && secondIndex < second.size()) {
            final Integer a = first.get(firstIndex);
            final Integer b = second.get(secondIndex);

            if (a < b) {
                resultingList.add(a);
                firstIndex++;
            } else {
                resultingList.add(b);
                secondIndex++;
            }
        }
        while (firstIndex < first.size()) {
            resultingList.add(first.get(firstIndex));
            firstIndex++;
        }
        while (secondIndex < second.size()) {
            resultingList.add(second.get(secondIndex));
            secondIndex++;
        }

        return resultingList;
    }
}
