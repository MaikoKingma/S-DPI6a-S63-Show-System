package shared.message;

/**
 * Created by Maiko on 23-4-2017.
 */
public interface IMessage {
    public String getJson();

    public void fillFromJson(String json);
}
