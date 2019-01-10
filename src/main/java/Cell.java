import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Cell {
    private final int coordinateX;
    private final int coordinateY;

    public Cell(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public void printCoordinates() {
        System.out.println(this.coordinateX + " " + this.coordinateY);
    }

    public Cell determineLeftNeighbour() {
        return new Cell(this.coordinateX -1, this.coordinateY);
    }

    public Cell determineRightNeighbour(){
        return new Cell(this.coordinateX +1, this.coordinateY);
    }

    public Cell determineBottomNeighbour(){
        return new Cell(this.coordinateX, this.coordinateY-1);
    }

    public Cell determineTopNeighbour() {
        return new Cell(this.coordinateX, this.coordinateY+1);
    }

    public Cell determineBottomLeftNeighbour() {
        return new Cell(this.coordinateX -1, this.coordinateY -1);
    }

    public Cell determineBottomRightNeighbour() {
        return new Cell(this.coordinateX +1, this.coordinateY -1);
    }

    public Cell determineTopLeftNeighbour() {
        return new Cell(this.coordinateX -1, this.coordinateY +1);
    }

    public Cell determineTopRightNeighbour() {
        return new Cell(this.coordinateX + 1, this.coordinateY +1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return coordinateX == cell.coordinateX &&
                coordinateY == cell.coordinateY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateX, coordinateY);
    }

    public List<Cell> determineNeighbours() {
        return new ArrayList<Cell>(){
            {
                add(determineBottomLeftNeighbour());
                add(determineBottomNeighbour());
                add(determineBottomRightNeighbour());
                add(determineLeftNeighbour());
                add(determineRightNeighbour());
                add(determineTopLeftNeighbour());
                add(determineTopNeighbour());
                add(determineTopRightNeighbour());
            }
        };
    }
}
