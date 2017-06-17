package applications.ShowAPIClient.APIs;

import com.google.gson.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import shared.show.*;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * Created by Maiko on 17-6-2017.
 */
public class EpisoDateAPIReader implements IAPIReader {

    public final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
     * Sends a get request to the requested url
     * @param request requested url
     * @return returns the server reply (Json)
     */
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

    /**
     * Translates the json string to tvShow objects
     */
    private ArrayList<Show> jsonToShows(String json) {
        ArrayList<Show> shows = new ArrayList<>();
        try {
            //JsonObject with all show properties
            JsonObject jShow = new JsonParser().parse(json).getAsJsonObject().getAsJsonObject("tvShow");
            Gson gson = new Gson();

            Show show = new Show();
            show.setRequestDate(Calendar.getInstance());
            show.setStatus(Status.valueOf(jShow.get("status").toString()));
            show.setCountdown(jsonToEpisode(jShow.get("countdown").getAsJsonObject()));

            ArrayList<Episode> episodes = new ArrayList<>();
            Iterator<JsonElement> episodeIterator = jShow.get("episodes").getAsJsonArray().iterator();
            while (episodeIterator.hasNext()) {
                Episode episode = jsonToEpisode(episodeIterator.next().getAsJsonObject());
                if (episode != null)
                    episodes.add(episode);
            }

            show.setEpisodes(episodes);
            show.setName(jShow.get("name").toString());
            show.setSource(jShow.get("url").toString());
            show.setDescription(jShow.get("description").toString());
            show.setDescriptionSource(jShow.get("description_source").toString());

            //Parse start and endDate to calender objects
            try {
                Calendar tempCal = Calendar.getInstance();
                tempCal.setTime(sdf.parse(jShow.get("start_date").toString()));
                show.setStartDate(tempCal);

                //End date can be null if the show hasn't ended yet
                String endDate = jShow.get("end_date").toString();
                if (endDate.equals("null")) {
                    show.setEndDate(null);
                }
                else {
                    tempCal.setTime(sdf.parse(endDate));
                    show.setEndDate(tempCal);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            show.setCountry(jShow.get("country").toString());
            show.setRunTime(Integer.parseInt(jShow.get("runtime").toString()));
            show.setNetwork(jShow.get("youtubeLink").toString());
            show.setImagePath(jShow.get("image_path").toString());
            show.setImageThumbnailPath(jShow.get("image_thumbnail_path").toString());
            show.setRating(Double.parseDouble(jShow.get("rating").toString()));
            show.setRatingCount(Integer.parseInt(jShow.get("rating_count").toString()));
            show.setGenres(gson.fromJson(jShow.get("genres").toString(), String[].class));
            show.setPictures(gson.fromJson(jShow.get("pictures").toString(), String[].class));

            shows.add(show);
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
        return shows;
    }

    private Episode jsonToEpisode(JsonObject jEpisode) {
        Episode episode = new Episode();
        episode.setSeasonNr(Integer.parseInt(jEpisode.get("season").toString()));
        episode.setEpisodeNr(Integer.parseInt(jEpisode.get("episode").toString()));
        episode.setName(jEpisode.get("name").toString());
        try {
            Calendar tempCal = Calendar.getInstance();
            tempCal.setTime(sdf.parse(jEpisode.get("air_date").toString()));
            episode.setAirDate(tempCal);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return episode;
    }
}
