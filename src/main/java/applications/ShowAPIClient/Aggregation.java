package applications.ShowAPIClient;

import shared.message.ShowAPIRequest;

/**
 * Created by Maiko on 17-5-2017.
 */
public class Aggregation {
    private String corrolationId;
    private ShowAPIRequest showAPIRequest;
    private int aggregationId;

    public Aggregation(String corrolationId, ShowAPIRequest showAPIRequest, int aggregationId) {
        this.corrolationId = corrolationId;
        this.showAPIRequest = showAPIRequest;
        this.aggregationId = aggregationId;
    }

    public String getCorrolationId() {
        return corrolationId;
    }

    public void setCorrolationId(String corrolationId) {
        this.corrolationId = corrolationId;
    }

    public ShowAPIRequest getShowAPIRequest() {
        return showAPIRequest;
    }

    public void setShowAPIRequest(ShowAPIRequest showAPIRequest) {
        this.showAPIRequest = showAPIRequest;
    }

    public int getAggregationId() {
        return aggregationId;
    }

    public void setAggregationId(int aggregationId) {
        this.aggregationId = aggregationId;
    }
}
