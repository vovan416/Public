/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author durkin_vl
 */
public class KeyboardListener implements KeyListener {
    private Snake snake;
    
    public KeyboardListener(Snake snake) {
        this.snake = snake;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //TODO
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int numberButton = e.getKeyCode();
        SnakeDirection direction = snake.getDirection();

        switch(numberButton) {
            case 37: {
                if(direction != SnakeDirection.RIGHT)
                    snake.setDirection(SnakeDirection.LEFT);
                break;
            }
            case 38: {
                if(direction != SnakeDirection.DOWN)
                    snake.setDirection(SnakeDirection.UP);
                break;
            }
            case 39: {
                if(direction != SnakeDirection.LEFT)
                    snake.setDirection(SnakeDirection.RIGHT);
                break;
            }
            case 40: {
                if(direction != SnakeDirection.UP)
                snake.setDirection(SnakeDirection.DOWN);
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //TODO
    }

}