package Chapter5;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedMatrixTest {
    LinkedMatrix linkedMatrix;
    Triple[] triples={new Triple(0,2,11),new Triple(0,4,17),new Triple(1,1,20),
                    new Triple(3,0,19),new Triple(3,2,36),new Triple(3,5,28),
                    new Triple(4,2,50)};
    @Before
    public void setUp() throws Exception {
        linkedMatrix=new LinkedMatrix(5,6,triples);
    }

    @Test
    public void testGetRows() {
        assertEquals(5,linkedMatrix.getRows());
    }

    @Test
    public void testGetColumns() {
        assertEquals(6,linkedMatrix.getColumns());
    }

    @Test
    public void testSet() {
        System.out.println("原矩阵:");
        linkedMatrix.printMatrix();
        linkedMatrix.set(4,2,100);
        System.out.println("将第4行第2列修改为100：");
        linkedMatrix.printMatrix();
    }

    @Test
    public void testSet2() {
        System.out.println("原矩阵:");
        linkedMatrix.printMatrix();
        linkedMatrix.set(new Triple(4,2,100));
        System.out.println("将第4行第2列修改为100：");
        linkedMatrix.printMatrix();
    }

    @Test
    public void testGet() {
        assertEquals(11,linkedMatrix.get(0,2));
    }

    @Test
    public void testToString1() {
        System.out.println("返回稀疏矩阵三元组行的单链表：\n"+linkedMatrix.toString());
    }

    @Ignore
    @Test
    public void testPrintMatrix() {
    }

    @Test
    public void testSetRowsColumns() {
        linkedMatrix.setRowsColumns(8,9);
        assertEquals(8,linkedMatrix.getRows());
        assertEquals(9,linkedMatrix.getColumns());
    }

    @Test
    public void testAddAll(){
         System.out.println("原矩阵:");
         linkedMatrix.printMatrix();
         Triple[] triples2={new Triple(0,2,-11),new Triple(0,4,-17),new Triple(2,3,51),
                        new Triple(3,0,10),new Triple(4,1,99)};
         LinkedMatrix linkedMatrix2=new LinkedMatrix(5,6,triples2);
         System.out.println("相加矩阵:");
         linkedMatrix2.printMatrix();
         linkedMatrix.addAll(linkedMatrix2);
         linkedMatrix.printMatrix();
    }

    @Test
    public void testEqual (){
        LinkedMatrix linkedMatrix2=new LinkedMatrix(5,6,triples);
        assertTrue(linkedMatrix.equals(linkedMatrix2));
    }
}