package exercises;

import java.util.*;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine().toLowerCase();

        while (!command.equals("end")) {
            String[] params = command.split("\\s+");

            switch (params[0]) {
                case "exchange":
                    exchangeArrElements(array, Integer.parseInt(params[1]));
                    break;
                case "max":
                    int maxIndex = findMaxNumberIndex(array, params[1]);
                    if (maxIndex == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(maxIndex);
                    }

                    break;
                case "min":
                    int minIndex = findMinNumberIndex(array, params[1]);
                    if (minIndex == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(minIndex);
                    }

                    break;
                case "first":
                    int firstCount = Integer.parseInt(params[1]);
                    if (firstCount > array.length) {
                        System.out.println("Invalid count");
                    } else {
                        Integer[] firstOccurrences = findFirstNumsOfElements(array, firstCount, params[2]);
                        System.out.println(Arrays.toString(firstOccurrences));
                    }

                    break;
                case "last":
                    int lastCount = Integer.parseInt(params[1]);
                    if (lastCount > array.length) {
                        System.out.println("Invalid count");
                    } else {
                        Integer[] lastOccurrences = findLastNumsOfElements(array, lastCount, params[2]);
                        System.out.println(Arrays.toString(lastOccurrences));
                    }
            }

            command = scanner.nextLine().toLowerCase();
        }

        System.out.println(Arrays.toString(array));
    }

    private static void exchangeArrElements(int[] array, int index) {
        if (index > array.length - 1 || index < 0) {
            System.out.println("Invalid index");
        } else {
            int[] firstHalf = Arrays.copyOf(array, index + 1);
            int[] secondHalf = Arrays.copyOfRange(array, index + 1, array.length);

            for (int i = 0; i < secondHalf.length; i++) {
                array[i] = secondHalf[i];
            }

            for (int i = secondHalf.length; i < array.length; i++) {
                array[i] = firstHalf[i - secondHalf.length];
            }
        }
    }

    private static int findMaxNumberIndex(int[] array, String typeOfNum) {
        int index = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (typeOfNum.equals("even")) {
                if (array[i] % 2 == 0 && array[i] >= max) {
                    index = i;
                    max = array[i];
                }
            } else if (typeOfNum.equals("odd")) {
                if (array[i] % 2 != 0 && array[i] >= max) {
                    index = i;
                    max = array[i];
                }
            }
        }

        return index;
    }

    private static int findMinNumberIndex(int[] array, String typeOfNum) {
        int index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (typeOfNum.equals("even")) {
                if (array[i] % 2 == 0 && array[i] <= min) {
                    index = i;
                    min = array[i];
                }
            } else if (typeOfNum.equals("odd")) {
                if (array[i] % 2 != 0 && array[i] <= min) {
                    index = i;
                    min = array[i];
                }
            }
        }

        return index;
    }

    private static Integer[] findFirstNumsOfElements(int[] array, int count, String typeOfNum) {
        List<Integer> firstElements = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < array.length; j++) {
                if (foundNumber(array, typeOfNum, firstElements, indexes, j)) break;
            }
        }

        Integer[] returnArray = new Integer[firstElements.size()];
        return firstElements.toArray(returnArray);
    }

    private static Integer[] findLastNumsOfElements(int[] array, int count, String typeOfNum) {
        List<Integer> lastElements = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            for (int j = array.length - 1; j >= 0; j--) {
                if (foundNumber(array, typeOfNum, lastElements, indexes, j)) break;
            }
        }

        Collections.reverse(lastElements);

        Integer[] returnArray = new Integer[lastElements.size()];
        return lastElements.toArray(returnArray);
    }

    private static boolean foundNumber(int[] array, String typeOfNum, List<Integer> lastElements, List<Integer> indexes, int j) {
        if (typeOfNum.equals("even")) {
            if (array[j] % 2 == 0  && !indexes.contains(j)) {
                lastElements.add(array[j]);
                indexes.add(j);
                return true;
            }
        } else if (typeOfNum.equals("odd")) {
            if (array[j] % 2 != 0  && !indexes.contains(j)) {
                lastElements.add(array[j]);
                indexes.add(j);
                return true;
            }
        }

        return false;
    }
}
