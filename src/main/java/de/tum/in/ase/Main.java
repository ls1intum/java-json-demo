package de.tum.in.ase;

import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        Movie theGodfatherMovie = new Movie("tt0068646", "The Godfather",
                "The ...", new String[] { "Crime", "Drama" }, 1972, "9.2");

        String jsonString = serialize(theGodfatherMovie);
        System.out.println(jsonString);

        Movie anotherGodfatherMovie = deserialize(jsonString);
        System.out.println(anotherGodfatherMovie);
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
