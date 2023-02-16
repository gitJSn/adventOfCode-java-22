package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayEight {
    private static List<List<Integer>> grid = new ArrayList<>();

    public static void main(String[] args) {
        setup();

        List<Integer> result = new ArrayList<>();

        List<List<Integer>> test = new ArrayList<>();

        for (int i = 0; i < grid.size(); i++) {
            test.add(new ArrayList<>());
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (isVisible(i, j)) {
                    result.add(grid.get(i).get(j));
                    test.get(i).add(1);
                    continue;
                }
                test.get(i).add(0);
            }
        }

        System.out.println(result.size());

        /*
         * System.out.println("---------------------");
         * System.out.println("Test:");
         * 
         * for (int i = 0; i < test.size(); i++) {
         * for (int j = 0; j < test.get(i).size(); j++) {
         * System.out.print(test.get(i).get(j));
         * }
         * System.out.println();
         * }
         */
    }

    public static boolean isVisible(int vertical, int horizontal) {
        if (vertical == 0)
            return true;
        if (vertical == grid.size() - 1)
            return true;
        if (horizontal == 0)
            return true;
        if (horizontal == grid.get(vertical).size() - 1)
            return true;

        if (topCheck(vertical, horizontal)) {
            return true;
        }

        if (botCheck(vertical, horizontal)) {
            return true;
        }

        if (leftCheck(vertical, horizontal)) {
            return true;
        }

        if (rightCheck(vertical, horizontal)) {
            return true;
        }

        return false;
    }

    public static boolean topCheck(int vertical, int horizontal) {
        for (int i = vertical - 1; i >= 0; i--) {
            if (grid.get(vertical).get(horizontal) <= grid.get(i).get(horizontal)) {
                return false;
            }
        }
        return true;
    }

    public static boolean botCheck(int vertical, int horizontal) {
        for (int i = vertical + 1; i < grid.size(); i++) {
            if (grid.get(vertical).get(horizontal) <= grid.get(i).get(horizontal)) {
                return false;
            }
        }
        return true;
    }

    public static boolean leftCheck(int vertical, int horizontal) {
        for (int i = horizontal - 1; i >= 0; i--) {
            if (grid.get(vertical).get(horizontal) <= grid.get(vertical).get(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean rightCheck(int vertical, int horizontal) {
        for (int i = horizontal + 1; i < grid.get(vertical).size(); i++) {
            if (grid.get(vertical).get(horizontal) <= grid.get(vertical).get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void setup() {
        File file = new File("app/src/main/resources/day8.txt");

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                List<Integer> row = new ArrayList<>();

                for (int i = 0; i < line.length(); i++) {
                    int treeHeight = line.charAt(i) - '0'; // using ascii conversion
                    row.add(treeHeight);

                    System.out.print(treeHeight);
                }
                System.out.println();

                grid.add(row);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
