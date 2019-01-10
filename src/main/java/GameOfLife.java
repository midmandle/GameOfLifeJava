import java.util.*;

public class GameOfLife {
    public List<Cell> runCycle(List<Cell> seedCells) {
        List<Cell> resultCells = new ArrayList<Cell>();
        Map<Cell, Integer> commonNeighbours = identifyCommonNeighbours(seedCells);
        for(Cell c: seedCells) {
            List<Cell> cellNeighbours = c.determineNeighbours();
            if (determineLivingNeighbours(cellNeighbours, seedCells).size() == 3)
                resultCells.add(c);
            if (determineLivingNeighbours(cellNeighbours, seedCells).size() == 2)
                resultCells.add(c);
        }

        for (Cell c : commonNeighbours.keySet()) {
            if (commonNeighbours.get(c) == 3 && !resultCells.contains(c)) {
                resultCells.add(c);
            }
        }
        return resultCells;
    }

    private Map<Cell, Integer> identifyCommonNeighbours(List<Cell> seedCells) {
        Map<Cell, Integer> commonNeighbours = new HashMap<>();
        for (Cell c : seedCells) {
            List<Cell> neighbours = c.determineNeighbours();
            for (Cell n : neighbours) {
                if(commonNeighbours.containsKey(n)) {
                    Integer neighbourCount = commonNeighbours.get(n);
                    commonNeighbours.put(n, neighbourCount + 1);
                } else {
                    commonNeighbours.put(n, 1);
                }
            }
        }
        return commonNeighbours;
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
