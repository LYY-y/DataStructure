package Chapter5;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    Matrix matrix;
    int[][] value={{1,2,3},{4,5,6,7,8},{9}};

    @Before
    public void setUp() throws Exception {
        matrix=new Matrix(3,4,value);
    }

    @Test
    public void testGetRows() {
        assertEquals(3,matrix.getRows());
    }

    @Test
    public void testGetColumns() {
        assertEquals(4,matrix.getColumns());
    }

    @Test
    public void testGet() {
        assertEquals(1,matrix.get(0,0));
    }

    @Test
    public void testSet() {
        matrix.set(2,3,10);
        System.out.println(matrix.toString());
    }

    @Ignore
    @Test
    public void toString1() {
    }

    @Test
    public void testSetRowsColumns() {
        matrix.setRowsColumns(2,2);
        System.out.println(matrix.toString());
    }
}