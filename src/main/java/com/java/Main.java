
package com.java;

import com.java.strategy.BoundaryStrategy;
import com.java.strategy.WrapAroundStrategyImpl;

public class Main {

    public static void main(String[] args) {
        Snake snake = new Snake(
                new Position(2, 2),
                Direction.RIGHT
        );

        BoundaryStrategy boundaryStrategy =
                new WrapAroundStrategyImpl();

        Game game = new Game(
                5, 5, snake, boundaryStrategy
        );

        game.startGame();

        System.out.println("Initial state: " + game.state);
        System.out.println("Initial head: " + snake.getHead());

        Direction[] moves = {
                Direction.RIGHT,
                Direction.RIGHT,
                Direction.DOWN,
                Direction.LEFT,
                Direction.UP
        };

        for (Direction direction : moves) {
            GameState result = game.move(direction);

            System.out.println(
                    "Move: " + direction
                            + " | Head: " + snake.getHead()
                            + " | Score: " + game.score
                            + " | State: " + result
            );

            if (result != GameState.RUNNING) {
                break;
            }
        }
    }
}
