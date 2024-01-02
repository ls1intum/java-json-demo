package de.tum.in.ase;

import org.json.*;
import java.util.*;

public class Movie {
    private String imdbID;
    private String title;
    private String simplePlot;
    private String[] genres;
    private int year;
    private String rating;

    public Movie(String imdbID, String title, String simplePlot, String[] genres, int year, String rating) {
        this.imdbID = imdbID;
        this.title = title;
        this.simplePlot = simplePlot;
        this.genres = genres;
        this.year = year;
        this.rating = rating;
    }

    // Deserialize: JSON String → Movie
    public Movie(JSONObject jsonObject) {
        imdbID = jsonObject.getString("imdbID");
        title = jsonObject.getString("title");
        simplePlot = jsonObject.getString("simplePlot");
        JSONArray genreJsonArray = jsonObject.getJSONArray("genres");
        genres = new String[genreJsonArray.length()];
        for (int i = 0; i < genreJsonArray.length(); i++) {
            genres[i] = genreJsonArray.getString(i);
        }
        year = jsonObject.getInt("year");
        rating = jsonObject.getString("rating");
    }

    @Override
    public String toString() {
        return "Movie{" + "imdbID='" + imdbID + '\'' + ", title='" + title + '\''
                + ", simplePlot='" + simplePlot + '\'' + ", genres=" + Arrays.toString(genres) 
                + ", year=" + year + ", rating='" + rating + '\'' + '}';
    }

    //Serialize: Movie → JSON String
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("imdbID", imdbID);
        json.put("title", title);
        json.put("genres", List.of(genres));
        json.put("simplePlot", simplePlot);
        json.put("year", year);
        json.put("rating", rating);
        return json;
    }
}
