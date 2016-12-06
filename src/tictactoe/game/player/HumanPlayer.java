package tictactoe.game.player;

import tictactoe.game.Board;
import tictactoe.game.Cell;
import tictactoe.game.Coordinate;
import tictactoe.game.Symbol;

public class HumanPlayer implements Player {
  @Override
  public Board makeMove(Board board, Coordinate coordinate, Symbol symbol) {
    board.add(new Cell(coordinate, symbol));
    return board;
  }
}
