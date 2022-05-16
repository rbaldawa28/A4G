/**
 * Page for additional information (video & leads to locations for resources/adoption) for the 5th recommended pet.
 * @author rbaldawa28, amchong, ibateman
 */

package com.example.petpicker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Option5 extends YouTubeBaseActivity {

    /**
     * YouTube Data API v3 key
     */
    String apiKey = "AIzaSyCqOuV_zZb_nJ5J3205eJ4frQSS2_ZGs7w";

    /**
     * dog, cat, hamster, bird, and fish video IDs
     */
    String dogId = "rpzD_Hrrmj0";
    String catId = "MpJXKs_hglY";
    String hamsterId = "08NT5qfmZec";
    String birdId = "eRk0ax91YhA";
    String fishId = "mGmIvhtIM9k";

    /**
     * ID of YouTube video for the 5th recommended pet
     */
    String currentId;

    /**
     * YouTube video display within app page
     */
    YouTubePlayerView youTubePlayerView;

    /**
     * Information (video and leads to map) about 5th recommended pet when activity is opened
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        MaterialButton map = (MaterialButton) findViewById(R.id.vOptions);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        SharedPreferences sp = getSharedPreferences("UserPrefs",MODE_PRIVATE);
        Pets options = new Pets(sp);

        /**
         * Assigns the currentID to the 5th recommended pet
         */
        if(options.getFifth().equals("Dog"))
        {
            currentId = dogId;
        }
        else if(options.getFifth().equals("Cat"))
        {
            currentId = catId;
        }
        else if(options.getFifth().equals("Hamster"))
        {
            currentId = hamsterId;
        }
        else if(options.getFifth().equals("Bird"))
        {
            currentId = birdId;
        }
        else if(options.getFifth().equals("Fish"))
        {
            currentId = fishId;
        }

        /**
         * Displays and plays the YouTube video
         */
        youTubePlayerView = findViewById(R.id.youtube);

        YouTubePlayer.OnInitializedListener listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(currentId,0);
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getApplicationContext(),"video player failed", Toast.LENGTH_SHORT).show();
            }
        };
        youTubePlayerView.initialize(apiKey,listener);
    }

    /**
     * Opens the map activity that corresponds with the 5th recommended pet
     */
    public void openMap()
    {
        Intent intent = new Intent(this, Map5.class);
        startActivity(intent);
    }
}
