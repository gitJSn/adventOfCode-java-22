package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwo {
    public static void main(String[] args) {
        File file = new File("app/src/main/resources/day2.txt");

        try {
            Scanner scanner = new Scanner(file);
            int score = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char enemy = line.charAt(0);
                char me = line.charAt(2);
                int result = determineWinner(enemy, me);

                switch (me) {
                    case 'X':
                        score += 1;
                        break;
                    case 'Y':
                        score += 2;
                        break;
                    case 'Z':
                        score += 3;
                        break;
                    default:
                        break;
                }

                score += result == 0 ? 3 : result == 1 ? 6 : 0;
            }
            scanner.close();

            System.out.println(score);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int determineWinner(char a, char b) {
        // A, X Rock
        // B, Y Paper
        // C, Z Scissors

        if (a == 'A' && b == 'X') {
            return 0;
        }

        if (a == 'B' && b == 'Y') {
            return 0;
        }

        if (a == 'C' && b == 'Z') {
            return 0;
        }

        if (a == 'A' && b == 'Y') {
            return 1;
        }

        if (a == 'A' && b == 'Z') {
            return -1;
        }

        if (a == 'B' && b == 'X') {
            return -1;
        }

        if (a == 'B' && b == 'Z') {
            return 1;
        }

        if (a == 'C' && b == 'X') {
            return 1;
        }

        /*
         * if (a == 'C' && b == 'Y') {
         * return -1;
         * }
         */

        return -1;
    }
}
