import applications.ShowAPIClient.APIs.EpisoDateAPIReader;
import org.junit.*;

import javax.jms.ObjectMessage;

/**
 * Created by Maiko on 17-6-2017.
 */
public class EpisoDateAPIReaderTest {

    private EpisoDateAPIReader reader;

    public EpisoDateAPIReaderTest() { }

    @Before
    public void before() {
        reader = new EpisoDateAPIReader();
    }

    @Test
    public void testGetRequest() {
        try {
            Object result = reader.getShow("Arrow");
            Assert.assertNotNull(result);
        } catch (Exception e) {
            Assert.fail("Exception was thrown");
        }
    }
}
