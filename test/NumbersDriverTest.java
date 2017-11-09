import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class NumbersDriverTest {

    private NumbersDriver driver;

    private NumbersDriver.TestHook sampleTestObj;

    private List<String> valid_integers;

    private List<String> ambiguous_integers;

    @Before
    public void setUp() {
        driver = new NumbersDriver();
        sampleTestObj = driver.new TestHook();
        valid_integers = new ArrayList<>();
        valid_integers.add("    _  _     _  _  _  _  _ ");
        valid_integers.add("  | _| _||_||_ |_   ||_||_|");
        valid_integers.add("  ||_  _|  | _||_|  ||_| _|");
        ambiguous_integers = new ArrayList<>();
        ambiguous_integers.add("    _  _  _  _  _  _     _ ");
        ambiguous_integers.add("|_||_|| || ||_   |  |  ||  ");
        ambiguous_integers.add("  | _||_||_||_|  |  |  | _|");
    }

    @Test
    public void validIntegersTest() throws NumbersException {
        assertEquals(sampleTestObj.result(driver, valid_integers), "123456789");
    }

    @Test
    public void ambiguousIntegersTest() {
        try {
            sampleTestObj.result(driver, ambiguous_integers);
        }
        catch (NumbersException ne) {
            assertThat(ne.toString(), is("AMBIGUOUS: More than one solution was found"));
        }
    }
}