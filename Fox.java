package Organism.Animal.Animals;
import Board.Board;
import Organism.Animal.Animal;
import Organism.Organism;

import javax.swing.*;

public class Fox extends Animal{
    public Fox(ImageIcon img, int power, int initiative, boolean move, Board board, int x, int y){
        super(img, power, initiative, move, board, x, y);
    }
    @Override
    public void action(Board board){

    }

}
