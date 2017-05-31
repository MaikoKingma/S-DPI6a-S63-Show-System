package shared.message;

import com.google.gson.Gson;

/**
 * Created by Maiko on 23-4-2017.
 */
public abstract class MessageObject {
    public String getJson() {
        return new Gson().toJson(this);
    }
}
