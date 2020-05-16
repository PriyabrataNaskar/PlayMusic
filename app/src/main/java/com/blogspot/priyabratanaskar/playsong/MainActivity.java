package com.blogspot.priyabratanaskar.playsong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static ArrayList<Song> songArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songArrayList = new ArrayList<Song>();
        songArrayList.add(new Song("On my Way","Alan Walker",5*60 + 12,R.drawable.alan_walker));
        songArrayList.add(new Song("Stuck With U","Ariana",4*60 + 44));
        songArrayList.add(new Song("Despacito","Luis Fonsi",6*60 + 12, R.drawable.louis_fonsi));
        songArrayList.add(new Song("Memories","Maroon",5*60 + 34));
        songArrayList.add(new Song("Yummy","Justin Bieber",5*60 + 20,R.drawable.justin_bieber));
        songArrayList.add(new Song("Dance Monkey","Tones & I Dance",4*60 + 35));
        songArrayList.add(new Song("Senorita","Shawn",5*60 + 12));
        songArrayList.add(new Song("Shyad","Pritam",5*60 + 15));
        songArrayList.add(new Song("Filhal","B Praak",5*60 + 21,R.drawable.b_praak));
        songArrayList.add(new Song("Yaad","Neha",5*60 + 33,R.drawable.neha_khakkar));
        songArrayList.add(new Song("Senorita","Shawn",5*60 + 23,R.drawable.shawn));

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Add song button Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        ListView songListView = findViewById(R.id.full_song_list);
        SongAdapter adapter = new SongAdapter(this, songArrayList);
        songListView.setAdapter(adapter);
        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song clickedSong = (Song) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this,PlaySongActivity.class);
                intent.putExtra("song_name",clickedSong.getSongName());
                intent.putExtra("artist_name",clickedSong.getArtistName());
                intent.putExtra("song_duration",clickedSong.getSongDuration());
                intent.putExtra("artist_image",clickedSong.getArtistImageID());
                startActivity(intent);
            }
        });
    }
}
