package shared.message;

import shared.show.Show;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

/**
 * Created by Maiko on 23-4-2017.
 */
public class ShowReply implements IMessage {
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
    public String getJson() {
        //ToDo
        throw new NotImplementedException();
    }

    @Override
    public void fillFromJson(String json) {
        //ToDo
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        return "shows=" + shows.size();
    }
}
