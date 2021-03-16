package com.example.daltondoveandroidapp; // this line will be different for you

import android.content.Intent;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity; // in new Android studio version

import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;

import com.example.daltondoveandroidapp.utilities.NetworkUtils;

public class MainActivity extends AppCompatActivity {

    //  1: declare variables and import classes
    // Ctrl + space to get automatic import options
    private TextView mSearchResultsDisplay;
    private EditText mSearchTermEditText;
    private Button mSearchButton;
    private Button mResetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  2: connect variables to UI elements using R
        // connect with the visual elements in activity_main.xml
        mSearchResultsDisplay   = (TextView) findViewById(R.id.tv_display_text);
        mSearchTermEditText     = (EditText) findViewById(R.id.et_search_box);
        mSearchButton           = (Button) findViewById(R.id.search_button);
        mResetButton            = (Button) findViewById(R.id.reset_button);


        /*final String[] imdbTop10 = {"The Shawshank Redemption", "The Godfather", "The Godfather: Part II", "The Dark Knight", "12 Angry Men", "Schindler's List", "The Lord of the Rings: The Return of the King", "Pulp Fiction", "The Good, the Bad and the Ugly", "The Lord of the Rings: The Fellowship of the Ring"};
        for (String title : imdbTop10) {
            mSearchResultsDisplay.append("\n\n" + title);
        }*/

        mSearchResultsDisplay.setText("Enter movie title to search for in the IMDb!");
        final String defaultDisplayText = mSearchResultsDisplay.getText().toString();

        // responding to search button
        mSearchButton.setOnClickListener(
                new View.OnClickListener(){ // a unnamed object
                    //inner method def
                    public void onClick(View v){
                        //get search string from user
                        makeNetworkSearchQuery();
                    } // end of onClick method

                } // end of View.OnClickListener
        ); // end of setOnClickListener

        // responding to reset button
        mResetButton.setOnClickListener(
                new View.OnClickListener(){ // a unnamed object
                    //inner method def
                    public void onClick(View v){
                        // reset the text

                        Log.d("resetButton", "entered");
                        mSearchResultsDisplay.setText("Enter movie title to search for in the IMDb!");
                        mSearchTermEditText.setText("");
                    } // end of onClick method

                } // end of View.OnClickListener
        ); // end of setOnClickListener


    } // end of onCreate


    /* Networking related code begins */
    public void makeNetworkSearchQuery(){
        // get the search string
        String searchTerm = mSearchTermEditText.getText().toString();
        //reset the search results
        mSearchResultsDisplay.setText("Results : \n");
        // make the search - network
        new FetchNetworkData().execute(searchTerm);

    } // end of makeQuery

    // inner class
    public class FetchNetworkData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params){
            //get the search term
            if(params.length == 0) return null;
            String searchTerm = params[0];
            // get the Url
            URL searchUrl = NetworkUtils.buildMoviesUrl(searchTerm); // write class and method

            // get the response from the URl
            String responseString = null;
            try{
                responseString = NetworkUtils.getResponseFromUrl(searchUrl); //  write this method
            }catch(Exception e){
                e.printStackTrace();
            }
            return responseString;//
        } // end of doInBackground

        @Override
        protected void onPostExecute(String responseData){
            ArrayList<String> movieData = NetworkUtils.parseMoviesJson(responseData); //
            // display entries in GUI
            for(String entry: movieData){
                mSearchResultsDisplay.append("\n\n" + entry);
            }
        } // end of onPost
    } // end of inner class

    /* Networking related code ends */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //  inflate menu
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    } // end of onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int menuItemSelected = item.getItemId();
        if(menuItemSelected == R.id.menu_contact){
            //  react to menu Contact click
            Class destinationActivity = ContactActivity.class;
            // create an Intent that will launch this
            Intent startContactActivityIntent = new Intent(MainActivity.this, destinationActivity);
            // create intent to go to next page
            String msg = mSearchTermEditText.getText().toString();
            startContactActivityIntent.putExtra(Intent.EXTRA_TEXT, msg);

            startActivity(startContactActivityIntent);
            Log.d("info", "Contact Activity launched");
        } // end if
        return true;

    } // end of onOptionsItemSe..

} // end of class
