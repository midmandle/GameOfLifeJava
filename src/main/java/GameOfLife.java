import java.util.*;

public class GameOfLife {

    private List<Cell> seedCells;

    public List<Cell> runCycle(List<Cell> seedCells) {
        this.seedCells = seedCells;
        return generateCycleOutput();
    }

    private List<Cell> generateCycleOutput() {
        List<Cell> births = identifyBirths();
        List<Cell> survivors = extractSurvivors();

        return mergeSurvivorsAndBirths(survivors, births);
    }

    private List<Cell> identifyBirths(){
        List<Cell> births = new ArrayList<Cell>();
        Map<Cell, Integer> commonNeighbours = identifyCommonNeighbours();
        for (Cell c : commonNeighbours.keySet()) {
            if (isToBeBorn(c, commonNeighbours)) {
                births.add(c);
            }
        }
        return births;
    }


    private Map<Cell, Integer> identifyCommonNeighbours() {
        Map<Cell, Integer> commonNeighbours = new HashMap<>();
        for (Cell c : this.seedCells) {
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

    private boolean isToBeBorn(Cell queryCell, Map<Cell, Integer> commonNeighbours) {
        return commonNeighbours.get(queryCell) == 3;
    }

    private List<Cell> extractSurvivors() {
        List<Cell> survivors = new ArrayList<Cell>();
        for(Cell c: this.seedCells) {
            if(isSurvivor(c))
                survivors.add(c);
        }
        return survivors;
    }

    private boolean isSurvivor(Cell queryCell) {
        return hasTwoLivingNeighbours(queryCell) || hasThreeLivingNeighbours(queryCell);
    }

    private boolean hasTwoLivingNeighbours(Cell queryCell) {
        return determineNumberOfLivingNeighbours(queryCell) == 2;
    }

    private boolean hasThreeLivingNeighbours(Cell queryCell) {
        return determineNumberOfLivingNeighbours(queryCell) == 3;
    }

    private Integer determineNumberOfLivingNeighbours(Cell cellWithNeighbours) {
        Integer numberOfLivingNeighbours = 0;
        List<Cell> cellNeighbours = cellWithNeighbours.determineNeighbours();

        for (Cell c: cellNeighbours) {
            numberOfLivingNeighbours += countIfLiving(c);
        }

        return numberOfLivingNeighbours;
    }

    private Integer countIfLiving(Cell cellToCheck){
        if (isLivingCell(cellToCheck))
            return 1;
        return 0;
    }

    private boolean isLivingCell(Cell cellToCheck) {
        return this.seedCells.contains(cellToCheck);
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
