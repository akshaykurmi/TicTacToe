package tictactoe;

import tictactoe.ui.DesktopApp;
import tictactoe.ui.UserInterface;

public class TicTacToe {
  public static void main(String[] args) {
    UserInterface userInterface = new DesktopApp();
    userInterface.display();
  }
}
