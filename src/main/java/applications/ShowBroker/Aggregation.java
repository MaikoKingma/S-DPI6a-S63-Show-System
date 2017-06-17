package applications.ShowBroker;

import shared.message.*;
import shared.show.Show;

import java.util.*;

/**
 * Created by Maiko on 17-5-2017.
 * This Class keeps track of the send and received message using the scatter-gather patern.
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

    public ShowReply getBestReply() {
        ShowReply showReply = new ShowReply();
        for (ShowAPIReply reply : replies) {
            for (Show show : reply.getShows()) {
                showReply.addShow(show);
            }
        }
        return showReply;
    }
}
