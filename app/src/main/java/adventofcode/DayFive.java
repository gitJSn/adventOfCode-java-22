package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DayFive {
    private static List<Stack<Character>> stacks = new ArrayList<>();

    public static void main(String[] args) {
        File file = new File("app/src/main/resources/day5.txt");

        // Set start values
        setup();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                int crates = Integer.parseInt(line.split(" ")[1]);
                int from = Integer.parseInt(line.split(" ")[3]);
                int to = Integer.parseInt(line.split(" ")[5]);

                for (int i = 0; i < crates; i++) {
                    stacks.get(to - 1).push(stacks.get(from - 1).pop());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        stacks.forEach(System.out::println);
        System.out.println("-------------------------------------------------------");
        // Print top crate for every stack
        stacks.forEach(stack -> System.out.print(stack.peek()));
    }

    public static void setup() {
        stacks.add(new Stack<>());
        stacks.add(new Stack<>());
        stacks.add(new Stack<>());
        stacks.add(new Stack<>());
        stacks.add(new Stack<>());
        stacks.add(new Stack<>());
        stacks.add(new Stack<>());
        stacks.add(new Stack<>());
        stacks.add(new Stack<>());

        // Stack 1 Setup
        stacks.get(0).add('Z');
        stacks.get(0).add('J');
        stacks.get(0).add('N');
        stacks.get(0).add('W');
        stacks.get(0).add('P');
        stacks.get(0).add('S');

        // Stack 2 Setup
        stacks.get(1).add('G');
        stacks.get(1).add('S');
        stacks.get(1).add('T');

        // Stack 3 Setup
        stacks.get(2).add('V');
        stacks.get(2).add('Q');
        stacks.get(2).add('R');
        stacks.get(2).add('L');
        stacks.get(2).add('H');

        // 4
        stacks.get(3).add('V');
        stacks.get(3).add('S');
        stacks.get(3).add('T');
        stacks.get(3).add('D');

        // 5
        stacks.get(4).add('Q');
        stacks.get(4).add('Z');
        stacks.get(4).add('T');
        stacks.get(4).add('D');
        stacks.get(4).add('B');
        stacks.get(4).add('M');
        stacks.get(4).add('J');

        // 6
        stacks.get(5).add('M');
        stacks.get(5).add('W');
        stacks.get(5).add('T');
        stacks.get(5).add('J');
        stacks.get(5).add('D');
        stacks.get(5).add('C');
        stacks.get(5).add('Z');
        stacks.get(5).add('L');

        // 7
        stacks.get(6).add('L');
        stacks.get(6).add('P');
        stacks.get(6).add('M');
        stacks.get(6).add('W');
        stacks.get(6).add('G');
        stacks.get(6).add('T');
        stacks.get(6).add('J');

        // 8
        stacks.get(7).add('N');
        stacks.get(7).add('G');
        stacks.get(7).add('M');
        stacks.get(7).add('T');
        stacks.get(7).add('B');
        stacks.get(7).add('F');
        stacks.get(7).add('Q');
        stacks.get(7).add('H');

        // 9
        stacks.get(8).add('R');
        stacks.get(8).add('D');
        stacks.get(8).add('G');
        stacks.get(8).add('C');
        stacks.get(8).add('P');
        stacks.get(8).add('B');
        stacks.get(8).add('Q');
        stacks.get(8).add('W');
    }
}
