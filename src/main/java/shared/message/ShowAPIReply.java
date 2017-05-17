package shared.message;

import shared.show.Show;

import java.util.*;

/**
 * Created by Maiko on 23-4-2017.
 */
public class ShowAPIReply extends Message {
    private List<Show> shows;
    private boolean success;

    public ShowAPIReply() {
        success = false;
    }

    public ShowAPIReply(ArrayList<Show> shows) {
        this.shows = shows;
        if (shows.size() > 0) {
            success = true;
        } else {
            success = false;
        }
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "shows=" + shows.size() +
                " success=" + success;
    }
}
