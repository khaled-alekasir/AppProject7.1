package Control;

import Model.Music;
import Model.User;

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Utunes{
    private static Utunes instance;
    private static int lastPlaylistID = 0;
    User loggedIn;
    private List<User> users;
    private List<Music> musics;

    public static Utunes getInstance() throws IOException {
        if(instance == null){
            instance = new Utunes();
        }
        return instance;
    }
    private Utunes() throws IOException{
        loggedIn = null;
        users = new ArrayList<>();
        musics = new ArrayList<>();
        readSongsCSV();
    }
    private void readSongsCSV() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("songs.csv"));
        String line;
        line = reader.readLine();
        while((line = reader.readLine()) != null){
            String[] temp = line.split(",");
            System.out.println(Arrays.asList(temp));
            musics.add(new Music(temp[1] , temp[0] , temp[2] , temp[3]));
        }
    }
    private Music findMusicById(String id){
        for (Music music : musics) {
            if(music.getID().equals(id))
                return music;
        }
        throw new IllegalArgumentException("ID matches no music");
    }
    public void signUp(String username , String email , String pass){
        User newUser = new User(username , email , pass.hashCode());
        for (User user : this.users) {
            if(user.getE_mail().equals(newUser) || user.getUsername().equals(username)) {
                throw new IllegalArgumentException("Username or E_mail is duplicated");
            }
        }
        users.add(newUser);
        loggedIn = newUser;
    }
    public void logIn(String email , String password){
        for (User user : users) {
            if(user.getE_mail().equals(email) && user.getPassHash() == password.hashCode()){
                loggedIn = user;
                return;
            }
        }
        throw new IllegalArgumentException("User does not exists\n enter a valid username and password");
    }
    public void logOut(){
        if(loggedIn == null)
            throw new IllegalArgumentException("you`re not logged in!");
        loggedIn = null;
    }
    public void printMusics(){
        if(loggedIn == null)
            throw new IllegalArgumentException("Permission denied");
        if(musics.size() == 0)
            throw new IllegalArgumentException("Empty");
        List<Music> filteredMusics = loggedIn.filter(musics);
        for (Music music : filteredMusics) {
            System.out.println(music);
        }
    }
    public void printMusic(String id){
        Music music = findMusicById(id);
        System.out.println(music.getID()+"\n"+music.getTitle()+"\n"+music.getArtist()+"\n"+music.getReleaseYear());
        System.out.println("#likes: " + music.getLikes());
        System.out.println("#comments: " + music.getComments().size());
        System.out.println("#playlist: " + music.getPlaylists().size());
    }
    public void likeMusic(String id){
        if(loggedIn == null)
            throw new IllegalArgumentException("Permission denied");
        Music toBeLiked = findMusicById(id);
        loggedIn.addLike(toBeLiked);
    }
    public void printMusicsLikedByUser(){
        if(loggedIn == null)
            throw new IllegalArgumentException("Permission Denied");
        loggedIn.printLikedMusics();
    }
}

