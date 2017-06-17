package applications.ShowAPIClient.APIs;

import shared.show.Episode;
import shared.show.Show;
import shared.show.Status;

import java.util.*;

/**
 * Created by Maiko on 31-5-2017.
 */
public class FakerAPIReader implements IAPIReader {
    @Override
    public ArrayList<Show> getShow(String request) {
        return generateShow(request);
    }

    @Override
    public ArrayList<Show> searchShow(String request) {
        return generateShow(request);
    }

    private ArrayList<Show> generateShow(String request) {
        Calendar now = Calendar.getInstance();
        ArrayList<Episode> episodes = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            Calendar newDate = now;
            newDate.add(Calendar.DATE, i);
            episodes.add(new Episode(1, i, "Episode" + i, newDate));
        }
        return new ArrayList<Show>() {{
            add(new Show(
                    now,
                    Status.CANCELED_ENDED,
                    episodes.get(0),
                    episodes,
                    request + " (Fake)",
                    "FakerAPIReader",
                    request + " (Fake)",
                    "FakerAPIReader",
                    episodes.get(0).getAirDate(),
                    null,
                    "NL",
                    60,
                    "FakerAPIReader",
                    null,
                    null,
                    null,
                    5,
                    1,
                    new String[0],
                    new String[0]
            ));
        }};
    }
}
