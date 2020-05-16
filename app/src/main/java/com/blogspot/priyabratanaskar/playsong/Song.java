package com.blogspot.priyabratanaskar.playsong;

public class Song {
    private String songName;
    private String artistName;
    private int songDuration;
    public static final int NO_IMAGE = -1;
    private int artistImageID=NO_IMAGE;

    public Song(String songName, String artistName, int songDuration, int artistImageID) {
        this.songName = songName;
        this.artistName = artistName;
        this.songDuration = songDuration;
        this.artistImageID = artistImageID;
    }

    public Song(String songName, String artistName, int songDuration) {
        this.songName = songName;
        this.artistName = artistName;
        this.songDuration = songDuration;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getSongDuration() {
        return songDuration;
    }

    public int getArtistImageID() {
        return artistImageID;
    }

    /**
     * if artist has no image
     * @return
     */
    public boolean hasImage() {
        return artistImageID != NO_IMAGE;
    }

}
