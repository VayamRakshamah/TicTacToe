import Controller.GameController;
import Models.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {

        System.out.println("Welcome to Tic Tac Toe !!");
        Scanner sc  = new Scanner(System.in);

        System.out.println("What is the dimension of the game?");
        int dimension = sc.nextInt();

        System.out.println("What is the number of players?");
        int numOfPlayers = sc.nextInt();

        List<Player> playerList = new LinkedList<>();

        System.out.println("Will there be a bot? y/n");
        String isBot = sc.next();

        if(isBot.equals("y")){
            numOfPlayers-=1;

            System.out.println("Enter the name of the bot :");
            String botName = sc.next();

            System.out.println("Enter the symbol of the bot :");
            String botSymbol = sc.next();

            System.out.println("Enter the bot difficulty level : 1-Easy , 2-Medium , 3-Hard ");
            int difficultylevel = sc.nextInt();

            //TODO for value to Enum
            playerList.add(new Bot(botSymbol.charAt(0),botName, BotDifficultyLevel.EASY));
        }

        for (int i=0;i< numOfPlayers;i++){
            System.out.println("Enter the name of the player :");
            String playerName = sc.next();

            System.out.println("Enter the symbol of the player :");
            String playerSymbol = sc.next(); //Assume single character

            playerList.add(new Player(playerSymbol.charAt(0),playerName, PlayerType.HUMAN));
        }

        GameController gameController = new GameController();
        Game game = gameController.createGame(dimension,playerList);

        while(gameController.getGameStatus(game) == GameStatus.IN_PROGRESS){
            // TODO play the game
            System.out.println(" Current Board : ");
            gameController.displayBoard(game);
            gameController.executeNextMove(game);
        }
        if(gameController.getGameStatus(game) == GameStatus.DRAW){
            System.out.println(" Game is drawn ");
        }
        else{
            System.out.println(" Game has been won by : "+ gameController.getWinnerName(game));
        }
    }
}