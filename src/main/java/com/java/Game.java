package com.java;

import com.java.generator.FoodGenerator;
import com.java.strategy.BoundaryStrategy;

import java.util.Random;

public class Game {
    Board board;
    Snake snake;
    Food food;
    int score;

    FoodGenerator foodGenerator;
    BoundaryStrategy boundaryStrategy;

    GameState state = GameState.NOT_STARTED;

    Game(int rows, int cols, Snake snake, BoundaryStrategy boundaryStrategy) {
        this.board = new Board(rows, cols);
        this.snake = snake;
        this.boundaryStrategy = boundaryStrategy;
        foodGenerator = new FoodGenerator(board, new Random());
        food = foodGenerator.generateFood(this.snake);
        score = 0;
    }

    void startGame() {
        if (state == GameState.NOT_STARTED)
            state = GameState.RUNNING;
    }

    GameState move(Direction moveDirection) {
        if (state != GameState.RUNNING) return state;

        snake.changeDirection(moveDirection);

        Position nextPosition = boundaryStrategy.getNextPosition(board, snake.getHead(), snake.getDirection());
        if (nextPosition.getX() == -1 || nextPosition.getY() == -1) {
            state = GameState.GAME_OVER;
            return state;
        }

        boolean isFood = food.position.equals(nextPosition);

        boolean isCollision = snake.occupies(nextPosition);

        boolean isTail = nextPosition.equals(snake.getTail());

        if (isCollision && !isTail) {
            state = GameState.GAME_OVER;
            return state;
        }

        if (isFood) {
            snake.grow(nextPosition);
            if (snake.getLength() == board.getTotalCells()) {
                state = GameState.WON;
                return state;
            }
            this.food = foodGenerator.generateFood(this.snake);
            score++;
        } else {
            snake.move(nextPosition);
        }

        return state;
    }


}
