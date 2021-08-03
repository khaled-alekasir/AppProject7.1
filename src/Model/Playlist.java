package Model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final String ID;
    private String Title;
    private String privacy;
    List<Music> musics;

    public Playlist(String ID, String title , String privacy){
        this.privacy = privacy;
        this.ID = ID;
        this.Title = title;
        musics = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }
    public String getPrivacy() {
        return privacy;
    }
    public List<Music> getMusics() {
        return musics;
    }
    public boolean isPrivate(){
        return this.privacy.equalsIgnoreCase("private");
    }
}
