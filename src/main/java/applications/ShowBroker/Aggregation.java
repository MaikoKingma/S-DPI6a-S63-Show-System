package applications.ShowBroker;

import shared.message.ShowAPIReply;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maiko on 17-5-2017.
 */
public class Aggregation {
    private int id;
    private int expectedReplies;
    private String corrolationId;
    private List<ShowAPIReply> replies;

    public Aggregation(int id, int expectedReplies, String corrolationId) {
        this.expectedReplies = expectedReplies;
        this.id = id;
        this.corrolationId = corrolationId;
        replies = new ArrayList<>();
    }

    public int getExpectedReplies() {
        return expectedReplies;
    }

    public int getId() {
        return id;
    }

    public String getCorrolationId() {
        return corrolationId;
    }

    public int getReceivedReplies() {
        return replies.size();
    }

    public void addShowAPIReply(ShowAPIReply reply) {
        replies.add(reply);
    }

    public boolean repliesReceived() {
        if (replies.size() == expectedReplies) {
            return true;
        }
        return false;
    }

    public ShowAPIReply getBestReply() {
        //ToDo
        return replies.get(0);
    }
}
