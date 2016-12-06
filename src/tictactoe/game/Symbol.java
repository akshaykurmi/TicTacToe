package tictactoe.game;

public enum Symbol {
  X,
  O,
  NONE;

  @Override
  public String toString() {
    if (this == X) return "X";
    if (this == O) return "O";
    return "";
  }
}
