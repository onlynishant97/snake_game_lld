package com.java.generator;

import com.java.Board;
import com.java.Food;
import com.java.Position;
import com.java.Snake;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class FoodGenerator {
    Board board;
    Random random;

    public Food generateFood(Snake snake) {
        while (true) {
            int row = random.nextInt(board.getRows());
            int col = random.nextInt(board.getCols());

            Position position = new Position(row, col);
            if (!snake.occupies(position)) {
                return new Food(position);
            }
        }
    }
}
