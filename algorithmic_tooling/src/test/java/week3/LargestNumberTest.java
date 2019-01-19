package week3;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LargestNumberTest {

    @Test
    public void largestNumber() {
        assertEquals("22222", LargestNumber.largestNumber(new String[]{"2222", "2"}));
        assertEquals("221", LargestNumber.largestNumber(new String[]{"21", "2"}));
        assertEquals("212221212", LargestNumber.largestNumber(new String[]{"212", "212221"}));
        assertEquals("212221212", LargestNumber.largestNumber(new String[]{"212221", "212"}));
        assertEquals("97978977", LargestNumber.largestNumber(new String[]{"97", "977", "978"}));
        assertEquals("221", LargestNumber.largestNumber(new String[]{"2", "21"}));
        assertEquals("99641", LargestNumber.largestNumber(new String[]{"9", "4", "6", "1", "9"}));
        assertEquals("923923", LargestNumber.largestNumber(new String[]{"23", "39", "92"}));
        assertEquals("9999999998888888888887777777776666666666555555554444444443333333333222222222111111111111111101010101010101010", LargestNumber.largestNumber(new String[]{"2","8","2","3","6","4","1","1","10","6","3","3","6","1","3","8","4","6","1","10","8","4","10","4","1","3","2","3","2","6","1","5","2","9","8","5","10","8","7","9","6","4","2","6","3","8","8","9","8","2","9","10","3","10","7","5","7","1","7","5","1","4","7","6","1","10","5","4","8","4","2","7","8","1","1","7","4","1","1","9","8","6","5","9","9","3","7","6","3","10","8","10","7","2","5","1","1","9","9","5"}));
        assertEquals("2922902322222120", LargestNumber.largestNumber(new String[]{"23", "290", "2", "21", "20", "292" , "222"}));
        assertEquals("222221", LargestNumber.largestNumber(new String[]{"22221", "2"}));
        assertEquals("222221", LargestNumber.largestNumber(new String[]{"2", "22221"}));
        assertEquals("10110", LargestNumber.largestNumber(new String[]{"10", "101"}));
        assertEquals("10110", LargestNumber.largestNumber(new String[]{"101", "10"}));
    }
}