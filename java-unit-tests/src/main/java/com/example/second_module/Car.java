package com.example.second_module;

public class Car {
    int x;
    int y;

    public Car(int startPosX, int startPosY) {
        x = startPosX;
        y = startPosY;
    }

    public int[] getPosition() {
        int[] result = new int[2];
        result[0] = x;
        result[1] = y;
        return result;
    }

    public void move(int velocity_x, int velocity_y) {
        x += velocity_x;
        y += velocity_y;
    }
}
