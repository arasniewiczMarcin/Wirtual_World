package Organism.Animal.Animals;
import Board.Board;
import Organism.Animal.Animal;
import javax.swing.ImageIcon;
import java.util.Scanner;


public class Human extends Animal {

    public void set(){
        setAbilityOn(false);
        setTimeToActivateAbility(0);
        setTimeToEndAbility(5);
        setVectorY(0);
        setVectorX(0);
    }
    public Human(ImageIcon img, int power, int initiative, boolean move, Board board, int x, int y) {
        super(img, power, initiative, move, board, x, y);
        set();
    }

    @Override
    public void action(Board board) {
        //System.out.println("Ruch");
        int counter = 1;
        if(getAbilityOn()){
            if(getTimeToEndAbility() > 2){
                setTimeToEndAbility(getTimeToEndAbility() - 1);
                counter = 2;
            }
            else if(getTimeToEndAbility() > 0){
                int random = (int)(Math.random()*4);
                setTimeToEndAbility(getTimeToEndAbility() - 1);
                if(random > 1)counter = 2;

            }
            else if(getTimeToEndAbility() == 0){
                setAbilityOn(false);
                setTimeToActivateAbility(5);
                setTimeToEndAbility(5);
            }
        }
        for(int i = 0; i < counter; i++) {

            int newX = getX() + getVectorX();
            int newY = getY() + getVectorY();
            if(newX <0 || newX >= board.getWindowWidth() || newY < 0 || newY >= board.getWindowHeight())return;

            if (board.checkIfFieldIsEmpty(newX, newY)) {

                board.deleteField(getX(), getY());
                setX(newX);
                setY(newY);
                board.getField(getX(), getY()).setIcon(getImg());
            } else {
                collision(board, newX, newY);
            }
        }
        if(getTimeToActivateAbility() > 0)
            setTimeToActivateAbility(getTimeToActivateAbility() - 1);
        setVectorY(0);
        setVectorX(0);
    }
}
