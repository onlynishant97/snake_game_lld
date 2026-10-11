package com.java.strategy;

import com.java.Board;
import com.java.Direction;
import com.java.Position;

public class WrapAroundStrategyImpl implements BoundaryStrategy {
    @Override
    public Position getNextPosition(Board board, Position currPosition, Direction nextDirection) {
        int rows = board.getRows();
        int col = board.getCols();

        int nextRow = currPosition.getX();
        int nextCol = currPosition.getY();

        switch (nextDirection) {
            case UP -> nextRow--;
            case DOWN -> nextRow++;
            case LEFT -> nextCol--;
            case RIGHT -> nextCol++;
        }

        nextRow = (nextRow + rows) % rows;
        nextCol = (nextCol + col) % col;

        return new Position(nextRow, nextCol);
    }
}
