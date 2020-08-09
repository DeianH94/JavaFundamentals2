package moreExercises;

import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] morseInput = scanner.nextLine().split("\\s+");
        StringBuilder newMorseInput = new StringBuilder();

        for (String aMorseInput : morseInput) {
            if (!aMorseInput.equals("|")) {
                switch (aMorseInput) {
                    case ".-":
                        newMorseInput.append("A");
                        break;
                    case "-...":
                        newMorseInput.append("B");
                        break;
                    case "-.-.":
                        newMorseInput.append("C");
                        break;
                    case "-..":
                        newMorseInput.append("D");
                        break;
                    case ".":
                        newMorseInput.append("E");
                        break;
                    case "..-.":
                        newMorseInput.append("F");
                        break;
                    case "--.":
                        newMorseInput.append("G");
                        break;
                    case "....":
                        newMorseInput.append("H");
                        break;
                    case "..":
                        newMorseInput.append("I");
                        break;
                    case ".---":
                        newMorseInput.append("J");
                        break;
                    case "-.-":
                        newMorseInput.append("K");
                        break;
                    case ".-..":
                        newMorseInput.append("L");
                        break;
                    case "--":
                        newMorseInput.append("M");
                        break;
                    case "-.":
                        newMorseInput.append("N");
                        break;
                    case "---":
                        newMorseInput.append("O");
                        break;
                    case ".--.":
                        newMorseInput.append("P");
                        break;
                    case "--.-":
                        newMorseInput.append("Q");
                        break;
                    case ".-.":
                        newMorseInput.append("R");
                        break;
                    case "...":
                        newMorseInput.append("S");
                        break;
                    case "-":
                        newMorseInput.append("T");
                        break;
                    case "..-":
                        newMorseInput.append("U");
                        break;
                    case "...-":
                        newMorseInput.append("V");
                        break;
                    case ".--":
                        newMorseInput.append("W");
                        break;
                    case "-..-":
                        newMorseInput.append("X");
                        break;
                    case "-.--":
                        newMorseInput.append("Y");
                        break;
                    case "--..":
                        newMorseInput.append("Z");
                        break;
                }
            } else {
                newMorseInput.append(" ");
            }
        }

        System.out.println(newMorseInput);
    }
}
