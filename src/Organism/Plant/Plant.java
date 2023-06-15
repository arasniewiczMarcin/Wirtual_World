package Organism.Plant;
import Board.Board;
import Organism.Animal.Animal;
import Organism.Organism;
import javax.swing.*;

public class Plant extends Organism{
    public Plant(ImageIcon img, int strength, int initiative, boolean move, Board board, int x, int y){
        super(img, strength, initiative, move, board, x, y);
        this.animal = false;
    }
    public void action(Board board){
        int rand = (int)(Math.random()*10);
        if(rand < 2) spreading(board);
    }
    public void collision(Board board, int x, int y){}
    public boolean abilityCollision(Organism attacker, String comment){
        return true;
    }
    public void spreading(Board board){
        JLabel l = new JLabel("Spreading " + x + " " + y);
        System.out.println("Spreading ");
        l.setBounds(board.getCommentsX(), board.getCommentsY(), 300, 100);
        board.setCommentsY(board.getCommentsY() + 100);
        l.setOpaque(true);
        board.getFrame().add(l);
        int newX = 0;
        int newY = 0;
        if(board.checkIfSpace(getX(), getY())){

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(getX() + j >= 0 && getX() + j < board.getBoardWidth() && getY() + i >= 0 && getY() + i < board.getBoardHeight() && board.getField(getX() + j, getY() + i).getIcon() == null){
                    newX = getX() + j;
                    newY = getY() + i;

                }
            }
        }
        }
        board.getOrganisms().add(new Plant(getImg(), getStrength(), getInitiative(), false, board, newX, newY));
        board.getField(newX, newY).setIcon(getImg());
    }
}
