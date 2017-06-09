package applications.ShowClient.DAO;

import shared.show.Show;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maiko on 31-5-2017.
 */
public interface IShowDAO {

    void create(Show show);

    void edit(Show show);

    void remove(Show show);

    Show findById(Object id);

    ArrayList getAll();

    List<Show> search(String name);
}
