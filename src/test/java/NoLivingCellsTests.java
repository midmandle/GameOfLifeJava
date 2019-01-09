import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class NoLivingCellsTests {
    @Test
    public void seeding_no_living_cells_return_no_living_cells() {
        GameOfLife gameOfLife = new GameOfLife();
        ArrayList<Cell> seedCells = new ArrayList<Cell>();
        assertEquals(new ArrayList<Cell>(), gameOfLife.runCycle(seedCells));
    }
}
