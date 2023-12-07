package Service;
import Model.Board;
import Model.Player;

import java.util.Random;

public class GameService {
    private final Board board;
    private final Player[] players;
    private final Random random;

    public GameService(Board board, Player[] players) {
        this.board = board;
        this.players = players;
        this.random = new Random();
    }

    public void playGame() {
        boolean gameOver = false;
        while (!gameOver) {
            for (Player player : players) {
                int diceRoll = random.nextInt(6) + 1;
                int currentPosition = player.getPosition();
                int newPosition = board.getNextPosition(currentPosition, diceRoll);
                player.setPosition(newPosition);

                System.out.println(player.getName() + " rolled a " + diceRoll +
                        " and moved from " + currentPosition + " to " + newPosition);

                if (newPosition == board.getSize()) {
                    System.out.println(player.getName() + " wins the game!");
                    gameOver = true;
                    break;
                }
            }
        }
    }
}

