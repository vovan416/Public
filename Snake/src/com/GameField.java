/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author durkin_vl
 */
public class GameField extends JPanel{
    private final JFrame mainWindow;

    private final Snake snake;
    private final Food food;
    
    public GameField(Snake snake, Food food) {
        this.snake = snake;
        this.food = food;
        
        mainWindow = new JFrame("Snake");
        
        initializeGameField();
        initializeMainWindow();
    }
    
    private void initializeGameField() {
        setPreferredSize(new Dimension(SizeWindow.WIDTH, SizeWindow.HEIGHT));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        setFocusable(true);
        addKeyListener(new KeyboardListener(snake));  
    }

    private void initializeMainWindow() {
        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.getContentPane().add(this);
        mainWindow.pack();
        mainWindow.setVisible(true);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        mainWindow.setLocation(dimension.width/2 - mainWindow.getSize().width/2, dimension.height/2 - mainWindow.getSize().height/2);
    }
    
    public void update() {
        mainWindow.repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        int wallOfStomach = 0;
        int x, y;
        
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        for(Position snakePosition : snake.getPositions()) {
            x = castXtoGui(snakePosition);
            y = castYtoGui(snakePosition);

            g.setColor(Color.GREEN);
            g.fillRect((snakePosition.x-x) * SizeWindow.PIXEL, (snakePosition.y-y) * SizeWindow.PIXEL, SizeWindow.PIXEL, SizeWindow.PIXEL);
            g.setColor(Color.BLACK);
            g.drawRect((snakePosition.x-x) * SizeWindow.PIXEL, (snakePosition.y-y) * SizeWindow.PIXEL, SizeWindow.PIXEL, SizeWindow.PIXEL);
        }
        
        for(Position foodPosition : food.getPositions()) {
            x = castXtoGui(foodPosition);
            y = castYtoGui(foodPosition);

            for(Position snakePosition : snake.getPositions()) {
                if(foodPosition.equals(snakePosition)) {
                    wallOfStomach = 2;
                    g.setColor(Color.GREEN);
                    break;
                } else {
                    wallOfStomach = 0;
                    g.setColor(Color.BLUE);
                }
            }

            g.fillRect((foodPosition.x-x) * SizeWindow.PIXEL - wallOfStomach, (foodPosition.y-y) * SizeWindow.PIXEL - wallOfStomach, 
                       SizeWindow.PIXEL + (wallOfStomach + wallOfStomach), SizeWindow.PIXEL + (wallOfStomach + wallOfStomach));
            g.setColor(Color.BLACK);
            g.drawRect((foodPosition.x-x) * SizeWindow.PIXEL - wallOfStomach, (foodPosition.y-y) * SizeWindow.PIXEL - wallOfStomach, 
                       SizeWindow.PIXEL + (wallOfStomach + wallOfStomach), SizeWindow.PIXEL + (wallOfStomach + wallOfStomach));
        }
    }

    int castXtoGui(Position position) {
        if(position.x != 0)
            return 1;
        return 0;
    }

    int castYtoGui(Position position) {
        if(position.y != 0)
            return 1;
        return 0;
    }
}
