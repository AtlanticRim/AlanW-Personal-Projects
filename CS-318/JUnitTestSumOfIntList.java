package homework;
import static org.junit.Assert.*;
import org.junit.Test;

public class JUnitTestSumOfIntList {

    @Test
    public void test1() {
        int[] test1List = {1, 2, 3, 4, 5};
        assertEquals(15, SumOfIntList.sumOfIntList(test1List));
        
    }
    
}
