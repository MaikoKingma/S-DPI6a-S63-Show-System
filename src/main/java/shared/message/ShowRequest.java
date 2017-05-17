package shared.message;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Maiko on 23-4-2017.
 */
public class ShowRequest implements IMessage {
    private String request;
    private boolean isGuess = false;

    public ShowRequest() { }

    public ShowRequest(String request) {
        this.request = request;
    }

    public ShowRequest(String request, boolean isGuess) {
        this.request = request;
        this.isGuess = isGuess;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public boolean isGuess() {
        return isGuess;
    }

    public void setGuess(boolean guess) {
        isGuess = guess;
    }

    @Override
    public String getJson() {
        if (request.trim().length() <= 0) {
            throw new NullPointerException("request is not filled");
        }
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
        return "request=" + request + ' ' +
                " isGuess=" + isGuess;
    }
}
