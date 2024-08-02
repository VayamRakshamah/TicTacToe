package Strategy;

import Models.Board;
import Models.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStrategy implements GameWinningStrategy{

    // hashmap for respective symbols and their count
    List<HashMap<Character,Integer>> rowSymbolCounts = new ArrayList<>();
    List<HashMap<Character,Integer>> columnSymbolCounts = new ArrayList<>();

    HashMap<Character,Integer> topLeftDiagonalSymbolCounts = new HashMap<>();
    HashMap<Character,Integer> topRightDiagonalSymbolCounts = new HashMap<>();

    public OrderOneGameWinningStrategy(int dimension) {
        for(int i=0;i<dimension;i++){
            rowSymbolCounts.add(new HashMap<>());
            columnSymbolCounts.add(new HashMap<>());
        }
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        char symbol = move.getPlayer().getSymbol();
        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();
        int dimension = board.getBoard().size();

        //check if the symbol exist at that position and update the count

        if(!rowSymbolCounts.get(row).containsKey(symbol)){
            rowSymbolCounts.get(row).put(symbol,0);
        }
        rowSymbolCounts
                .get(row)
                .put(symbol,rowSymbolCounts.get(row).get(symbol)+1);


        if(!columnSymbolCounts.get(column).containsKey(symbol)){
            columnSymbolCounts.get(column).put(symbol,0);
        }
        columnSymbolCounts
                .get(column)
                .put(symbol,columnSymbolCounts.get(column).get(symbol)+1);


        if(row == column){
            if(!topLeftDiagonalSymbolCounts.containsKey(symbol)){
                topLeftDiagonalSymbolCounts.put(symbol,0);
            }
            topLeftDiagonalSymbolCounts
                    .put(symbol,topLeftDiagonalSymbolCounts.get(symbol)+1);
        }

        if(row + column == dimension - 1){
            if(!topRightDiagonalSymbolCounts.containsKey(symbol)){
                topRightDiagonalSymbolCounts.put(symbol,0);
            }
            topRightDiagonalSymbolCounts
                    .put(symbol,topRightDiagonalSymbolCounts.get(symbol)+1);
        }

        //Check winner
        if(rowSymbolCounts.get(row).get(symbol) == dimension
                || columnSymbolCounts.get(column).get(symbol) == dimension){
            return true;
        }
        if(row == column && topLeftDiagonalSymbolCounts.get(symbol) == dimension){
            return true;
        }
        if(row + column == dimension-1 && topRightDiagonalSymbolCounts.get(symbol) == dimension){
            return true;
        }
        return false;
    }
}
