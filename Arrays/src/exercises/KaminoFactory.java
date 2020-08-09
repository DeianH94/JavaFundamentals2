package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sequenceLength = Integer.parseInt(scanner.nextLine());
        String sequence = scanner.nextLine();
        int[] longestSequence = new int[sequenceLength];
        int maxLength = 0;
        int bestSequenceIndex = 0;
        int leftMostIndex = Integer.MAX_VALUE;
        int bestSequenceSum = 0;
        int sampleCount = 0;

        while (!sequence.equals("Clone them!")) {
            int[] dnaElements = Arrays.stream(sequence.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int currentSum = 0;
            int currentSequenceLength = 0;
            int maxCurrentLength = 0;
            int startIndex = 0;
            sampleCount++;

            for (int i = 0; i < dnaElements.length; i++) {
                currentSum += dnaElements[i];
                if (dnaElements[i] == 1) {
                    currentSequenceLength++;
                    if (maxCurrentLength < currentSequenceLength) {
                        maxCurrentLength = currentSequenceLength;
                        startIndex = i + 1 - currentSequenceLength;
                    }
                } else {
                    currentSequenceLength = 0;
                }
            }

            if (maxCurrentLength > maxLength
                    || (maxCurrentLength == maxLength
                        && (startIndex < leftMostIndex
                            || (startIndex == leftMostIndex
                                && currentSum > bestSequenceSum)))) {
                longestSequence = dnaElements;
                bestSequenceIndex = sampleCount;
                leftMostIndex = startIndex;
                bestSequenceSum = currentSum;
                maxLength = maxCurrentLength;
            }

            sequence = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSequenceIndex, bestSequenceSum);
        for (int value : longestSequence) {
            System.out.print(value + " ");
        }
    }
}
