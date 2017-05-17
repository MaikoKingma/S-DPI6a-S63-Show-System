package applications.ShowBroker;


import shared.message.ShowRequest;
import javax.jms.Destination;

/**
 * Created by Maiko on 17-5-2017.
 */
public class Request {
    private String corrolationId;
    private ShowRequest showRequest;
    private Destination replyTo;

    public Request(String corrolationId, ShowRequest showRequest, Destination replyTo) {
        this.corrolationId = corrolationId;
        this.showRequest = showRequest;
        this.replyTo = replyTo;
    }

    public String getCorrolationId() {
        return corrolationId;
    }

    public ShowRequest getShowRequest() {
        return showRequest;
    }

    public Destination getReplyTo() {
        return replyTo;
    }
}
