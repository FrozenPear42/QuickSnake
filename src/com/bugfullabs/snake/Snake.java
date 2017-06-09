package com.bugfullabs.snake;

import java.util.ArrayList;

public class Snake {
    private ArrayList<SnakeSegment> mSegments;
    private int mX;
    private int mY;

    public Snake(int x, int y, int initSegments) {
        mX = x;
        mY = y;
        for (int i = 0; i < initSegments; ++i)
            mSegments.add(new SnakeSegment(x, y + i));
    }

    public void step(Direction direction) {
        switch (direction) {
            case RIGHT:
                mX += 1;
                break;
            case LEFT:
                mX -= 1;
                break;
            case UP:
                mY -= 1;
                break;
            case DOWN:
                mY += 1;
                break;
        }
        mSegments.get(mSegments.size() - 1).x = mX;
        mSegments.get(mSegments.size() - 1).y = mY;
    }

    class SnakeSegment {
        public int x;
        public int y;
        public boolean isHead;

        SnakeSegment(int x, int y, boolean isHead) {
            this.x = x;
            this.y = y;
            this.isHead = isHead;
        }

        SnakeSegment(int x, int y) {
            this(x, y, false);
        }
    }

    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

}
