/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exambetterer;

import java.awt.Graphics;

/**
 *
 * @author angel
 */
public class Player extends Item{

    private int direction;
    private Game game;
    private int iPixel;
    
    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y, width, height);
        this.direction = direction;
        this.game = game;
        iPixel = 5;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void tick() {
        // moving player depending on flags
        if (game.getKeyManager().up) {
           setY(getY() - iPixel);
        }
        if (game.getKeyManager().down) {
           setY(getY() + iPixel);
        }
        if (game.getKeyManager().left) {
           setX(getX() - iPixel);
        }
        if (game.getKeyManager().right) {
           setX(getX() + iPixel);
        }
        // reset x position and y position if colision
        if (getX() + 60 >= game.getWidth()) {
            setX(game.getWidth() - 60);
        }
        else if (getX() <= -30) {
            setX(-30);
        }
        if (getY() + 80 >= game.getHeight()) {
            setY(game.getHeight() - 80);
        }
        else if (getY() <= -20) {
            setY(-20);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
    }
}