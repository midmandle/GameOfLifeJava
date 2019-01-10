import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class FiveLivingCells {
    @Test
    @Parameters(method = "cellValues")
    public void cells_with_four_neighbours_die(List<Cell> seedCells, List<Cell> resultCells) {
        GameOfLife gameOfLife = new GameOfLife();
        assertTrue(resultCells.containsAll(gameOfLife.runCycle(seedCells)));
    }


    private Object[] cellValues() {
        return new Object[] {
                new Object[]{
                        asList(
                                new Cell(1, 0),
                                new Cell(0, 1),
                                new Cell(1, 1),
                                new Cell(2, 1),
                                new Cell(1, 2)
                        ),
                        asList(
                                new Cell(0, 0),
                                new Cell(1, 0),
                                new Cell(2, 0),
                                new Cell(0, 1),
                                new Cell(2, 1),
                                new Cell(0, 2),
                                new Cell(1, 2),
                                new Cell(2, 2)
                        )
                },
        };
    }
}
