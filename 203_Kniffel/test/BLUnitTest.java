
import bl.KniffelBL;
import bl.KniffelValue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthias
 */
public class BLUnitTest {
    
    private KniffelBL bl = new KniffelBL();
    
    public BLUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void testNurEinser() {
         int[][] tests = {
             {1, 1, 1, 1, 1}, {5},
             {1, 3, 1, 1, 1}, {4},
             {1, 1, 5, 4, 1}, {3},
             {1, 1, 2, 3, 2}, {2},
             {4, 6, 3, 1, 2}, {1},
             {1, 5, 1, 1, 2}, {3},
             {4, 2, 3, 4, 1}, {1},
             {1, 1, 1, 1, 1}, {2}
         };
         
         for (int i = 0; i < tests.length; i+=2) {
             int[] test = tests[i];
             int result = tests[i+1][0];
             assertEquals(bl.getPoints(KniffelValue.NurEinser, test), result);
         }
     }
}
