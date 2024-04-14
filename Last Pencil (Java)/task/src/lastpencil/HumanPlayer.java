package lastpencil;

import java.util.Scanner;


public class HumanPlayer extends Player{
    private static final String VALUES_REGEX = "^[123]$";
    private final Scanner scanner;

    public HumanPlayer(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    @Override
    public int takePencils(int currentPencils) {
        while (true) {
            String input = scanner.nextLine();
            if (input.matches(VALUES_REGEX)) {
                int pencilsLeft = currentPencils - Integer.parseInt(input);
                if (pencilsLeft >= 0) {
                    return pencilsLeft;
                } else {
                    System.out.println("Too many pencils were taken");
                }
            } else {
                System.out.println("Possible values: '1', '2' or '3'");
            }
        }
    }
}