package Organism.Animal.Animals;
import Board.Board;
import Organism.Animal.Animal;
import Organism.Organism;
import javax.swing.*;

public class Antelope extends Animal{
    public Antelope(ImageIcon img, int strength, int initiative, boolean move, Board board, int x, int y){
        super(img, strength, initiative, move, board, x, y);
    }
    @Override
    public void action(Board board){
        int [] vector;

        for(int i = 0; i < 2; i++){


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
            System.out.println("kolizja na polu " + newX + " " + newY);
            collision(board, newX, newY);
        }}
    }
    @Override
    public boolean abilityCollision(Organism attacker, String comment){
        int probability = (int)(Math.random()*100);
        if(probability < 50){

            return true;
        }
        else{
            if(getBoard().checkIfSpace(getX(), getY())){


            int [] vector;
            while (true) {
                int direction = (int)(Math.random()*4);
                vector = createVector(direction);

                int x = getX() + vector[0];
                int y = getY() + vector[1];

                int newX = getX() + vector[0];
                int newY = getY() + vector[1];

                if(x >= 0 && x < board.getBoardWidth() && y >= 0 && y < board.getBoardHeight() && board.checkIfFieldIsEmpty(newX, newY)){

                    board.deleteField(getX(), getY());
                    setX(newX);
                    setY(newY);
                    board.getField(getX(), getY()).setIcon(getImg());
                    return false;
                }

            }}
            else return true;



        }
    }

}
