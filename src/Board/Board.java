package Board;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.*;
import Organism.Organism;
import Organism.Animal.Animals.*;
import Organism.Plant.Plants.*;

import java.util.*;
import java.io.File;

public class Board implements KeyListener{
    private final Vector<Organism> organisms = new Vector<>();

    String fileName;
    private final HashMap<String, ImageIcon> images = new HashMap<>();
    private int boardWidth;
    private int boardHeight;
    private final int windowWidth;
    private final int windowHeight;
    private final JFrame frame = new JFrame("Wirtual World");
    private JLabel board[][];
    private final JLabel inputLabel = new JLabel();
    private final JTextField inputHeight = new JTextField("20");
    private final JTextField inputWidth = new JTextField("20");
    private final JButton inputBtn = new JButton("Submit");
    private final JButton saveBtn = new JButton("Save game");
    private final JButton loadBtn = new JButton("Load game");
    private final JButton nextTurnBtn = new JButton("Next Turn");
    private int commentsX;
    private int commentsY;

    private JPanel comments = new JPanel();
    private String comment;
    int x;
    int y;

    public int getCommentsX(){
        return this.commentsX;
    }
    public int getCommentsY() {
        return this.commentsY;
    }
    public void setCommentsX(int x) {
        this.commentsX = x;
    }
    public void setCommentsY(int y) {
        this.commentsX = y;
    }

    public String getFileName(){
        return this.fileName;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y=y;
    }
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
    public JTextField getInputHeight(){
        return this.inputHeight;
    }
    public JTextField getInputWidth(){
        return this.inputWidth;
    }
    public JButton getInputBtn(){
        return this.inputBtn;
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
    public int getOrganismsAmount(){
        return this.organisms.size();
    }
    public JLabel getField(int x, int y){
        return this.board[y][x];
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
    public int drawPositionX(){
        return (int)Math.floor(Math.random() * getBoardWidth());
    }
    public int drawPositionY(){
        return (int)Math.floor(Math.random() * getBoardHeight());
    }

    public boolean checkIfSpace(int x, int y){
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(x + j >= 0 && x + j < getBoardWidth() && y + i >= 0 && y + i < getBoardHeight() && this.board[y + i][x + j].getIcon() == null){
                    return true;
                }
            }
        }
        return false;
    }
    public void drawXY(){
        int x = drawPositionX();
        int y = drawPositionY();
        while(occupiedField(x, y)){
            x = drawPositionX();
            y = drawPositionY();
        }
        setX(x);
        setY(y);
    }


    public boolean checkIfFieldIsEmpty(int x, int y){
        if(x >= 0 && x < getBoardWidth() && y >= 0 && y < getBoardHeight() && this.board[y][x].getIcon() == null){
            return true;
        }
        return false;

    }
    public void deleteField(int x, int y){
        this.board[y][x].setIcon(null);
    }
    public boolean occupiedField(int x, int y){
        for (Organism organism : this.organisms) {
            if (organism.getX() == x && organism.getY() == y) {
                return true;
            }
        }
        return false;
    }
    public void drawOrganisms(){
            for (Organism organism : this.organisms) {
                this.board[organism.getY()][organism.getX()].setIcon(organism.getImg());
            }
    }
    public void inputSize()
    {
        inputLabel.setIcon(getImage("input"));
        inputLabel.setBounds((getWindowWidth() / 2) - 300, (getWindowHeight() / 2) - 200, 522, 160);

        inputHeight.setBounds(700, 423, 180, 35);
        inputHeight.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

        inputWidth.setBounds(970, 423, 180, 35);
        inputWidth.setFont(new Font("Comic Sans MS", Font.BOLD, 30));

        inputBtn.setBounds((getWindowWidth() / 2) - 150 , 500, 200, 50);
        inputBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 40));

        loadBtn.setBounds((getWindowWidth() / 2) - 150 , 700, 200, 50);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(windowWidth, windowHeight);
        frame.setResizable(false);

        frame.setVisible(true);

        frame.add(inputHeight);
        frame.add(inputWidth);
        frame.add(inputBtn);
        frame.add(inputLabel);
        frame.add(loadBtn);
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
                positionX = 40 * col + 5;
                positionY = 40 * row + 5;
                board[row][col].setBounds(positionX, positionY, 30, 30);
                board[row][col].setOpaque(true);

                frame.add(board[row][col]);
            }
        }
        nextTurnBtn.setBounds((getWindowWidth() / 4) - 300, getBoardHeight() * 40, 400, 50);
        nextTurnBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        frame.add(nextTurnBtn);

        saveBtn.setBounds((getWindowWidth() / 4) - 300, getBoardHeight() * 40 + 100, 400, 50);
        frame.add(saveBtn);

        int OrganismsAmount = ((getBoardHeight() * getBoardWidth()) / (10 * 11)) + 1;

        organisms.add(new Human(getImage("czlowiek"), 5, 4, true, this, drawPositionX(), drawPositionY()));

        for(int i = 0; i < OrganismsAmount; i++){
            drawXY();
            organisms.add(new Grass(getImage("trawa"), 0, 0, true, this, getX(), getY()));
            drawXY();
            organisms.add(new Dandelion(getImage("mlecz"), 0, 0, true, this, getX(), getY()));
            drawXY();
            organisms.add(new Guarana(getImage("guarana"), 0, 0, true, this, getX(), getY()));
            drawXY();
            organisms.add(new Nightshade(getImage("wilczeJagody"), 99, 0, true, this, getX(), getY()));
            drawXY();
            organisms.add(new PineBorscht(getImage("barszcz"), 10, 0, true, this, getX(), getY()));
            drawXY();
            organisms.add(new Sheep(getImage("owca"), 4, 4, true, this, getX(), getY()));
            drawXY();
            organisms.add(new Woolf(getImage("wilk"), 9, 5, true, this, getX(), getY()));
            drawXY();
            organisms.add(new Antelope(getImage("antylopa"), 4, 4, true, this,getX(), getY()));
            drawXY();
            organisms.add(new Fox(getImage("lis"), 3, 7, true, this, getX(), getY()));
            drawXY();
            organisms.add(new Turtle(getImage("zolw"), 2, 1, true, this, getX(), getY()));
            drawXY();

        }
        drawOrganisms();

        commentsX = getBoardWidth() * 45;
        commentsY = 100;

    }
    public Board(){
        this.comment = "";
        this.windowHeight = 1080;
        this.windowWidth = 1920;

        this.images.put("wilk", new ImageIcon("src/images/wilk.jpg"));
        this.images.put("czlowiek", new ImageIcon("src/images/czlowiek.jpg"));
        this.images.put("owca", new ImageIcon("src/images/owca.png"));
        this.images.put("lis", new ImageIcon("src/images/lis.jpg"));
        this.images.put("zolw", new ImageIcon("src/images/zolw.jpg"));
        this.images.put("antylopa", new ImageIcon("src/images/antylopa.jpg"));
        this.images.put("trawa", new ImageIcon("src/images/trawa.jpg"));
        this.images.put("mlecz", new ImageIcon("src/images/mlecz.jpg"));
        this.images.put("guarana", new ImageIcon("src/images/guarana.jpg"));
        this.images.put("wilczeJagody", new ImageIcon("src/images/wilczeJagody.jpg"));
        this.images.put("input", new ImageIcon("src/images/Enter.png"));
        this.images.put("barszcz", new ImageIcon("src/images/barszcz.jpg"));


        setButtons();
        inputSize();
        frame.addKeyListener(this);
        frame.setFocusable(true);
    }

    public Organism getOrganism(int x, int y){
        for (int i = 0; i < organisms.size(); i++) {
            if(organisms.get(i).getX() == x && organisms.get(i).getY() == y){
                return organisms.get(i);
            }
        }
        return null;
    }
    public void nextTurn(){

        for (int j = 0; j < organisms.size(); j++) {
            if(organisms.get(j).getInitiative() == 4 && organisms.get(j).getStrength() == 5){
                if(organisms.get(j).getVectorX() == 0 && organisms.get(j).getVectorY() == 0){
                    frame.requestFocusInWindow();
                    return;
                }
            }
        }
        int MAX_INITIATIVE = 7;
        for (int i = MAX_INITIATIVE; i >= 0 ; i--) {
            for (int j = 0; j < organisms.size(); j++) {
                if (organisms.get(j).getMove() && organisms.get(j).getInitiative() == i) {
                    organisms.get(j).action(this);
                    organisms.get(j).setMove(false);
                }
            }
        }
        for (int j = 0; j < organisms.size(); j++) {
            organisms.get(j).setMove(true);
        }
        frame.requestFocusInWindow();

    }
    public void setButtons(){
        ActionListener inputBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int width = Integer.parseInt(getInputWidth().getText());
                int height = Integer.parseInt(getInputHeight().getText());
                if(width > 0 && width <= 25 && height > 0 && height <= 25){

                    boardHeight = height;
                    boardWidth = width;

                    inputBtn.setVisible(false);
                    inputLabel.setVisible(false);
                    inputHeight.setVisible(false);
                    inputWidth.setVisible(false);

                    frame.remove(inputBtn);
                    frame.remove(inputLabel);
                    frame.remove(inputHeight);
                    frame.remove(inputWidth);

                    createBoard();
                }
                else{
                    comment = "Wrong input!";

                }
            }
        };
        ActionListener nextTurnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextTurn();
            }
        };
        ActionListener saveListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = "Save.txt";
                setFileName(fileName);
                try {
                    File file = new File(fileName);
                    file.createNewFile();

                    PrintWriter pw = new PrintWriter(file);
                    pw.print(getBoardWidth() + " ");
                    pw.print(getBoardHeight() + " ");

                    for (int i = 0; i < organisms.size(); i++) {
                        Organism organism = organisms.get(i);
                        pw.print(organism.getImg() + " ");
                        pw.print(organism.getX() + " ");
                        pw.print(organism.getY() + " ");
                        pw.print(organism.getStrength() + " ");
                        pw.print(organism.getAbilityOn() + " ");
                        pw.print(organism.getTimeToEndAbility() + " ");
                        pw.print(organism.getTimeToActivateAbility() + " ");
                        pw.println();
                    }
                    pw.close();
                } catch (IOException exc) {
                    System.out.println("Error: " + exc);
                }
            }
        };
        ActionListener loadListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File("Save.txt");
                    Scanner scanner = new Scanner(file);

                    organisms.clear();
                    frame.getContentPane().removeAll();
                    System.out.println("Load");

                    if (scanner.hasNextInt()) {
                        int width = scanner.nextInt();
                        int height = scanner.nextInt();

                        setBoardHeight(height);
                        setBoardWidth(width);
                        board = new JLabel[height][width];
                        int positionX;
                        int positionY;
                        for (int row = 0; row < getBoardHeight(); row++) {
                            for (int col = 0; col < getBoardWidth(); col++) {
                                board[row][col] = new JLabel();
                                if ((row + col) % 2 == 0)
                                    board[row][col].setBackground(Color.gray);
                                else
                                    board[row][col].setBackground(Color.black);
                                positionX = 40 * col + 5;
                                positionY = 40 * row + 5;
                                board[row][col].setBounds(positionX, positionY, 30, 30);
                                board[row][col].setOpaque(true);
                                frame.add(board[row][col]);
                            }
                        }
                        nextTurnBtn.setBounds((getWindowWidth() / 4) - 300, getBoardHeight() * 40, 400, 50);
                        nextTurnBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
                        frame.add(nextTurnBtn);

                        saveBtn.setBounds((getWindowWidth() / 4) - 300, getBoardHeight() * 40 + 100, 400, 50);
                        frame.add(saveBtn);
                            while(scanner.hasNext()) {
                            String imgName = scanner.next();
                            int x = scanner.nextInt();
                            int y = scanner.nextInt();
                            int strength = scanner.nextInt();
                            boolean abilityOn = scanner.nextBoolean();
                            int timeToEndAbility = scanner.nextInt();
                            int timeToActivateAbility = scanner.nextInt();

                            ImageIcon img = getImage(imgName);
                            loadOrganism(imgName, strength, timeToEndAbility, x, y);
                           // board[y][x].setIcon(img);
                            //board[y][x].setOpaque(true);

                        }
                        frame.revalidate();
                        frame.repaint();
                    }
                    scanner.close();
                    drawOrganisms();
                    frame.getContentPane().setBackground(new Color(0x25a561));
                } catch (FileNotFoundException exc) {
                    System.out.println("Error: " + exc);
                }

            }
        };
        inputBtn.addActionListener(inputBtnListener);
        nextTurnBtn.addActionListener(nextTurnListener);
        saveBtn.addActionListener(saveListener);
        loadBtn.addActionListener(loadListener);

    }

    private void loadOrganism(String image, int s, int ini, int x, int y) {
        switch (image){
            case "src/images/czlowiek.jpg":
                ImageIcon humanImg = new ImageIcon("src/images/czlowiek.jpg");
                organisms.add(new Human(humanImg, 5, 4, true, this, x, y));
                getField(x, y).setIcon(humanImg);
                break;
            case "src/images/guarana.jpg":
                ImageIcon guaranaImg = new ImageIcon("src/images/guarana.jpg");
                organisms.add(new Guarana(guaranaImg, s, ini, true, this, x, y));
                getField(x, y).setIcon(guaranaImg);
                break;
            case "src/images/antylopa.jpg":
                ImageIcon antelopeImg = new ImageIcon("src/images/antylopa.jpg");
                organisms.add(new Antelope(antelopeImg, s, ini, true, this, x, y));
                getField(x, y).setIcon(antelopeImg);
                break;
            case "src/images/lis.jpg":
                ImageIcon foxImg = new ImageIcon("src/images/lis.jpg");
                organisms.add(new Fox(foxImg, s, ini, true, this, x, y));
                getField(x, y).setIcon(foxImg);
                break;
            case "src/images/owca.jpg":
                ImageIcon sheepImg = new ImageIcon("src/images/owca.png");
                organisms.add(new Sheep(sheepImg, s, ini, true, this, x, y));
                getField(x, y).setIcon(sheepImg);
                break;
            case "src/images/zolw.jpg":
                ImageIcon turtleImg = new ImageIcon("src/images/zolw.jpg");
                organisms.add(new Turtle(turtleImg, s, ini, true, this, x, y));
                getField(x, y).setIcon(turtleImg);
                break;
            case "src/images/wilk.jpg":
                ImageIcon woolfImg = new ImageIcon("src/images/wilk.jpg");
                organisms.add(new Woolf(woolfImg, s, ini, true, this, x, y));
                getField(x, y).setIcon(woolfImg);
                break;
            case "src/images/trawa.jpg":
                ImageIcon grassImg = new ImageIcon("src/images/trawa.jpg");
                organisms.add(new Grass(grassImg, s, ini, true, this, x, y));
                getField(x, y).setIcon(grassImg);
                break;
            case "src/images/mlecz.jpg":
                ImageIcon dandelionImg = new ImageIcon("src/images/mlecz.jpg");
                organisms.add(new Dandelion(dandelionImg, s, ini, true, this, x, y));
                getField(x, y).setIcon(dandelionImg);
                break;
            case "src/images/wilczeJagody.jpg":
                ImageIcon wolfberryImg = new ImageIcon("src/images/wilczeJagody.jpg");
                organisms.add(new Nightshade(wolfberryImg, s, ini, true, this, x, y));
                getField(x, y).setIcon(wolfberryImg);
                break;

            case "src/images/barszcz.jpg":
                ImageIcon sosnowskyImg = new ImageIcon("src/images/barszcz.jpg");
                organisms.add(new PineBorscht(sosnowskyImg, s, ini, true, this, x, y));
                getField(x, y).setIcon(sosnowskyImg);
                break;

        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        for (int j = 0; j < organisms.size(); j++) {
            if(organisms.get(j).getInitiative() == 4 && organisms.get(j).getStrength() == 5){
                //human detected
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    organisms.get(j).setVectorX(0);
                    organisms.get(j).setVectorY(-1);
                }
                else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    organisms.get(j).setVectorX(0);
                    organisms.get(j).setVectorY(1);
                }
                else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    organisms.get(j).setVectorX(-1);
                    organisms.get(j).setVectorY(0);
                }
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    organisms.get(j).setVectorX(1);
                    organisms.get(j).setVectorY(0);
                }
                else if(e.getKeyCode() == KeyEvent.VK_A){

                    if(organisms.get(j).getAbilityOn() == false && organisms.get(j).getTimeToActivateAbility() == 0){
                        organisms.get(j).setAbilityOn(true);
                        organisms.get(j).setTimeToEndAbility(5);
                        System.out.println("ability activated");

                    }

                }

            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // Ignore keyTyped event
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Ignore keyReleased event
    }

}
