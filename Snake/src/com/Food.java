package com;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author durkin_vl
 */
public class Food extends Body {
    private final ArrayList<Position> POSITIONS;
    private final ArrayList<Position> snakeList;
    
    Food(ArrayList<Position> snakeList) {
        POSITIONS = new ArrayList<Position>();
        this.snakeList = snakeList;
        
        generatePosition();
    }
    
    protected void generatePosition() {
        Position newPositionFood = new Position();
        for(boolean repeated = true; repeated;) {
            repeated = false;
            do{
                newPositionFood.x = (int)(Math.random()*SizeWindow.NUMBER_CELLS_VERTICAL);
            }
            while(newPositionFood.x == 0);
            do{
                newPositionFood.y = (int)(Math.random()*SizeWindow.NUMBER_CELLS_HORIZONTAL);
            }
            while(newPositionFood.y == 0);
            for(Position snakePosition : snakeList) {
                if(newPositionFood.equals(snakePosition)) {
                    repeated = true;
                    break;
                }
            }
        }
        POSITIONS.add(newPositionFood);
        System.out.printf("X = %d Y = %d\n", newPositionFood.x, newPositionFood.y);
    }

    @Override
    protected ArrayList<Position> getPositions() {
        return POSITIONS;
    }
    
    protected Position getCurrentPosition() {
        int lastIndexOfPositions = POSITIONS.size() - 1;
        return POSITIONS.get(lastIndexOfPositions);
    }
    
    protected Position getLastPosition() {
        return POSITIONS.get(0);
    }
    
    protected void removeLastPosition() {
        if(POSITIONS.size() > 1)
            POSITIONS.remove(0);
    }
}