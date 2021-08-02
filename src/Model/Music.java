package Model;

import java.util.ArrayList;
import java.util.List;

public class Music {
    private String Title;
    private String ID;
    private String artist;
    private String releaseYear;
    private List<Playlist> playlists;
    private List<Comment> comments;
    private int likes;

    public Music(String title, String ID, String artist, String releaseYear) {
        this.Title = title;
        this.ID = ID;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.playlists = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.likes = 0;
    }

    public String getTitle() {
        return Title;
    }

    public String getID() {
        return ID;
    }

    public String getArtist() {
        return artist;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString(){
        return getID()+" " + getTitle()+" "+ getArtist()+" " +getReleaseYear();
    }
}
