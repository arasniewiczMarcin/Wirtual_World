package Organism.Plant;
import Board.Board;
import Organism.Organism;
import javax.swing.*;

public class Plant extends Organism{
    public Plant(ImageIcon img, int strength, int initiative, boolean move, Board board, int x, int y){
        super(img, strength, initiative, move, board, x, y);
    }
    public void action(Board board){

    }
    public void collision(Board board, int x, int y){}
    public boolean abilityCollision(Organism attacker, String comment){
        return false;
    }
    public void spreading(Board board){
    }
}
