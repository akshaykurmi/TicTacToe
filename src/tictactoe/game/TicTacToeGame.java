package tictactoe.game;

import tictactoe.game.player.Player;
import tictactoe.ui.UserInterface;

import static tictactoe.game.Symbol.*;

public class TicTacToeGame implements Game {
  private final Player playerX;
  private final Player playerO;
  private Symbol currentSymbol;
  private Board board;
  private UserInterface userInterface;

  public TicTacToeGame(Player playerX, Player playerO, UserInterface userInterface) {
    this.playerX = playerX;
    this.playerO = playerO;
    this.userInterface = userInterface;
    board = new Board(3, 3);
    currentSymbol = X;
  }

  @Override
  public void play(Coordinate coordinate) {
    if (currentSymbol == X) {
      board = playerX.makeMove(board, coordinate, currentSymbol);
    }
    else {
      board = playerO.makeMove(board, coordinate, currentSymbol);
    }
    userInterface.refresh(coordinate, currentSymbol);
    flipCurrentSymbol();
    sendMessage();
  }

  private void sendMessage() {
    userInterface.displayMessage(currentSymbol + " - Make your Move");
    if (board.checkWon(X)) {
      userInterface.displayMessage("X has Won!!");
      userInterface.freezeBoard();
    }
    else if (board.checkWon(O)) {
      userInterface.displayMessage("O has Won!!");
      userInterface.freezeBoard();
    }
    else if (board.checkDraw()) {
      userInterface.displayMessage("The Match is a Draw.");
      userInterface.freezeBoard();
    }
  }

  private void flipCurrentSymbol() {
    currentSymbol = currentSymbol == X ? O : X;
  }
}
