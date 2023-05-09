package Wirtual_World.Board;
import java.util.Vector;
import javax.swing.*;
import java.util.Scanner;
public class Board {
    //public Vector<Organism> organisms;
    private int boardWidth;
    private int boardHeight;
    private int windowWidth;
    private int windowHeight;
    private char[][] board;
    private String comment;

    public createBoard(){
        
    }
    public Board(){
        System.out.println("Enter board height: ");
        Scanner input = new Scanner(System.in);
        this.boardHeight = input.nextInt();
        System.out.println("Enter board width: ");
        this.boardWidth = input.nextInt();

        this.board = new char[boardHeight][boardWidth];
        this.comment = "";
        this.windowHeight = this.boardHeight + 300;
        this.windowWidth = this.boardWidth + 500;
    }
}
