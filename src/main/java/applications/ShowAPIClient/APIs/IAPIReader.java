package applications.ShowAPIClient.APIs;

import shared.show.Show;

import java.util.ArrayList;

/**
 * Created by Maiko on 31-5-2017.
 */
public interface IAPIReader {

    ArrayList<Show> getShow(String request);

    ArrayList<Show> searchShow(String request);
}
