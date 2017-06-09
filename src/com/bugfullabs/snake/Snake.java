package com.bugfullabs.snake;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private LinkedList<SnakeSegment> mSegments;
    private int mX;
    private int mY;

    public Snake(int x, int y, int initSegments) {
        mSegments = new LinkedList<>();
        mX = x;
        mY = y;
        for (int i = 0; i < initSegments; ++i)
            mSegments.add(new SnakeSegment(x, y + i));
    }

    public boolean step(Direction direction, boolean elongate) {
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
        if(!elongate)
            mSegments.addFirst(mSegments.removeLast());
        else
            mSegments.addFirst(new SnakeSegment(mX, mY));
        mSegments.getFirst().x = mX;
        mSegments.getFirst().y = mY;

        return mSegments.subList(1, mSegments.size()).stream().filter(s -> s.x == mX && s.y == mY).findAny().isPresent();

    }

    public boolean isCollision(int x, int y) {
        return mSegments.stream().filter(s -> s.x == x && s.y == y).findAny().isPresent();
    }

    public List<SnakeSegment> getSegments() {
        return mSegments;
    }

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
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
