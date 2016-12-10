package tictactoe.game.player;

import tictactoe.game.Board;
import tictactoe.game.Cell;
import tictactoe.game.Coordinate;
import tictactoe.game.Symbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AIPlayer implements Player {
  private Symbol currentSymbol;

  @Override
  public Coordinate makeMove(Board board, Symbol symbol, Coordinate bestMove) {
    currentSymbol = symbol;

    List<Coordinate> availableCoordinates = board.getEmptyCoordinates();
    List<Integer> scores = scoresForCoordinates(board, symbol, availableCoordinates, 0);

    int bestIndex = scores.indexOf(Collections.max(scores));
    bestMove = availableCoordinates.get(bestIndex);
    board.add(new Cell(bestMove, symbol));

    return bestMove;
  }

  private Integer minimax(Board board, Symbol symbol, int depth) {
    if (board.isGameOver()) {
      return score(board, depth);
    }
    List<Coordinate> availableCoordinates = board.getEmptyCoordinates();
    List<Integer> scores = scoresForCoordinates(board, symbol, availableCoordinates, depth + 1);
    if (symbol == currentSymbol) {
      return Collections.max(scores);
    }
    return Collections.min(scores);
  }

  private List<Integer> scoresForCoordinates(Board board, Symbol symbol, List<Coordinate> availableCoordinates, int depth) {
    List<Integer> scores = new ArrayList<>();
    for (Coordinate coordinate : availableCoordinates) {
      Board currentBoard = new Board(board);
      currentBoard.add(new Cell(coordinate, symbol));
      scores.add(minimax(currentBoard, symbol.flip(), depth));
    }
    return scores;
  }

  private Integer score(Board currentBoard, int depth) {
    if (currentBoard.checkWon(currentSymbol)) {
      return 10 - depth;
    }
    else if (currentBoard.checkWon(currentSymbol.flip())) {
      return depth - 10;
    }
    return 0;
  }
}
