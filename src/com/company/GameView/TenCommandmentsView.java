package com.company.GameView;

import com.company.Sprite.TenCommandmentsViewSprite.TenCommandments;

import javax.swing.*;
import java.util.ArrayList;

public class TenCommandmentsView extends GameView {
    public ArrayList<TenCommandments> getStone() {
        return stone;
    }

    private ArrayList<TenCommandments> stone = new ArrayList<>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count += count;
    }

    private int count;

    public TenCommandmentsView() {
        img = new ImageIcon("mountain.jpg");
        elements = new ArrayList<>();
        count = 0;

        stone.add(new TenCommandments(5, 5));
        stone.add(new TenCommandments(1, 5));
        stone.add(new TenCommandments(3, 4));
        stone.add(new TenCommandments(2, 5));
        stone.add(new TenCommandments(3, 5));
        stone.add(new TenCommandments(4, 5));
        stone.add(new TenCommandments(5, 7));
        stone.add(new TenCommandments(8, 9));
        stone.add(new TenCommandments(1, 10));
        stone.add(new TenCommandments(2, 10));

        elements.addAll(stone);
    }
}
