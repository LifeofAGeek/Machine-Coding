import Model.Board;
import Model.Player;
import Service.GameService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Player[] players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            String playerName = scanner.nextLine();
            players[i] = new Player(playerName);
        }

        Board board = new Board(100);

        // Add snakes and ladders
        System.out.println("Enter the number of snakes: ");
        int numSnakes = scanner.nextInt();
        for (int i = 0; i < numSnakes; i++) {
            int start = scanner.nextInt(), end = scanner.nextInt();
            board.addSnake(start, end);
        }

        System.out.println("Enter the number of ladders: ");
        int numLadder = scanner.nextInt();
        for (int i = 0; i < numLadder; i++) {
            int start = scanner.nextInt(), end = scanner.nextInt();
            board.addLadder(start, end);
        }

        // Game service layer (orchestrates the game)
        GameService gameService = new GameService(board, players);
        gameService.playGame();
    }
}