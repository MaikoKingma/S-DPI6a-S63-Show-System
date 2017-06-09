package shared.show;

import java.util.Calendar;

/**
 * Created by Maiko on 23-4-2017.
 */
public class Episode implements IShow {
    private int seasonNr;
    private int episodeNr;
    private String name;
    private Calendar airDate;

    public Episode() { }

    public Episode(int seasonNr, int episodeNr, String name, Calendar airDate) {
        this.seasonNr = seasonNr;
        this.episodeNr = episodeNr;
        this.name = name;
        this.airDate = airDate;
    }

    public int getSeasonNr() {
        return seasonNr;
    }

    public void setSeasonNr(int seasonNr) {
        this.seasonNr = seasonNr;
    }

    public int getEpisodeNr() {
        return episodeNr;
    }

    public void setEpisodeNr(int episodeNr) {
        this.episodeNr = episodeNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getAirDate() {
        return airDate;
    }

    public void setAirDate(Calendar airDate) {
        this.airDate = airDate;
    }

    @Override
    public String toString() {
        return "S" + seasonNr +
                "E" + episodeNr +
                " " + name +
                " " + airDate;
    }
}
