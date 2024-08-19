package com.company.Sprite;

import com.company.GameView.DisasterView;
import com.company.GameView.RedSeaGameView;
import com.company.GameView.TenCommandmentsView;
import com.company.Main;
import com.company.Sprite.DisasterViewSprite.Bug;
import com.company.Sprite.DisasterViewSprite.Frog;
import com.company.Sprite.DisasterViewSprite.Ice;
import com.company.Sprite.DisasterViewSprite.Tombstone;
import com.company.Sprite.RedSeaViewSprite.Anubis;
import com.company.Sprite.RedSeaViewSprite.Cat;
import com.company.Sprite.RedSeaViewSprite.Pharaoh;
import com.company.Sprite.TenCommandmentsViewSprite.TenCommandments;

import javax.swing.*;
import java.util.ArrayList;

public class Moses extends Sprite {
    public Moses(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("Moses.png");
    }

    @Override
    public String overlap(int x, int y) {
        if (Main.gameView instanceof DisasterView) {
            // check for bugs and frogs
            ArrayList<Frog> frogs = ((DisasterView) Main.gameView).getFrogs();
            ArrayList<Bug> bugs = ((DisasterView) Main.gameView).getBugs();
            for (Frog f : frogs) {
                // f.getRelativePosition() != null 必須放在最前面，否則會觸發 Short circuit
                if (f.getRelativePosition() != null
                        && f.getRelativePosition().x == x
                        && f.getRelativePosition().y == y
                ) {
                    return "Die";
                }
            }

            for (Bug b : bugs) {
                if (b.getRelativePosition() != null
                        && b.getRelativePosition().x == x
                        && b.getRelativePosition().y == y
                ) {
                    return "Die";
                }
            }

            // check for ice and tombstone
            ArrayList<Ice> ices = ((DisasterView) Main.gameView).getIceCubes();
            ArrayList<Tombstone> stones = ((DisasterView) Main.gameView).getStones();
            for (Ice i : ices) {
                if (i.getRelativePosition() != null
                        && i.getRelativePosition().x == x
                        && i.getRelativePosition().y == y
                ) {
                    return "Cannot move";
                }
            }

            for (Tombstone s : stones) {
                if (s.getRelativePosition() != null
                        && s.getRelativePosition().x == x
                        && s.getRelativePosition().y == y
                ) {
                    return "Cannot move";
                }
            }

            // Check for door
            Door door = Main.gameView.getDoor();
            if (x == door.getRelativePosition().x && y == door.getRelativePosition().y) {
                return "Next level";
            }
        } else if (Main.gameView instanceof RedSeaGameView) {
            ArrayList<Cat> cats = ((RedSeaGameView) Main.gameView).getCats();
            ArrayList<Anubis> anubis = ((RedSeaGameView) Main.gameView).getAnubis();
            ArrayList<Pharaoh> pharaohs = ((RedSeaGameView) Main.gameView).getPharaohs();

            for (Cat c : cats) {
                if (c.getRelativePosition() != null
                        && c.getRelativePosition().x == x
                        && c.getRelativePosition().y == y
                ) {
                    return "Cannot move";
                }
            }

            for (Anubis a : anubis) {
                if (a.getRelativePosition() != null
                        && a.getRelativePosition().x == x
                        && a.getRelativePosition().y == y
                ) {
                    return "Die";
                }
            }

            for (Pharaoh p : pharaohs) {
                if (p.getRelativePosition() != null
                        && p.getRelativePosition().x == x
                        && p.getRelativePosition().y == y
                ) {
                    return "Die";
                }
            }

            // Check for door
            Door door = Main.gameView.getDoor();
            if (x == door.getRelativePosition().x && y == door.getRelativePosition().y) {
                return "Next level";
            }
        } else if (Main.gameView instanceof TenCommandmentsView) {
            ArrayList<TenCommandments> stones = ((TenCommandmentsView) Main.gameView).getStone();
            for (TenCommandments stone : stones) {
                if (stone.getRelativePosition() != null
                        && stone.getRelativePosition().x == x
                        && stone.getRelativePosition().y == y
                ) {
                    stone.setNullPosition();
                    ((TenCommandmentsView) Main.gameView).setCount(1);
                    if (((TenCommandmentsView) Main.gameView).getCount() == 10) {
                        return "Game Over";
                    } else {
                        return "None";
                    }
                }
            }
        }
        return "None";
    }
}
