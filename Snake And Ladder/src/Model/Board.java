package Model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int size;
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board(int size) {
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
    }

    public void addSnake(int head, int tail) {
        snakes.put(head, tail);
    }

    public void addLadder(int start, int end) {
        ladders.put(start, end);
    }

    public int getSize() {
        return size;
    }

    public int getNextPosition(int currentPosition, int diceRoll) {
        int newPosition = currentPosition + diceRoll;
        if (newPosition <= size) {
            if (snakes.containsKey(newPosition)) {
                return snakes.get(newPosition);
            } else if (ladders.containsKey(newPosition)) {
                return ladders.get(newPosition);
            }
        }
        return newPosition;
    }
}
