package Model;

import java.util.ArrayList;
import java.util.List;

public class ReleaseYearFilter extends Filter{
    private String beginYear;
    private String endYear;

    public ReleaseYearFilter(String beginYear, String endYear) {
        if(Integer.parseInt(beginYear) > Integer.parseInt(endYear))
//
        this.beginYear = beginYear;
        this.endYear = endYear;
    }
    @Override
    public List<Music> filter(List<Music> musics){
        List<Music> filtered = new ArrayList<>();
        for (Music music : musics) {
            if(Integer.parseInt(music.getReleaseYear()) >= Integer.parseInt(beginYear) &&
               Integer.parseInt(music.getReleaseYear()) <= Integer.parseInt(endYear))
                    filtered.add(music);
        }
        return filtered;
    }
}
