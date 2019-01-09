import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
    public List<Cell> runCycle(List<Cell> seedCells) {
        List<Cell> resultCells = new ArrayList<Cell>();
        for(Cell c: seedCells) {
            if (c.hasLeftNeighbour(seedCells) && c.hasRightNeighbour(seedCells))
                resultCells.add(c);
        }
        return resultCells;
    }
}
