package Models;

import java.util.Scanner;

public class Player {
    private char symbol;
    private String name;

    private PlayerType playerType;

    public Player(char c, String botName, PlayerType type) {
        this.symbol = c;
        this.name = botName;
        this.playerType  = type;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move decideMove(Board board) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the row to make a move : ");
        int row = scan.nextInt();
        System.out.println("Enter the column to make a move : ");
        int column = scan.nextInt();
        return  new Move(this,new Cell(row,column));
    }
}
