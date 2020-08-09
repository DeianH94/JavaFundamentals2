package moreExercises;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfRows = Integer.parseInt(scanner.nextLine());
        int[][] triangle = new int[numOfRows][numOfRows];

        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i)
                    triangle[i][j] = 1;
                else
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }

        for(int i = 0;i < numOfRows; i++)
        {
            for(int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }

            System.out.println();
        }
    }
}
