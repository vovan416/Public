/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.ArrayList;

/**
 *
 * @author durkin_vl
 */
public class Snake extends Body{
    private final ArrayList<Position> POSITIONS = new ArrayList<>();
    private SnakeDirection direction = SnakeDirection.DOWN;
    
    
    Snake(SnakeDirection direction) {
        this.direction = direction;
        initialize();
    }
    
    private void initialize() {
        for(int cell = 0; cell < 3; cell++) {
            switch (direction) {
            case RIGHT:
                addCellBody(SizeWindow.NUMBER_CELLS_HORIZONTAL/2+cell, SizeWindow.NUMBER_CELLS_VERTICAL/2);
                break;
            case DOWN:
                addCellBody(SizeWindow.NUMBER_CELLS_HORIZONTAL/2, SizeWindow.NUMBER_CELLS_VERTICAL/2+cell);
                break;
            case UP:
                addCellBody(SizeWindow.NUMBER_CELLS_HORIZONTAL/2, SizeWindow.NUMBER_CELLS_VERTICAL/2-cell);
                break;
            case LEFT:
                addCellBody(SizeWindow.NUMBER_CELLS_HORIZONTAL/2-cell, SizeWindow.NUMBER_CELLS_VERTICAL/2);
                break;
            default:
                break;
            }
        }
    }
        
    @Override
    protected ArrayList<Position> getPositions() {
        return POSITIONS;
    }
    
    protected SnakeDirection getDirection() {
        return direction;
    }
    
    protected Position getHead() {
        int lastIndexOfPositions = POSITIONS.size() - 1;
        return POSITIONS.get(lastIndexOfPositions);
    }

    protected Position getEnd() {
        return POSITIONS.get(0);
    }
    
    protected  void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
    
    protected void addCellBody(int x, int y) {
        POSITIONS.add(new Position(x, y));
    }
    
    protected void removeEnd() {
        if(POSITIONS.size() > 0)
            POSITIONS.remove(0);
    }
}
