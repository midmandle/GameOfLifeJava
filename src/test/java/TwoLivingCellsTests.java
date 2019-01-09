import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TwoLivingCellsTests {
    @Test
    @Parameters(method = "cellValues")
    public void seeding_two_living_cells_returns_no_living_cells(List<Cell> seedCells) {
        GameOfLife gameOfLife = new GameOfLife();
        assertEquals(new ArrayList<Cell>(), gameOfLife.runCycle(seedCells));
    }

    private Object[] cellValues() {
        return new Object[] {
                new Object[]{asList(new Cell(0, 0), new Cell(0,1))},
                new Object[]{asList(new Cell(0, 0), new Cell(1,1))},
                new Object[]{asList(new Cell(0, 0), new Cell(2,2))},
        };
    }
}
