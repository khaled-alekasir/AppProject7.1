package View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum ConsoleViewCommands {
    SIGNUP("(?i)\\s*Post\\s+signup\\s+\\?\\s+email\\s+\\w+@\\w+.com\\s+username\\s+\\w+\\s+password\\s+\\w+"),
    LOGIN("(?i)\\s*Post\\s+login\\s+\\?\\s+email\\s+\\w+@\\w+.com\\s+password\\s+\\w+"),
    LOGOUT("(?i)\\s*Post\\s+logout"),
    GET_SONGS("(?i)\\s*GET\\s+songs"),
    GET_SONGS_USING_ID("(?i)\\s*GET\\s+songs\\s+\\?\\s+id\\s+\\d*"),
    GET_SONGS_USER_LIKES("(?i)\\s*get\\s+likes"),
    LIKE_NEW_SONG("(?i)\\s*post\\s+likes\\s+\\?\\s+id\\s+\\d+"),
    UNLIKE_MUSIC("(?i)\\s*DELETE\\s+likes\\s+\\?\\s+id\\s+\\d+"),
    CREATE_NEW_PLAYLIST("(?i)\\s*post\\s+Playlist\\s+\\?\\s+name\\s+\\w+\\s+privacy\\s+(public|private)"),
    GET_USERS_PLAYLIST("(?i)\\s*Get\\s+playlist\\s+\\?\\s+username\\s+\\w+"),
    ADD_SONG_TO_PLAYLIST("(?i)\\s*post\\s+playlists_songs\\s+\\?\\s+playlist_id\\s+\\d+\\s+song_id\\s+\\d+"),
    GET_PLAYLIST("(?i)\\s*get\\s+playlists_songs\\s+\\?\\s+playlist_id\\s+\\d+"),
    DELETE_SONG_FROM_PLAYLIST("(?i)\\s*DELETE\\s+playlists_songs\\s+\\?\\s+playlist_id\\s+\\d+\\s+song_id\\s+\\d+"),
    GET_USERS("(?i)\\s*GET\\s+users"),
    ADD_ARTIST_FILTER("(?i)\\s*Post filters \\? artist [a-zA-Z]+"),
    ADD_YEAR_FILTER("(?i)\\s*Post filters \\? min_year\\s+\\d{4}\\s+max_year\\s+\\d{4}"),
    ADD_LIKE_FILTER("(?i)\\s*Post filters \\? min_like\\s*\\d+\\s+max_like\\s*\\d+"),
    DELETE_FILTERS("(?i)DELETE\\s*filters"),
    ADD_COMMENT_ON_SONG("(?i)\\s*POST\\s+comment\\s*\\?\\s*song_id\\s*\\d+\\s+time\\s+\\d+\\s+comment\\s+\\w+"),
    GET_SONGS_COMMENTS("(?i)\\s*GET\\s+comments\\s+\\?\\s+song_id\\s+\\d+");

    private Pattern pattern;
    public Matcher getMatcher(String input){
        return pattern.matcher(input);
    }
    ConsoleViewCommands(String pattern){
        this.pattern = Pattern.compile(pattern);
    }

}
