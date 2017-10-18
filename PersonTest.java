package sprint2;

import junit.framework.*;
import sprint2.*;
import org.junit.Test;

    public class PersonTest {
        
        Person mall = new isKund("personnum","namn");
        
        Person test1 = new isKund("9510171234","namn");
        Person test2 = new isKund("9510171234","NAMN");
        Person test3 = new isKund("9510171234","Namn");
        Person test4 = new isKund("9510171234","Ett Namn");

        @Test
        public final void compareNamnTest(){
            TestCase.assertTrue(mall.compareNamn("namn"));
            
            TestCase.assertTrue(test1.compareNamn("Namn"));
            TestCase.assertTrue(test2.compareNamn("naMN"));
            TestCase.assertTrue(test3.compareNamn(" nAmN  "));
            TestCase.assertTrue(test4.compareNamn(" ett namN   "));
            
        }
        
        
        @Test
        public final void comparePersonnummerTest(){
            
            TestCase.assertTrue(mall.comparePersonnummer("personnum"));
            
            TestCase.assertTrue(test1.comparePersonnummer("951017-1234   "));
            TestCase.assertTrue(test2.comparePersonnummer("  199510171234"));
            TestCase.assertTrue(test3.comparePersonnummer("19951017-1234"));
            TestCase.assertTrue(test3.comparePersonnummer("19951017-1234      "));
        }
}
