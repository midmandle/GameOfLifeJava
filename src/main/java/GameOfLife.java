import java.util.*;

public class GameOfLife {
    public List<Cell> runCycle(List<Cell> seedCells) {
        return generateCycleOutput(seedCells);
    }

    private List<Cell> generateCycleOutput(List<Cell> seedCells) {
        List<Cell> births = identifyBirths(seedCells);
        List<Cell> survivors = extractSurvivors(seedCells);

        return mergeSurvivorsAndBirths(survivors, births);
    }

    private List<Cell> identifyBirths(List<Cell> seedCells){
        List<Cell> births = new ArrayList<Cell>();
        Map<Cell, Integer> commonNeighbours = identifyCommonNeighbours(seedCells);
        for (Cell c : commonNeighbours.keySet()) {
            if (commonNeighbours.get(c) == 3) {
                births.add(c);
            }
        }
        return births;
    }

    private Map<Cell, Integer> identifyCommonNeighbours(List<Cell> seedCells) {
        Map<Cell, Integer> commonNeighbours = new HashMap<>();
        for (Cell c : seedCells) {
            commonNeighbours = populateCommonNeighbourMap(commonNeighbours, c);
        }
        return commonNeighbours;
    }

    private Map<Cell, Integer> populateCommonNeighbourMap(Map<Cell, Integer> commonNeighbours, Cell cellToMap) {
        List<Cell> neighbours = cellToMap.determineNeighbours();
        for (Cell n : neighbours) {
            commonNeighbours = incrementOrInitialiseNeighbourOnMap(commonNeighbours, n);
        }
        return commonNeighbours;
    }

    private Map<Cell, Integer> incrementOrInitialiseNeighbourOnMap(Map<Cell, Integer> commonNeighbours, Cell neighbourToMap) {
        if(commonNeighbours.containsKey(neighbourToMap)) {
            Integer neighbourCount = commonNeighbours.get(neighbourToMap);
            commonNeighbours.put(neighbourToMap, neighbourCount + 1);
        } else {
            commonNeighbours.put(neighbourToMap, 1);
        }
        return commonNeighbours;
    }


    private List<Cell> extractSurvivors(List<Cell> seedCells) {
        List<Cell> survivors = new ArrayList<Cell>();
        for(Cell c: seedCells) {
            if(isSurvivor(c, seedCells))
                survivors.add(c);
        }
        return survivors;
    }

    private boolean isSurvivor(Cell queryCell, List<Cell> seedCells) {
        return hasTwoLivingNeighbours(queryCell, seedCells) || hasThreeLivingNeighbours(queryCell, seedCells);
    }

    private boolean hasTwoLivingNeighbours(Cell queryCell, List<Cell> seedCells) {
        return determineNumberOfLivingNeighbours(queryCell, seedCells) == 2;
    }

    private boolean hasThreeLivingNeighbours(Cell queryCell, List<Cell> seedCells) {
        return determineNumberOfLivingNeighbours(queryCell, seedCells) == 3;
    }

    private Integer determineNumberOfLivingNeighbours(Cell cellWithNeighbours, List<Cell> livingCells) {
        Integer numberOfLivingNeighbours = 0;
        List<Cell> cellNeighbours = cellWithNeighbours.determineNeighbours();

        for (Cell c: cellNeighbours) {
            numberOfLivingNeighbours += countIfLiving(c, livingCells);
        }

        return numberOfLivingNeighbours;
    }

    private Integer countIfLiving(Cell cellToCheck, List<Cell> livingCells){
        if (isLivingCell(cellToCheck, livingCells))
            return 1;
        return 0;
    }

    private boolean isLivingCell(Cell cellToCheck, List<Cell> livingCells) {
        return livingCells.contains(cellToCheck);
    }

    private List<Cell> mergeSurvivorsAndBirths(List<Cell> resultCells, List<Cell> births) {
        for (Cell c : births) {
            resultCells = addCellToListIfNotExists(resultCells, c);
        }
        return resultCells;
    }

    private List<Cell> addCellToListIfNotExists(List<Cell> resultCells, Cell c) {
        if (!resultCells.contains(c))
            resultCells.add(c);
        return resultCells;
    }
}
