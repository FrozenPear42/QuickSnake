package com.bugfullabs.snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Board extends Canvas {
    private int mWidth;
    private int mHeight;
    private static final int GRID_SIZE = 16;

    public Board(int width, int height) {
        super(width * GRID_SIZE, height * GRID_SIZE);
        mWidth = width;
        mHeight = height;
    }

    public void drawSnake(Snake snake) {
        GraphicsContext ctx = getGraphicsContext2D();
        ctx.clearRect(0, 0,mWidth * GRID_SIZE, mHeight * GRID_SIZE);
        snake.getSegments().forEach(segment -> {
            ctx.setFill(Color.RED);
            ctx.fillRect(GRID_SIZE * segment.x, GRID_SIZE * segment.y, GRID_SIZE, GRID_SIZE);
        });
    }

    public void drawApple(int x, int y) {
        GraphicsContext ctx = getGraphicsContext2D();
            ctx.setFill(Color.GREEN);
            ctx.fillRect(GRID_SIZE * x, GRID_SIZE * y, GRID_SIZE, GRID_SIZE);
    }
}
