package View;

import Control.Utunes;

import java.security.cert.TrustAnchor;
import java.util.Scanner;
import java.util.TreeMap;

public class ConsoleView {
    private final Utunes utunes;
    static Scanner console;
    public ConsoleView(Utunes utunes) {
        this.utunes = utunes;
        console = new Scanner(System.in);
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
                    utunes.printMusics();
                }else if(ConsoleViewCommands.GET_SONGS_USING_ID.getMatcher(command).matches()){
                    utunes.printMusic(commandArr[4]);
                }else if(ConsoleViewCommands.LIKE_NEW_SONG.getMatcher(command).matches()){
                    utunes.likeMusic(commandArr[4]);
                }else if(ConsoleViewCommands.GET_SONGS_USER_LIKES.getMatcher(command).matches()){
                    utunes.printMusicsLikedByUser();
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
