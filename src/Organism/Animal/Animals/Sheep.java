package Organism.Animal.Animals;
import Board.Board;
import Organism.Animal.Animal;

import javax.swing.*;

public class Sheep extends Animal{
    public Sheep(ImageIcon img, int power, int initiative, boolean move, Board board, int x, int y){
        super(img, power, initiative, move, board, x, y);
    }
}
