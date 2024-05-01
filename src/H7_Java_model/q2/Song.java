package H7_Java_model.q2;

public class Song {
    private String title;
    private String artist;
    private String album;
    private int duration;
    private int songId;

    public Song(String title, String artist, String album, int duration, int songId) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }
}
