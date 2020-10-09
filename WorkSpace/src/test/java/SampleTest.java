import org.junit.*;
import static org.junit.Assert.*;

public class SampleTest {
    @Before
    public void setup() {
        System.out.println("setup");
    }

    @After
    public void teardown() {
        System.out.println("teardown");
    }

    @Test
    public void Case1() {
        System.out.println("Case 1");
        assertEquals("Case 1", "Case 1");
    }

    @Test
    public void Case2() {
        System.out.println("Case 2");
        assertEquals("Case 2", "Case 1");
    }
}
