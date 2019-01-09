import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class OneLivingCellTests {
    @Test
    @Parameters(method = "cellValues")
    public void seeding_one_living_cell_returns_no_living_cells(Cell ...cells) {
        GameOfLife gameOfLife = new GameOfLife();
        ArrayList<Cell> seedCells = new ArrayList<Cell>();
        assertEquals(new ArrayList<Cell>(), gameOfLife.runCycle(seedCells));
    }

    private Object[] cellValues() {
        return new Object[] {
                new Object[]{new Cell(0, 0)},
        };
    }
}
