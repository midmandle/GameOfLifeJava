import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
    public List<Cell> runCycle(List<Cell> seedCells) {
        List<Cell> resultCells = new ArrayList<Cell>();
        for(Cell c: seedCells) {
            if (isLivingCell(c.determineLeftNeighbour(), seedCells) && isLivingCell(c.determineRightNeighbour(), seedCells))
                resultCells.add(c);
            if (isLivingCell(c.determineTopNeighbour(), seedCells) && isLivingCell(c.determineBottomNeighbour(), seedCells))
                resultCells.add(c);
            if (isLivingCell(c.determineTopRightNeighbour(), seedCells) && isLivingCell(c.determineBottomLeftNeighbour(), seedCells))
                resultCells.add(c);
            if (isLivingCell(c.determineBottomRightNeighbour(), seedCells) && isLivingCell(c.determineTopLeftNeighbour(), seedCells))
                resultCells.add(c);
        }
        return resultCells;
    }

    public boolean isLivingCell(Cell cellToCheck, List<Cell> livingCells) {
        for (Cell c : livingCells) {
            if (c.equals(cellToCheck))
                return true;
        }
        return false;
    }
}
