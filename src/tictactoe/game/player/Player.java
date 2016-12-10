package tictactoe.game.player;

import tictactoe.game.Board;
import tictactoe.game.Coordinate;
import tictactoe.game.Symbol;

public interface Player {
  Coordinate makeMove(Board board, Symbol symbol, Coordinate coordinate);
}
