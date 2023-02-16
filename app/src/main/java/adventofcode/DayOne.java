package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class DayOne {
    private static List<Integer> elfs = new ArrayList<>();

    public static void main(String[] args) {
        File file = new File("app/src/main/resources/day1.txt");

        try {
            Scanner scanner = new Scanner(file);
            int tempCal = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.isEmpty()) {
                    elfs.add(tempCal);
                    tempCal = 0;
                    continue;
                }

                tempCal += Integer.parseInt(line);
            }
            scanner.close();

            Stream<Integer> top3 = elfs.stream().sorted((a, b) -> b - a).limit(3);
            int top3Sum = top3.mapToInt(Integer::intValue).sum();

            System.out.println("Top 3 combined: " + top3Sum);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
