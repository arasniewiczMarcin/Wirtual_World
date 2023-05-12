package Board;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.*;
import Organism.Organism;

public class Board implements ActionListener {
    private Vector<Organism> organisms;
    private HashMap<String, ImageIcon> images = new HashMap<>();
    private int boardWidth;
    private int boardHeight;
    private final int windowWidth;
    private final int windowHeight;
    private final JFrame frame = new JFrame("Wirtual World");
    private JLabel board[][];
    private final ImageIcon inputScreen = new ImageIcon("src/label.png");
    private final JLabel inputLabel = new JLabel();
    private final JTextField inputHeight = new JTextField("20");
    private final JTextField inputWidth = new JTextField("20");
    private final JButton inputBtn = new JButton("Submit");
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
    public JFrame getFrame(){
        return this.frame;
    }
    public JLabel[][] getBoard(){
        return this.board;
    }
    public Vector<Organism> getOrganisms(){
        return this.organisms;
    }
    public void setBoardWidth(int boardWidth){
        this.boardWidth = boardWidth;
    }
    public void setBoardHeight(int boardHeight){
        this.boardHeight = boardHeight;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public ImageIcon getImage(String name){
        return this.images.get(name);
    }

    public void inputSize(){
        inputLabel.setIcon(getImage("input"));
        inputLabel.setBounds((getWindowWidth() / 2) - 300, (getWindowHeight() / 2) - 200, 522, 160);


        inputHeight.setBounds(700, 423, 180, 35);
        inputHeight.setFont(new Font("Comic Sans MS", Font.BOLD, 30));


        inputWidth.setBounds(970, 423, 180, 35);
        inputWidth.setFont(new Font("Comic Sans MS", Font.BOLD, 30));


        inputBtn.setBounds((getWindowWidth() / 2) - 150 , 500, 200, 50);
        inputBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        inputBtn.addActionListener(this);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(windowWidth, windowHeight);
        frame.setResizable(false);

        frame.setVisible(true);

        frame.add(inputHeight);
        frame.add(inputWidth);
        frame.add(inputBtn);
        frame.add(inputLabel);

    }

    public void createBoard(){

        frame.getContentPane().setBackground(new Color(0x25a561));
        board = new JLabel[boardHeight][boardWidth];

        int positionX;
        int positionY;

        for (int row = 0; row < getBoardHeight(); row++) {
           for (int col = 0; col < getBoardWidth(); col++) {
                board[row][col] = new JLabel();
                if((row + col) % 2 == 0)board[row][col].setBackground(Color.gray);
                else board[row][col].setBackground(Color.black);
                positionX = 41 * col + 5;
                positionY = 41 * row + 5;
                board[row][col].setBounds(positionX, positionY, 30, 30);
                board[row][col].setOpaque(true);

                frame.add(board[row][col]);
            }
        }




    }
    public Board(){

        this.comment = "";
        this.windowHeight = 1080;
        this.windowWidth = 1920;

        this.images.put("wilk", new ImageIcon("src/images/wilk.jpg"));
        this.images.put("owca", new ImageIcon("src/images/owca.png"));
        this.images.put("lis", new ImageIcon("src/images/lis.jpg"));
        this.images.put("zolw", new ImageIcon("src/images/zolw.jpg"));
        this.images.put("antylopa", new ImageIcon("src/images/antylopa.jpg"));
        this.images.put("trawa", new ImageIcon("src/images/trawa.jpg"));
        this.images.put("mlecz", new ImageIcon("src/images/mlecz.jpg"));
        this.images.put("guarana", new ImageIcon("src/images/guarana.jpg"));
        this.images.put("wilczeJagody", new ImageIcon("src/images/wilczeJagody.jpg"));
        this.images.put("input", new ImageIcon("src/images/Enter.png"));

        inputSize();
    }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        int inputWidth = Integer.parseInt(this.inputWidth.getText());
        int inputHeight = Integer.parseInt(this.inputHeight.getText());
        if(inputWidth > 0 && inputWidth <= 25 && inputHeight > 0 && inputHeight <= 25){

            this.boardHeight = inputHeight;
            this.boardWidth = inputWidth;

            inputBtn.setVisible(false);
            inputLabel.setVisible(false);
            this.inputHeight.setVisible(false);
            this.inputWidth.setVisible(false);


            frame.remove(inputBtn);
            frame.remove(inputLabel);
            frame.remove(this.inputHeight);
            frame.remove(this.inputWidth);

            createBoard();
        }
        else{
            comment = "Wrong input!";

        }
    }
}
