package shared.message;

/**
 * Created by Maiko on 23-4-2017.
 */
public class ShowRequest extends Message {
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
    public String toString() {
        return "request=" + request + ' ' +
                " isGuess=" + isGuess;
    }
}
