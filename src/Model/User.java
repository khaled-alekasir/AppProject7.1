package Model;

import java.util.*;

public class User {
    private String username;
    private String e_mail;
    private long passHash;
    List<Music> liked;
    List<Playlist> publicList;
    List<Playlist> privateList;
    Set<Filter> filters;

    public User(String username, String e_mail, long passHash) {
        this.username = username;
        this.e_mail = e_mail;
        this.passHash = passHash;
        this.liked = new ArrayList<>();
        this.publicList = new ArrayList<>();
        this.privateList = new ArrayList<>();
        this.filters = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public String getE_mail() {
        return e_mail;
    }

    public long getPassHash() {
        return passHash;
    }

    public List<Music> getLiked() {
        return liked;
    }

    public List<Playlist> getPublicList() {
        return publicList;
    }

    public List<Playlist> getPrivateList() {
        return privateList;
    }
    public void addFilter(Filter filter){
        filters.add(filter);
    }
    public List<Music> filter(List<Music> musics){
        List<Music> temp = new ArrayList<>();
        for (Filter filter : filters) {
            temp.retainAll(filter.filter((musics)));
        }
        return temp;
    }
    public void addLike(Music music){
        if(liked.contains(music))
            throw new IllegalArgumentException("liked before");
        liked.add(music);
        music.setLikes(music.getLikes() + 1);
    }
    public void printLikedMusics(){
        if(liked.size() == 0)
            throw new IllegalArgumentException("Empty");
        Comparator<Music> sortById = new Comparator<Music>() {
            @Override
            public int compare(Music a, Music b) {
                return Integer.parseInt(a.getID()) - Integer.parseInt(b.getID());
            }
        };
        liked.sort(sortById);
        for (Music music : liked) {
            System.out.println(music);
        }
    }
}
