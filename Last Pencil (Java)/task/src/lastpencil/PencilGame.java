package lastpencil;

import java.text.MessageFormat;
import java.util.Scanner;

public class PencilGame {

    private int pencils;
    private final Player playerJohn, playerJack;
    private Player currentPlayer;
    private final Scanner scanner;
    private static final String NUMERIC_REGEX = "^\\d+$";
    private static final String NAMES_REGEX_FORMAT = "^(?:{0}|{1})$";

    public PencilGame() {
        scanner  = new Scanner(System.in);
        playerJohn = new HumanPlayer("John", scanner);
        playerJack = new BotPlayer("Jack");
    }

    public void play(){
        askNumberOfPencils();
        askTurnOrder();
        handlePlayersTurns();
        printWinner();
    }

    private void askNumberOfPencils() {
        System.out.println("How many pencils would you like to use:");
        while (true) {
            String input = scanner.nextLine();
            if (input.matches(NUMERIC_REGEX)) {
                int inputNumber = Integer.parseInt(input);
                if (inputNumber > 0) {
                    pencils = inputNumber;
                    break;
                } else {
                    System.out.println("The number of pencils should be positive");
                }
            } else {
                System.out.println("The number of pencils should be numeric");
            }
        }
    }

    private void askTurnOrder() {
        System.out.println(MessageFormat.format("Who will be the first ({0}, {1}):", playerJohn.getName(), playerJack.getName()));
        String namesRegex = MessageFormat.format(NAMES_REGEX_FORMAT, playerJohn.getName(), playerJack.getName());
        while (true) {
            String input = scanner.nextLine();
            if (input.matches(namesRegex)) {
                currentPlayer = playerJohn.getName().equals(input) ? playerJohn : playerJack;
                break;
            } else {
                System.out.println(MessageFormat.format("Choose between ''{0}'' and ''{1}''", playerJohn.getName(), playerJack.getName()));
            }
        }
    }

    private void handlePlayersTurns() {
        while (pencils > 0) {
            System.out.println("|".repeat(pencils));
            System.out.println(MessageFormat.format("{0}''s turn!",currentPlayer.getName()));
            pencils = currentPlayer.takePencils(pencils);
            currentPlayer = currentPlayer.equals(playerJohn) ? playerJack : playerJohn;
        }
    }

    private void printWinner() {
        System.out.println(MessageFormat.format("{0} won!", currentPlayer.getName()));
    }
}