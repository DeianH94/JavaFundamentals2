package moreExercises;

import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] lis = new int[sequence.length];
        int[] prev = new int[sequence.length];
        int maxSolution = 0;
        int maxSolutionIndex = 0;

        for (int i = 0; i < sequence.length; i++) {
            int solution = 1;
            int prevIndex = -1;

            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j] && lis[j] + 1 > solution)
                {
                    solution = lis[j] + 1;
                    prevIndex = j;
                }
            }

            lis[i] = solution;
            prev[i] = prevIndex;

            if (solution > maxSolution)
            {
                maxSolution = solution;
                maxSolutionIndex = i;
            }
        }

        int index = maxSolutionIndex;
        List<Integer> list = new ArrayList<>();

        while (index != -1) {
            list.add(sequence[index]);
            index = prev[index];
        }

        Collections.reverse(list);

        for (Integer number : list) {
            System.out.print(number + " ");
        }
    }
}
