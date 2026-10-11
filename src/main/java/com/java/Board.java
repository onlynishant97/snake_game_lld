package com.java;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {
    int rows;
    int cols;

    public int getTotalCells() {
        return rows * cols;
    }
}
