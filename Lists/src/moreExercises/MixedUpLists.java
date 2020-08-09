package moreExercises;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        Collections.reverse(secondList);

        List<Integer> joinedList = new ArrayList<>();

        for (int i = 0; i < Math.min(firstList.size(), secondList.size()); i++) {
            joinedList.add(firstList.get(i));
            joinedList.add(secondList.get(i));
        }

        int firstLimit;
        int secondLimit;
        if (firstList.size() > secondList.size()) {
            firstLimit = firstList.get(firstList.size() - 2);
            secondLimit = firstList.get(firstList.size() - 1);
        } else {
            firstLimit = secondList.get(secondList.size() - 2);
            secondLimit = secondList.get(secondList.size() - 1);
        }

        for (int i = 0; i < joinedList.size(); i++) {
            if (joinedList.get(i) <= Math.min(firstLimit, secondLimit)
                    || joinedList.get(i) >= Math.max(firstLimit, secondLimit)) {
                joinedList.remove(i);
                i--;
            }
        }

        Collections.sort(joinedList);
        System.out.println(joinedList.toString().replaceAll("[\\[\\],]", ""));
    }
}
