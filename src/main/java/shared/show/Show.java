package shared.show;

import java.util.*;

/**
 * Created by Maiko on 23-4-2017.
 */
public class Show implements IShow {
    private Integer clientId;

    private Calendar requestDate;
    private Status status;
    private Episode countdown;
    private List<Episode> episodes;
    private String name;
    private String source;
    private String description;
    private String descriptionSource;
    private Calendar startDate;
    private Calendar endDate = null;
    private String country;
    private int runTime;
    private String network;
    private String youtubeLink;
    private String imagePath;
    private String imageThumbnailPath;
    private double rating;
    private int ratingCount;
    private List<String> genres;
    private List<String> pictures;

    public Show() { }

    public Show(Calendar requestDate, Status status, Episode countdown, ArrayList<Episode> episodes, String name, String source, String description, String descriptionSource, Calendar startDate, Calendar endDate, String country, int runTime, String network, String youtubeLink, String imagePath, String imageThumbnailPath, double rating, int ratingCount, ArrayList<String> genres, ArrayList<String> pictures) {
        this.requestDate = requestDate;
        this.status = status;
        this.countdown = countdown;
        this.episodes = episodes;
        this.name = name;
        this.source = source;
        this.description = description;
        this.descriptionSource = descriptionSource;
        this.startDate = startDate;
        this.endDate = endDate;
        this.country = country;
        this.runTime = runTime;
        this.network = network;
        this.youtubeLink = youtubeLink;
        this.imagePath = imagePath;
        this.imageThumbnailPath = imageThumbnailPath;
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.genres = genres;
        this.pictures = pictures;
    }

    public Calendar getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Calendar requestDate) {
        this.requestDate = requestDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Episode getCountdown() {
        return countdown;
    }

    public void setCountdown(Episode countdown) {
        this.countdown = countdown;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }

    public void addEpisode(Episode episode) {
        if (episodes == null) {
            episodes = new ArrayList<>();
        }
        episodes.add(episode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionSource() {
        return descriptionSource;
    }

    public void setDescriptionSource(String descriptionSource) {
        this.descriptionSource = descriptionSource;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageThumbnailPath() {
        return imageThumbnailPath;
    }

    public void setImageThumbnailPath(String imageThumbnailPath) {
        this.imageThumbnailPath = imageThumbnailPath;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public void addGenre(String genre) {
        if (genres == null) {
            genres = new ArrayList<>();
        }
        genres.add(genre);
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<String> pictures) {
        this.pictures = pictures;
    }

    public void addPicture(String picturePath) {
        if (pictures == null) {
            pictures = new ArrayList<>();
        }
        pictures.add(picturePath);
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}
