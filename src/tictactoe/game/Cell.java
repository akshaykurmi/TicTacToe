package tictactoe.game;

public class Cell {
  private final Coordinate coordinate;
  private Symbol symbol;

  public Cell(Coordinate coordinate, Symbol symbol) {
    this.coordinate = coordinate;
    this.symbol = symbol;
  }

  boolean isSymbol(Symbol symbol) {
    return this.symbol == symbol;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }
}
