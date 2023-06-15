package Organism.Plant.Plants;

import Board.Board;
import Organism.Plant.Plant;
import Organism.Organism;
import javax.swing.*;

public class Nightshade extends Plant {
    public Nightshade(ImageIcon img, int strength, int initiative, boolean move, Board board, int x, int y){
        super(img, strength, initiative, move, board, x, y);
    }
    @Override
    public boolean abilityCollision(Organism attacker, String comment){
        attacker.setStrength(0);
        return true;
    }
}
