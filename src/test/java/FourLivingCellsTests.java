import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class FourLivingCellsTests {

    @Test
    @Parameters(method = "survivorCellValues")
    public void cells_with_three_neighbours_survive_and_dead_cells_with_three_neighbours_are_born(List<Cell> seedCells, List<Cell> resultCells) {
        GameOfLife gameOfLife = new GameOfLife();
        System.out.println("EXPECTED");
        for (Cell c :
                resultCells) {
            c.printCoordinates();
        }
        
        System.out.println("RESULT");
        for (Cell c :
                gameOfLife.runCycle(seedCells)) {
            c.printCoordinates();
        }
        assertTrue(resultCells.containsAll(gameOfLife.runCycle(seedCells)));
    }

    private Object[] survivorCellValues() {
        return new Object[] {
                new Object[]{
                        asList(new Cell(0, 0), new Cell(0, 2), new Cell(1, 1), new Cell(2, 0)),
                        asList(new Cell(0, 1), new Cell(1, 1), new Cell(1, 0))
                },
                new Object[]{
                        asList(new Cell(0, 0), new Cell(0, 1), new Cell(1, 0), new Cell(1, 1)),
                        asList(new Cell(0, 0), new Cell(0, 1), new Cell(1, 0), new Cell(1, 1)),
                },
                new Object[]{
                        asList(new Cell(0, 0), new Cell(0, 2), new Cell(2, 0), new Cell(2, 2)),
                        asList(),
                },
        };
    }

    @Test
    @Parameters(method = "bornCellValues")
    public void dead_cells_with_three_living_neighbours_are_born(List<Cell> seedCells, List<Cell> resultCells) {
        GameOfLife gameOfLife = new GameOfLife();
        assertEquals(resultCells, gameOfLife.runCycle(seedCells));
    }


    private Object[] bornCellValues() {
        return new Object[] {
                new Object[]{
                        asList(new Cell(0,0), new Cell(0,2), new Cell(2,0)),
                        asList(new Cell(1,1))
                },
        };
    }
}
