package com.blogspot.priyabratanaskar.playsong;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlaySongActivity extends AppCompatActivity {
    private boolean isPlaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        ImageView artistImage = (ImageView) findViewById(R.id.play_song_artist_image);
        TextView songNameText = (TextView) findViewById(R.id.play_song_name);
        TextView artistNameText = (TextView) findViewById(R.id.play_artist_name);
        TextView totalDurationText = (TextView) findViewById(R.id.play_song_total_duration);


        ImageButton playPreviousButton = (ImageButton) findViewById(R.id.play_prev_button);
        final ImageButton playButton = (ImageButton) findViewById(R.id.play_button);
        ImageButton playNextButton = (ImageButton) findViewById(R.id.play_next_button);

        Intent intent = getIntent();
        if (intent.hasExtra("song_name")) {
            songNameText.setText(intent.getStringExtra("song_name"));
        }
        if (intent.hasExtra("artist_name")) {
            artistNameText.setText(intent.getStringExtra("artist_name"));
        }
        if (intent.getIntExtra("artist_image",1000)!= Song.NO_IMAGE) {
            artistImage.setImageResource(intent.getIntExtra("artist_image",R.drawable.ic_artist_image));
        }
        else artistImage.setImageResource(R.drawable.ic_artist_image);
        if (intent.hasExtra("song_duration")) {
            int totalDuration = intent.getIntExtra("song_duration", 300);
            String remainingSeconds = totalDuration % 60 > 10 ?
                    String.valueOf(totalDuration % 60) : String.format("0" + totalDuration % 60);
            String duration = (totalDuration / 60) + ":" + remainingSeconds;
            totalDurationText.setText(duration);
        }
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    playButton.setImageResource(R.drawable.ic_stop_music);
                    isPlaying = false;
                } else {
                    playButton.setImageResource(R.drawable.ic_play_now);
                    isPlaying = true;
                }
            }
        });

        playPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Previous Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        playNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Next Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
