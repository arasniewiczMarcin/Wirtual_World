package Organism.Animal.Animals;
import Board.Board;
import Organism.Animal.Animal;
import Organism.Organism;

import javax.swing.*;

public class Turtle extends Animal{
    public Turtle (ImageIcon img, int strength, int initiative, boolean move, Board board, int x, int y){
        super(img, strength, initiative, move, board, x, y);
    }
    @Override
    public void action(Board board){

    }
    @Override
    public boolean abilityCollision(Organism attacker, String comment){
        return false;
    }
}
