package shared.message;

import com.google.gson.Gson;

/**
 * Created by Maiko on 23-4-2017.
 */
public abstract class MessageObject {

    /**
     * Parses the MessageObject to as JSON string
     */
    public String getJson() {
        return new Gson().toJson(this);
    }
}
