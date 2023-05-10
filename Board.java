package Wirtual_World.Board;
import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import java.util.Scanner;
public class Board {
    //public Vector<Organism> organisms;
    private int boardWidth;
    private int boardHeight;
    private final int windowWidth;
    private final int windowHeight;
    ////private final char[][] board;
    private String comment;

    public int getBoardWidth(){
        return this.boardWidth;
    }
    public int getBoardHeight(){
        return this.boardHeight;
    }
    public int getWindowWidth(){
        return this.windowWidth;
    }
    public int getWindowHeight(){
        return this.windowHeight;
    }


    public void createBoard(){
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        JFrame window = new JFrame("Wirtual World");
        window.setSize(this.windowWidth, this.windowHeight);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(new Color(0x25a561), 3));
        panel.setLayout(new GridLayout(0, 1));
        panel.setBackground(Color.black);

        ImageIcon image = new ImageIcon(getClass().getResource("label.jpg"));

        JLabel inputLabel = new JLabel("Enter board height: ");
        inputLabel.setIcon(image);
        inputLabel.setBounds(50, 50, 200, 30);
        //lHeight.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));


        //window.add(lHeight);

        JLabel lWidth = new JLabel("Enter board height: ");
        lWidth.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));
        panel.add(lWidth);
        JButton inputBtn = new JButton("Confirm");
        inputBtn.setSize(100, 50);
        //panel.add(inputBtn);

        window.add(panel, BorderLayout.CENTER);


        /*JTextField boardHeightInput = new JTextField("Enter board height: ");
        boardHeightInput.setBounds(50, 100, 200, 30);
        window.add(boardHeightInput);
        JTextField boardWidthInput = new JTextField("Enter board width: ");
        boardWidthInput.setBounds(50, 150, 200, 30);
        window.add(boardWidthInput);*/



        //this.boardHeight = Integer.parseInt(boardHeightInput.getText());
        //this.boardWidth = Integer.parseInt(boardWidthInput.getText());

        window.setVisible(true);

    }

    public Board(){
        /*System.out.println("Enter board height: ");
        Scanner input = new Scanner(System.in);
        this.boardHeight = input.nextInt();
        System.out.println("Enter board width: ");
        this.boardWidth = input.nextInt();*/

        //this.board = new char[boardHeight][boardWidth];
        this.comment = "";
        this.windowHeight = 720;
        this.windowWidth = 1280;

        createBoard();
    }
}
