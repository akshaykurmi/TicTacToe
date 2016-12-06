package tictactoe.game.player;

import tictactoe.game.Board;
import tictactoe.game.Coordinate;
import tictactoe.game.Symbol;

public interface Player {
  Board makeMove(Board board, Coordinate coordinate, Symbol symbol);
}
