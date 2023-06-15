package Organism.Animal.Animals;
import Board.Board;
import Organism.Animal.Animal;
import Organism.Organism;

import javax.swing.*;

public class Woolf extends Animal{
    public Woolf(ImageIcon img, int strength, int initiative, boolean move, Board board, int x, int y){
        super(img, strength, initiative, move, board, x, y);
    }
}
