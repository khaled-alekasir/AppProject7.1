package View;

import Control.Utunes;
import Model.Playlist;

import java.security.CodeSigner;
import java.security.cert.TrustAnchor;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class ConsoleView {
    private final Utunes utunes;
    static Scanner console;
    public ConsoleView(Utunes utunes) {
        this.utunes = utunes;
        console = new Scanner(System.in);
    }
    private void printUsersPlaylists(List<Playlist> playlists){
        if(playlists.size() == 0)
            throw new IllegalArgumentException("Empty");
        for (Playlist playlist : playlists) {
            System.out.println(playlist.getID()+" "+playlist.getTitle()+" "+playlist.getPrivacy());
        }
    }
    public void run(){
        while(true){
            try {
                System.out.println("Enter Your Command:");
                String command = console.nextLine().trim();
                String[] commandArr = command.split("\s");
                if (ConsoleViewCommands.SIGNUP.getMatcher(command).matches()) {
                    utunes.signUp(commandArr[4], commandArr[6], commandArr[8]);
                    System.out.println("Signed up!");
                } else if (ConsoleViewCommands.LOGIN.getMatcher(command).matches()) {
                    utunes.logIn(commandArr[4], commandArr[6]);
                    System.out.println(commandArr[4] + "logged in!");
                }else if(ConsoleViewCommands.LOGOUT.getMatcher(command).matches()){
                    utunes.logOut();
                    System.out.println("user logged out successfully");
                }else if(ConsoleViewCommands.GET_SONGS.getMatcher(command).matches()){
//                    utunes.printMusics();               change
                }else if(ConsoleViewCommands.GET_SONGS_USING_ID.getMatcher(command).matches()){
//                    utunes.printMusic(commandArr[4]);   change
                }else if(ConsoleViewCommands.LIKE_NEW_SONG.getMatcher(command).matches()){
                    utunes.likeMusic(commandArr[4]);
                }else if(ConsoleViewCommands.GET_SONGS_USER_LIKES.getMatcher(command).matches()){
//                    utunes.printMusicsLikedByUser();     change
                }else if(ConsoleViewCommands.UNLIKE_MUSIC.getMatcher(command).matches()){
                    utunes.unlikeMusic(commandArr[4]);
                }else if(ConsoleViewCommands.CREATE_NEW_PLAYLIST.getMatcher(command).matches()){
                    utunes.creatNewPlaylist(commandArr[4] , commandArr[6]);
                }else if(ConsoleViewCommands.GET_USERS_PLAYLIST.getMatcher(command).matches()){
                    printUsersPlaylists(utunes.getUsersPlaylist(commandArr[4]));
                }else if(ConsoleViewCommands.ADD_SONG_TO_PLAYLIST.getMatcher(command).matches()){
                    utunes.addMusicToPlaylist(commandArr[6] , commandArr[4]);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
