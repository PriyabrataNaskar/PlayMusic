package com.blogspot.priyabratanaskar.playsong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(@NonNull Context context, @NonNull ArrayList<Song> songsList) {
        super(context, 0, songsList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.song_list_item, parent, false);
        }
        Song currentSong = getItem(position);

        ImageView artistImage = convertView.findViewById(R.id.song_list_item_artist_image);
        TextView songName =convertView.findViewById(R.id.song_list_item_song_name);
        TextView artistName =convertView.findViewById(R.id.song_list_item_artist_name);

        songName.setText(currentSong.getSongName());
        artistName.setText(currentSong.getArtistName());

        if (currentSong.hasImage()) {
            artistImage.setImageResource(currentSong.getArtistImageID());
            artistImage.setVisibility(View.VISIBLE);
        } else {
            artistImage.setImageResource(R.drawable.ic_artist_image);
            artistImage.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
}
