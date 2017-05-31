package applications.ShowClient.DAO;

import shared.show.Show;

import java.util.List;

/**
 * Created by Maiko on 31-5-2017.
 */
public interface IShowDAO {

    void create(Show show);

    void edit(Show show);

    void remove(Show show);

    Show findById(Object id);

    List<Show> getAll();

    List<Show> search(String name);
}
