package com.example.daltondoveandroidapp.utilities;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.TreeCodec;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import java.nio.charset.StandardCharsets;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Scanner;


public class NetworkUtils {

    // build movies URL from title input
    public static URL buildMoviesUrl(String search){
        String formattedTitle = search.replaceAll(" ", "+");
        String movieUrlString = "https://www.omdbapi.com/?t=" + formattedTitle + "&apikey=5a86fbce";

        URL movieUrl = null;
        try{
            movieUrl = new URL(movieUrlString);
        }catch(MalformedURLException e){
            e.printStackTrace();
        }
        return movieUrl;
    } // end of build

    public static String getResponseFromUrl(URL url) throws IOException{
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(); // getting the connection open
        try{
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A"); // delimiter for end of message
            boolean hasInput = scanner.hasNext();
            if(hasInput) return scanner.next(); // success
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            urlConnection.disconnect();
        }
        return null;
    } // end of get Resp

    public static ArrayList<String> parseMoviesJson(String moviesResponseString){

        ArrayList<String> movieData = new ArrayList<String>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(moviesResponseString);

            movieData.add("Title: " + rootNode.get("Title").asText());
            movieData.add("Year Released: " + rootNode.get("Year").asText());
            movieData.add("Rated: " + rootNode.get("Rated").asText());
            movieData.add("Runtime: " + rootNode.get("Runtime").asText());
            movieData.add("Genre: " + rootNode.get("Genre").asText());
            movieData.add("Director: " + rootNode.get("Director").asText());
            movieData.add("Actors: " + rootNode.get("Actors").asText());
            movieData.add("Plot: " + rootNode.get("Plot").asText());
            movieData.add("IMDb Rating " + rootNode.get("imdbRating").asText());
        }
        catch(Exception e){
            e.printStackTrace();
        }
            return movieData;
    }

} // end of class