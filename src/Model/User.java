package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
