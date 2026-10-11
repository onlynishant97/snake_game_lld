package com.java.strategy;

import com.java.Board;
import com.java.Direction;
import com.java.Position;

public interface BoundaryStrategy {
    Position getNextPosition(Board board, Position currPosition, Direction nextDirection);
}
