import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameOfLife {
    public List<Cell> runCycle(List<Cell> seedCells) {
        List<Cell> resultCells = new ArrayList<Cell>();
        for(Cell c: seedCells) {
            List<Cell> cellNeighbours = c.determineNeighbours();
            if (determineLivingNeighbours(cellNeighbours, seedCells).size() == 3)
                resultCells.add(c);
            if (determineLivingNeighbours(cellNeighbours, seedCells).size() == 2)
                resultCells.add(c);
        }
        return resultCells;
    }

    private List<Cell> determineLivingNeighbours(List<Cell> cellNeighbours, List<Cell> livingCells) {
        List<Cell> livingNeighbours = new ArrayList<Cell>();

        for (Cell c: cellNeighbours) {
            if (isLivingCell(c, livingCells))
                livingNeighbours.add(c);
        }

        return livingNeighbours;
    }

    public boolean isLivingCell(Cell cellToCheck, List<Cell> livingCells) {
        for (Cell c : livingCells) {
            if (c.equals(cellToCheck))
                return true;
        }
        return false;
    }
}
