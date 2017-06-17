import applications.ShowAPIClient.APIs.EpisoDateAPIReader;
import org.junit.*;

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
        reader.getShow("Arrow");
    }
}
