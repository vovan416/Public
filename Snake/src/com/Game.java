/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author durkin_vl
 */
public class Game {
    private Food food;
    private Snake snake;
    private GameField gameField;
    private final static int INTERVAL_UPDATE = 250;
    
    public static void main(String[] args) {
        Game game = new Game(); 
        game.initialize();
        try {
            game.play();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initialize() {
        snake = new Snake(SnakeDirection.UP);
        food = new Food(snake.getPositions());
        gameField = new GameField(snake, food);
    }
    
    private void play() throws InterruptedException {
        while(true) {
            Thread.sleep(INTERVAL_UPDATE);
            
            if(snake.getHead().equals(food.getCurrentPosition())) 
                food.generatePosition();
            
            if(snake.getEnd().equals(food.getLastPosition()))
                food.removeLastPosition();
            else
                snake.removeEnd();
            
            Position p = snake.getHead();
            switch(snake.getDirection()) {
                case UP : {
                    int y = p.y - 1;
                    if(y < 1)
                        y = SizeWindow.NUMBER_CELLS_VERTICAL;
                    snake.addCellBody(p.x, y);
                    break;
                }
                case DOWN : {
                    int y = p.y + 1;
                    if(y > SizeWindow.NUMBER_CELLS_VERTICAL)
                        y = 1;
                    snake.addCellBody(p.x, y);
                    break;
                }
                case LEFT : {
                    int x = p.x - 1;
                    if(x < 1)
                        x = SizeWindow.NUMBER_CELLS_HORIZONTAL;
                    snake.addCellBody(x, p.y);
                    break;
                }
                case RIGHT : {
                    int x = p.x + 1;
                    if(x > SizeWindow.NUMBER_CELLS_HORIZONTAL)
                        x = 1;
                    snake.addCellBody(x,p.y);
                    break;
                }
            }
            
            gameField.update();
        }
    }
}


