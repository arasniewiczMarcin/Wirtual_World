package Organism.Animal.Animals;
import Board.Board;
import Organism.Animal.Animal;
import Organism.Organism;

import javax.swing.*;

public class Turtle extends Animal{
    public Turtle (ImageIcon img, int strength, int initiative, boolean move, Board board, int x, int y){
        super(img, strength, initiative, move, board, x, y);
    }

    public void action(Board board){
        if((int)(Math.random()*4) == 0)
            super.action(board);
    }
    @Override
    public boolean abilityCollision(Organism attacker, String comment){
        if(attacker.getStrength() < 5){
            comment = "Turtle blocked attack";
            return false;
        }
        return true;

    }
}
