package Organism;
import Board.Board;

import javax.swing.*;

abstract public class Organism {

    protected ImageIcon img;
    protected int strength;
    protected int initiative;
    protected int x;
    protected int y;

    protected Board board;
    protected boolean move = true;
    public abstract void action(Board board);
    public abstract void collision(Board board, int x, int y);
    public abstract boolean abilityCollision(Organism attacker, String comment);

    public ImageIcon getImg(){
        return this.img;
    }
    public int getStrength(){
        return this.strength;
    }
    public int getInitiative(){
        return this.initiative;
    }
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
    public boolean getMove(){
        return this.move;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setMove(boolean move){
        this.move = move;
    }

    public Organism(ImageIcon img, int strength, int initiative, boolean move, Board board, int x, int y){
        this.img = img;
        this.strength = strength;
        this.initiative = initiative;
        this.move = move;
        this.board = board;
        this.x = x;
        this.y = y;
    }



}
