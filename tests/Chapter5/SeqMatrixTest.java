package Chapter5;

import org.junit.Before;
import org.junit.Test;

public class SeqMatrixTest {
    SeqMatrix seqMatrix;
    Triple[] triples={new Triple(4,2,50), new Triple(0,4,11),new Triple(0,2,17),new Triple(1,1,20),
            new Triple(3,0,19),new Triple(3,2,36),new Triple(3,1,28)
            };

    @Before
    public void setUp() throws Exception {
        seqMatrix = new SeqMatrix(5,6,triples);
    }

    @Test
    public void testPrintMatrix(){
        seqMatrix.printMatrix();
    }

    @Test
    public void testAdd(){
        Triple[] triples={new Triple(1,2,10), new Triple(2,4,11),new Triple(3,2,17),new Triple(1,1,20),
                new Triple(3,0,5),new Triple(3,2,6),new Triple(4,1,28)
        };
//        System.out.println("以下两个矩阵相加：");
        seqMatrix.printMatrix();
        SeqMatrix seqMatrix2 = new SeqMatrix(5,6,triples);
        seqMatrix2.printMatrix();
        seqMatrix.add(seqMatrix2);
        System.out.println("结果为：");
        seqMatrix.printMatrix();
    }

    @Test
    public void testTranspose(){
//        System.out.println("原矩阵：");
        seqMatrix.printMatrix();
        System.out.println("转置后：");
        seqMatrix.transpose().printMatrix();
    }
}
