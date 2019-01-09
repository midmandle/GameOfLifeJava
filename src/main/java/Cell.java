import java.util.List;
import java.util.Objects;

public class Cell {
    private final int coordinateX;
    private final int coordinateY;

    public Cell(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public boolean hasRightNeighbour(List<Cell> livingCells) {
        int rightSideXCoordinate = this.coordinateX + 1;
        int rightSideYCoordinate = this.coordinateY;

        for (Cell c : livingCells) {
            if (c.hasCoordinates(rightSideXCoordinate, rightSideYCoordinate))
                return true;
        }
        return false;
    }

    public boolean hasLeftNeighbour(List<Cell> livingCells) {
        int leftSideXCoordinate = this.coordinateX - 1;
        int leftSideYCoordinate = this.coordinateY;

        for (Cell c : livingCells) {
            if (c.hasCoordinates(leftSideXCoordinate, leftSideYCoordinate))
                return true;
        }
        return false;
    }

    public boolean hasTopNeighbour(List<Cell> livingCells) {
        int topSideXCoordinate = this.coordinateX;
        int topSideYCoordinate = this.coordinateY + 1;

        for (Cell c : livingCells) {
            if (c.hasCoordinates(topSideXCoordinate, topSideYCoordinate))
                return true;
        }
        return false;
    }

    public boolean hasBottomNeighbour(List<Cell> livingCells) {
        int bottomSideXCoordinate = this.coordinateX;
        int bottomSideYCoordinate = this.coordinateY - 1;

        for (Cell c : livingCells) {
            if (c.hasCoordinates(bottomSideXCoordinate, bottomSideYCoordinate))
                return true;
        }
        return false;
    }

    public boolean hasTopRightNeighbour(List<Cell> livingCells) {
        int topRightCornerXCoordinate = this.coordinateX + 1;
        int topRightCornerYCoordinate = this.coordinateY + 1;

        for (Cell c : livingCells) {
            if (c.hasCoordinates(topRightCornerXCoordinate, topRightCornerYCoordinate))
                return true;
        }
        return false;
    }

    public boolean hasBottomLeftNeighbour(List<Cell> livingCells) {
        int bottomLeftCornerXCoordinate = this.coordinateX - 1;
        int bottomLeftCornerYCoordinate = this.coordinateY - 1;

        for (Cell c : livingCells) {
            if (c.hasCoordinates(bottomLeftCornerXCoordinate, bottomLeftCornerYCoordinate))
                return true;
        }
        return false;
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
