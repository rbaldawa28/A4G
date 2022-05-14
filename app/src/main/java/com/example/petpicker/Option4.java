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

public class Option4 extends YouTubeBaseActivity {

    String apiKey = "AIzaSyCqOuV_zZb_nJ5J3205eJ4frQSS2_ZGs7w";
    String dogId = "rpzD_Hrrmj0";
    String catId = "MpJXKs_hglY";
    String hamsterId = "4HN5uWzLoFc";
    String birdId = "eRk0ax91YhA";
    String fishId = "mGmIvhtIM9k";
    String currentId;
    YouTubePlayerView youTubePlayerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option4);

        MaterialButton map = (MaterialButton) findViewById(R.id.vOptions);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        SharedPreferences sp = getSharedPreferences("UserPrefs",MODE_PRIVATE);
        Pets options = new Pets(sp);

        if(options.getFourth().equals("Dog"))
        {
            currentId = dogId;
        }
        else if(options.getFourth().equals("Cat"))
        {
            currentId = catId;
        }
        else if(options.getFourth().equals("Hamster"))
        {
            currentId = hamsterId;
        }
        else if(options.getFourth().equals("Bird"))
        {
            currentId = birdId;
        }
        else if(options.getFourth().equals("Fish"))
        {
            currentId = fishId;
        }

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

    public void openMap()
    {
        Intent intent = new Intent(this, Map4.class);
        startActivity(intent);
    }
}
