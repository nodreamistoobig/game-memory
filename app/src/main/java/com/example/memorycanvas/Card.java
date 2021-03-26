package com.example.memorycanvas;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

class Card {
    private Paint p = new Paint();
    int color, backColor = Color.DKGRAY;
    boolean isOpen = false;
    private float x, y, width, height;

    public Card(float x, float y, float width, float height, int color) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean flip(float touchX, float touchY) {
        if (touchX >= x && touchX <= x + width && touchY >= y && touchY <= y + height) {
            isOpen = !isOpen;
            return true;
        } else return false;
    }

    public void draw(Canvas c) {
        //рисуем карту в виде цветного прямоугольника
        if (isOpen)
            p.setColor(color);
        else p.setColor(backColor);
        c.drawRect(x, y, x + width, y + height, p);
    }
}