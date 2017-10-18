package sprint2;

import java.time.LocalDate;
import junit.framework.*;
import sprint2.*;
import org.junit.Test;

public class DatabasTest {

    Databas test = new Databas();
    String[] mall = {"personnummer", "namn"};
    LocalDate datum = LocalDate.now();

    @Test
    public final void addPerson() {
        Person willwork = new isKund("", "");
        Person wontwork = null;

        TestCase.assertNull(wontwork);
        TestCase.assertNotNull(willwork);
    }

    @Test
    public final void makePerson() {

        LocalDate before = datum.minusYears(2);
        LocalDate after = datum.minusMonths(4);
        LocalDate yearAgoExact = datum.minusYears(1);
        LocalDate future = datum.plusYears(1);

        TestCase.assertNotNull(test.makePerson(mall, before));
        TestCase.assertTrue(test.makePerson(mall, before) instanceof beenKund);
        TestCase.assertTrue(test.makePerson(mall, after) instanceof isKund);

        TestCase.assertNull(test.makePerson(mall, future));
        TestCase.assertTrue(test.makePerson(mall, yearAgoExact) instanceof beenKund);
    }
}
