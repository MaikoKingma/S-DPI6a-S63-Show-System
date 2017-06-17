package applications.ShowAPIClient.APIs;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import shared.show.Show;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Maiko on 17-6-2017.
 */
public class EpisoDateAPIReader implements IAPIReader {

    public ArrayList<Show> getShow(String request) {
        getRequest("https://www.episodate.com/api/show-details?q=" + request);
        //ToDo
        return null;
    }

    public ArrayList<Show> searchShow(String request) {
        getRequest("https://www.episodate.com/api/search?q=" + request + "&page=1");
        //ToDo
        return null;
    }

    /**
    private String getRequest(String request) {
        System.out.println(request);
        String result = new String();

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet getRequest = new HttpGet(request);
            //getRequest.addHeader("accept", "application/json");
            HttpResponse response = httpClient.execute(getRequest);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(((response.getEntity().getContent()))));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = reader.readLine()) != null) {
                System.out.println(output);
                result += output;
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
