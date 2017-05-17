package shared.message;

import shared.show.Show;

import java.util.*;

/**
 * Created by Maiko on 23-4-2017.
 */
public class ShowReply extends MessageObject {
    private List<Show> shows;

    public ShowReply() { }

    public ShowReply(ArrayList<Show> shows) {
        this.shows = shows;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }

    public void addShow(Show show) {
        if (shows == null) {
            shows = new ArrayList<>();
        }
        shows.add(show);
    }

    @Override
    public String toString() {
        return "shows=" + shows.size();
    }
}
