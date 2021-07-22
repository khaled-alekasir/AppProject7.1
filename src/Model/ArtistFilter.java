package Model;

import java.util.ArrayList;
import java.util.List;

public class ArtistFilter extends Filter{
    private String artist;

    public ArtistFilter(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public List<Music> filter(List<Music> musics){
        List<Music> filtered = new ArrayList<>();
        for (Music music : musics) {
            if(music.getArtist().equalsIgnoreCase(artist))
                filtered.add(music);
        }
        return filtered;
    }
}
