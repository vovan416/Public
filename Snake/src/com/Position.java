/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author durkin_vl
 */
public class Position {
    public int x = 1, y = 1;
    Position() {}
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Position))
            return false;
        Position pos = (Position)obj;
        return x == pos.x && y == pos.y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.x;
        hash = 19 * hash + this.y;
        return hash;
    }

    @Override
    public String toString() {
        return String.valueOf(x) + " " + String.valueOf(y);
    }
}