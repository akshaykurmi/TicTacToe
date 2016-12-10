package tictactoe.game.player;

import tictactoe.game.Board;
import tictactoe.game.Cell;
import tictactoe.game.Coordinate;
import tictactoe.game.Symbol;

public class HumanPlayer implements Player {
  @Override
  public Coordinate makeMove(Board board, Symbol symbol, Coordinate coordinate) {
    board.add(new Cell(coordinate, symbol));
    return coordinate;
  }
}
