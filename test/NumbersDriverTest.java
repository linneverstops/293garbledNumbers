import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class NumbersDriverTest {

    private NumbersDriver driver;

    private NumbersDriver.TestHook sampleTestObj;

    private List<String> valid_integers;

    private List<String> ambiguous_integers;

    private List<String> multiple_garbled_integers;

    private List<String> match_integers;

    private List<String> not_long_enough_input;

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
        multiple_garbled_integers = new ArrayList<>();
        multiple_garbled_integers.add("    _  _  _     _     _  _ ");
        multiple_garbled_integers.add("|_| _|  ||_||_||_||_||_||_|");
        multiple_garbled_integers.add("|_||_   ||_||_||_|| ||_||_|");
        match_integers = new ArrayList<>();
        match_integers.add("    _  _  _  _  _  _  _  _ ");
        match_integers.add("|_||_||_||_||_||_||_||_||_|");
        match_integers.add("|_||_||_||_||_||_||_||_||_|");
        not_long_enough_input = new ArrayList<>();
        not_long_enough_input.add("    _  _  _  _  _  _  _  _ ");
        not_long_enough_input.add("|__||_||_||_||_||_||_|");
        not_long_enough_input.add("|_| _|  ||_||_||_||_||||_|");
    }

    @Test
    public void valid_Integers_Test() throws NumbersException {
        assertEquals(sampleTestObj.result(driver, valid_integers), "123456789");
    }

    @Test
    public void ambiguous_Integers_Test() {
        try {
            sampleTestObj.result(driver, ambiguous_integers);
        }
        catch (NumbersException ne) {
            assertThat(ne.toString(), is("AMBIGUOUS: More than one solution was found"));
        }
    }

    @Test
    public void multiple_Garbled_Integers_Test() {
        try {
            sampleTestObj.result(driver, multiple_garbled_integers);
        }
        catch (NumbersException ne) {
            assertThat(ne.toString(), is("FAILURE: More than one digit is garbled (Assumption 3 does not hold)"));
        }
    }

    @Test
    public void match_Integers_Test() throws NumbersException {
        assertEquals(sampleTestObj.result(driver, match_integers), "888888888");
    }

    @Test
    public void not_long_enough_input_Test() {
        try{
            sampleTestObj.result(driver, not_long_enough_input);
        }
        catch (NumbersException ne) {
            assertThat(ne.toString(), is("FAILURE: Input lines do not have length 27"));
        }
    }
}