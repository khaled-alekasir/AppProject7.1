package Model;

public class Comment{
    private String comment;
    private String songID;
    private int second;

    public Comment(String comment, String songID, int second) {
        this.comment = comment;
        this.songID = songID;
        this.second = second;
    }

    public String getComment() {
        return comment;
    }

    public String getSongID() {
        return songID;
    }

    public int getSecond() {
        return second;
    }
}
