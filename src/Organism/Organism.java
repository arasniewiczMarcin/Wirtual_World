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

    protected boolean animal;
    int vectorX;
    int vectorY;

    boolean AbilityOn;
    int timeToActivateAbility;
    int timeToEndAbility;
    public boolean getAnimal(){
        return this.animal;
    }

    public void setAbilityOn(boolean AbilityOn) {
        this.AbilityOn = AbilityOn;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setTimeToActivateAbility(int timeToActivateAbility) {
        this.timeToActivateAbility = timeToActivateAbility;
    }
    public void setTimeToEndAbility(int timeToEndAbility) {
        this.timeToEndAbility = timeToEndAbility;
    }
    public boolean getAbilityOn() {
        return AbilityOn;
    }
    public int getTimeToActivateAbility() {
        return timeToActivateAbility;
    }
    public int getTimeToEndAbility() {
        return timeToEndAbility;
    }

    public void setVectorX(int vectorX) {
        this.vectorX = vectorX;
    }
    public void setVectorY(int vectorY) {
        this.vectorY = vectorY;
    }
    public int getVectorX() {
        return vectorX;
    }
    public int getVectorY() {
        return vectorY;
    }
    public boolean abilityCollision(Organism attacker, String comment){
        return true;
    }

    protected boolean move = true;

    public Board getBoard(){
        return this.board;
    }
    public abstract void action(Board board);
    public abstract void collision(Board board, int x, int y);
    public int[] createVector(int kierunek) {
        int[] wektor = new int[2];
        switch (kierunek) {
            case 0:
                wektor[0] = -1;
                wektor[1] = 0;
                break;
            case 1:
                wektor[0] = 1;
                wektor[1] = 0;
                break;
            case 2:
                wektor[0] = 0;
                wektor[1] = 1;
                break;
            case 3:
                wektor[0] = 0;
                wektor[1] = -1;
                break;
        }
        return wektor;
    }
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
        this.y = y;
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
