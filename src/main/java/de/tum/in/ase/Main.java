package de.tum.in.ase;

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        Movie hiddenFiguresMovie = new Movie("tt4846340", "Hidden Figures",
                "Three ...", new String[] { "History", "Drama" }, 2016, "7.8");

        String jsonString = serialize(hiddenFiguresMovie);
        System.out.println(jsonString);

        Movie anotherHiddenFigureMovie = deserialize(jsonString);
        System.out.println(anotherHiddenFigureMovie);
    }

    // Serialize: Movie → JSON String
    public static String serialize(Movie movie) {
        JSONObject jsonObject = movie.toJson();
        return jsonObject.toString(4);  // pretty print
    }

    // Deserialize: JSON String → Movie
    public static Movie deserialize(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        return new Movie(jsonObject);
    }
}
