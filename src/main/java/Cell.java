import java.util.List;
import java.util.Objects;

public class Cell {
    private final int coordinateX;
    private final int coordinateY;

    public Cell(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
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

    private boolean hasCoordinates(int queryXCoordinate, int queryYCoordinate) {
        if ((this.coordinateX == queryXCoordinate) && (this.coordinateY == queryYCoordinate))
            return true;
        return false;
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
}
