package Organism.Animal;
import Board.Board;
import Organism.Organism;

import javax.swing.*;

public class Animal extends Organism{
    public Animal(ImageIcon img, int strength, int initiative, boolean move, Board board, int x, int y){
        super(img, strength, initiative, move, board, x, y);
        this.animal = true;
    }

    public void collision(Board board, int x, int y){
        if(board.getField(x,y).getIcon() == getImg()){
            breeding(board, x, y);
            JLabel l = new JLabel("Rozmnazanie na polu " + x + " " + y);
            System.out.println("Rozmnazanie na polu " + x + " " + y);
            l.setBounds(board.getCommentsX(), board.getCommentsY(), 300, 100);
            board.setCommentsY(board.getCommentsY() + 100);
            l.setOpaque(true);
            board.getFrame().add(l);

        }
        else{
            fight(this, board.getOrganism(x, y), board);
        }
    }
    public void action(Board board){
        int [] vector;

        while (true) {
            int direction = (int)(Math.random()*4);
            vector = createVector(direction);

            int x = getX() + vector[0];
            int y = getY() + vector[1];
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
            //System.out.println("kolizja na polu " + newX + " " + newY);

            collision(board, newX, newY);
        }

    }


    public void breeding(Board board, int x, int y){
        int newX = -1;
        int newY = -1;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(x + j >= 0 && x + j < board.getBoardWidth() && y + i >= 0 && y + i < board.getBoardHeight() && board.getField(x + j, y + i).getIcon() == null){
                    newX = x + j;
                    newY = y + i;

                }
            }
        }
        if(newX == -1 || newY == -1){
            return;
        }
        board.getOrganisms().add(new Animal(getImg(), getStrength(), getInitiative(), false, board, newX, newY));
        board.getField(newX, newY).setIcon(getImg());
    }
    public void fight(Animal attacker, Organism defender, Board board){
        if(defender != null && defender.abilityCollision(attacker, "attack")){

            JLabel l = new JLabel("Fight " + x + " " + y);
            System.out.println("Fight " + x + " " + y);
            l.setBounds(board.getCommentsX(), board.getCommentsY(), 300, 100);
            board.setCommentsY(board.getCommentsY() + 100);
            l.setOpaque(true);
            board.getFrame().add(l);

            if(attacker.getStrength() >= defender.getStrength()){


                board.deleteField(defender.getX(), defender.getY());
                board.deleteField(attacker.getX(), attacker.getY());
                attacker.setX(defender.getX());
                attacker.setY(defender.getY());
                board.getOrganisms().remove(defender);


                board.getField(attacker.getX(), attacker.getY()).setIcon(attacker.getImg());

            }
            else{
                board.deleteField(attacker.getX(), attacker.getY());

                board.getOrganisms().remove(attacker);

            }

        }
    }
}
