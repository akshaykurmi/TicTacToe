package tictactoe.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static tictactoe.game.Coordinate.coordinate;
import static tictactoe.game.Symbol.*;

public class Board {
  private final List<Cell> grid;

  Board(int xDimension, int yDimension) {
    grid = new ArrayList<>();
    for (int i=0; i<xDimension; i++) {
      for (int j=0; j<yDimension; j++) {
        grid.add(new Cell(new Coordinate(i, j), NONE));
      }
    }
  }

  public Board(Board original) {
    grid = new ArrayList<>();
    grid.addAll(original.grid);
  }

  public void add(Cell cell) {
    grid.remove(new Cell(cell.getCoordinate(), NONE));
    grid.add(cell);
  }

  boolean checkDraw() {
    List<Coordinate> filteredGrid = filterGrid(cell -> !cell.isSymbol(NONE));
    return filteredGrid.size() >= 9 &&
           !checkWon(X) &&
           !checkWon(O);
  }

  public boolean checkWon(Symbol symbol) {
    List<Coordinate> filteredGrid = filterGrid(cell -> cell.isSymbol(symbol));
    for (int i=0; i<3; i++) {
      if (checkContains(filteredGrid, coordinate(0,i), coordinate(1,i), coordinate(2,i)) ||
          checkContains(filteredGrid, coordinate(i,0), coordinate(i,1), coordinate(i,2))) {
        return true;
      }
    }
    return checkContains(filteredGrid, coordinate(0, 0), coordinate(1, 1), coordinate(2, 2)) ||
           checkContains(filteredGrid, coordinate(0, 2), coordinate(1, 1), coordinate(2, 0));
  }

  private List<Coordinate> filterGrid(Predicate<Cell> predicate) {
    return grid.stream()
        .filter(predicate)
        .map(Cell::getCoordinate)
        .collect(Collectors.toList());
  }

  private boolean checkContains(List<Coordinate> filteredGrid, Coordinate... coordinates) {
    return Arrays.stream(coordinates)
                 .allMatch(filteredGrid::contains);
  }

  public List<Coordinate> getEmptyCoordinates() {
    return filterGrid(cell -> cell.isSymbol(NONE));
  }

  public boolean isGameOver() {
    return checkWon(X) || checkWon(O) || checkDraw();
  }
}
