package Organism.Plant.Plants;

import Board.Board;
import Organism.Plant.Plant;
import javax.swing.*;
import Organism.Organism;

public class PineBorscht extends Plant{
    public PineBorscht(ImageIcon img, int strength, int initiative, boolean move, Board board, int x, int y){
        super(img, strength, initiative, move, board, x, y);
    }
    public void action(Board board){
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if ((i != 0 || j != 0) && getX() + j >=0 && getX() + j < board.getBoardWidth() && getY() + i >= 0 && getY() + i < board.getBoardHeight()
                        && board.checkIfFieldIsEmpty(getX() + j, getY() + i) == false) {
                    int x = getX() + j;
                    int y = getY() + i;

                    if(!board.checkIfFieldIsEmpty(x,y) && board.getOrganism(x, y) != null && board.getOrganism(x, y).getInitiative() > 0){
                        board.getOrganisms().remove(board.getOrganism(x, y));
                        board.deleteField(x, y);
                    }
                }
            }
        }
        super.action(board);
    }
    @Override
    public boolean abilityCollision(Organism attacker, String comment){
        attacker.setStrength(0);
        return true;
    }
}
