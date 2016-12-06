package tictactoe.ui;

import tictactoe.game.Coordinate;
import tictactoe.game.Symbol;

public interface UserInterface {
  void display();
  void displayMessage(String message);
  void refresh(Coordinate coordinate, Symbol symbol);
  void freezeBoard();
}
