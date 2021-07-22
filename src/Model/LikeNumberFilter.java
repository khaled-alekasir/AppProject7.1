package Model;

import java.util.ArrayList;
import java.util.List;

public class LikeNumberFilter extends Filter{
    private int minLike;
    private int maxLike;

    public LikeNumberFilter(int minLike , int maxLike) {
        if(minLike < maxLike)
//            to do
        this.minLike = minLike;
        this.maxLike = maxLike;
    }

    @Override
    public List<Music> filter(List<Music> musics) {
        List<Music> filtered = new ArrayList<>();
        for (Music music : musics) {
            if(music.getLikes() <= maxLike || music.getLikes() >= minLike)
                filtered.add(music);
        }
        return filtered;
    }
}
