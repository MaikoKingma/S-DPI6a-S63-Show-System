package applications.ShowClient.DAO;

import shared.show.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Maiko on 31-5-2017.
 */
public class ShowDAOCol implements IShowDAO{

    private CopyOnWriteArrayList<Show> shows = new CopyOnWriteArrayList<>();
    int Id = 0;

    @Override
    public void create(Show show) {
        show.setClientId(Id);
        shows.add(show);
        Id++;
        System.out.println("new show: " + show.getClientId() + " - " + show.getName());
    }

    @Override
    public void edit(Show show) {
        if (show.getClientId() == null)
            return;

        for (int i = 0; i < shows.size(); i++)
        {
            if (Objects.equals(shows.get(i).getClientId(), show.getClientId()))
            {
                shows.set(i, show);
                break;
            }
        }
    }

    @Override
    public void remove(Show show) {
        shows.remove(show);
        System.out.println("Show removed: " + show.getClientId() + " - " + show.getName());
    }

    @Override
    public Show findById(Object id) {
        if(!(id instanceof Integer)){
            return null;
        }
        for (Show s : shows){
            if(s.getClientId() == id){
                return s;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Show> getAll() { return new ArrayList<>(shows); }

    @Override
    public List<Show> search(String query) {
        ArrayList<Show> array = new ArrayList<>();
        for (Show show : shows) {
            if (show.getName().toUpperCase().contains(query.toUpperCase()) || show.getDescription().toUpperCase().contains(query.toUpperCase())) {
                array.add(show);
            }
        }
        return array;
    }
}
