package Organism.Animal.Animals;
import Board.Board;
import Organism.Animal.Animal;
import Organism.Organism;
import javax.swing.ImageIcon;
public class Human extends Animal{
    public Human(ImageIcon img, int power, int initiative, boolean move, Board board, int x, int y){
        super(img, power, initiative, move, board, x, y);
    }
    @Override
    public void action(Board board){
        // TODO implement here
    }
    public void setAbilities(){}

}
