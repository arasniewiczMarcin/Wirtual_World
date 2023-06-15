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
        int [] vector;

        while (true) {
            int direction = (int)(Math.random()*4);
            vector = createVector(direction);

            int x = getX() + vector[0];
            int y = getY() + vector[1];
            if(!board.checkIfFieldIsEmpty(x,y) && board.getOrganism(x, y) != null && board.getOrganism(x, y).getStrength() > this.getStrength()){
                continue;
            }
            if(x >= 0 && x < board.getBoardWidth() && y >= 0 && y < board.getBoardHeight()){
                break;
            }
        }
        int newX = getX() + vector[0];
        int newY = getY() + vector[1];

        if(board.checkIfFieldIsEmpty(newX, newY)){

            board.deleteField(getX(), getY());
            setX(newX);
            setY(newY);
            board.getField(getX(), getY()).setIcon(getImg());
        }
        else{
            System.out.println("kolizja na polu " + newX + " " + newY);
            collision(board, newX, newY);
        }
    }

}
