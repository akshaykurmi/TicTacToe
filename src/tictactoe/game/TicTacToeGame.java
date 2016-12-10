package tictactoe.game;

import tictactoe.game.player.AIPlayer;
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
    if (currentPlayer() instanceof AIPlayer) {
      play(null);
    }
  }

  @Override
  public void play(Coordinate coordinate) {
    if (currentSymbol == X) {
      coordinate = playerX.makeMove(board, currentSymbol, coordinate);
    }
    else {
      coordinate = playerO.makeMove(board, currentSymbol, coordinate);
    }
    userInterface.refresh(coordinate, currentSymbol);
    currentSymbol = currentSymbol.flip();
    sendMessage();
    if (!board.isGameOver() && currentPlayer() instanceof AIPlayer) {
      play(null);
    }
  }

  private void sendMessage() {
    userInterface.displayMessage(currentSymbol + " - Make your Move");
    if (board.checkWon(X)) {
      endGame("X has Won!!");
    }
    else if (board.checkWon(O)) {
      endGame("O has Won!!");
    }
    else if (board.checkDraw()) {
      endGame("The Match is a Draw.");
    }
  }

  private void endGame(String message) {
    userInterface.displayMessage(message);
    userInterface.freezeBoard();
  }

  private Player currentPlayer() {
    if (currentSymbol == X) {
      return playerX;
    }
    return playerO;
  }
}
