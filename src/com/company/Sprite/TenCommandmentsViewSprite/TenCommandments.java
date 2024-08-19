package com.company.Sprite.TenCommandmentsViewSprite;

import com.company.Sprite.Sprite;

import javax.swing.*;

public class TenCommandments extends Sprite {
    public TenCommandments(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("stone.png");
    }

    @Override
    public String overlap(int x, int y) {
        return "";
    }
}
