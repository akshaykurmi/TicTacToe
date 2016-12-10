package tictactoe.game;

public class Cell {
  private final Coordinate coordinate;
  private final Symbol symbol;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cell cell = (Cell) o;
    return coordinate.equals(cell.coordinate) && symbol == cell.symbol;
  }

  @Override
  public int hashCode() {
    int result = coordinate.hashCode();
    result = 31 * result + symbol.hashCode();
    return result;
  }
}
