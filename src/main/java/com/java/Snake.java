package com.java;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;

@Data
public class Snake {
    Deque<Position> body = new ArrayDeque<>();
    Direction direction;

    public Snake(Position startPosition, Direction startDirection) {
        body.addFirst(startPosition);
        this.direction = startDirection;
    }

    Position getHead() {
        return body.getFirst();
    }

    Position getTail() {
        return body.getLast();
    }

    void changeDirection(Direction newDirection) {
        if (isOpposite(direction, newDirection)) {
            return;
        }

        direction = newDirection;
    }

    private boolean isOpposite(Direction current, Direction next) {
        return (current == Direction.UP && next == Direction.DOWN) || (current == Direction.DOWN && next == Direction.UP) || (current == Direction.LEFT && next == Direction.RIGHT) || (current == Direction.RIGHT && next == Direction.LEFT);
    }


    void move(Position nextPosition) {
        body.removeLast();
        body.addFirst(nextPosition);
    }

    void grow(Position nextPosition) {
        body.addFirst(nextPosition);
    }

    public boolean occupies(Position position) {
        return body.contains(position);
    }

    public int getLength() {
        return body.size();
    }

}
