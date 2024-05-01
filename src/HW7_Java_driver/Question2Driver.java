package HW7_Java_driver;
import H7_Java_model.q2.Song;
import H7_Java_model.q2.SongProxyService;

import java.util.List;

public class Question2Driver {
    public static void main(String[] args) throws InterruptedException {

        SongProxyService service = new SongProxyService();

        // should make call to service
        Song song = service.searchById(2);
        printSong(song);

        // should fetch from cache
        song = service.searchById(2);
        printSong(song);

        // should fetch from the service
        List<Song> songListByTitle = service.searchByTitle("Good 4 U");
        songListByTitle.forEach(song1 -> printSong(song1));

        // should fetch from the cache
        songListByTitle = service.searchByTitle("Good 4 U");
        songListByTitle.forEach(song1 -> printSong(song1));

        // should fetch from the service
        List<Song> songListByAlbum = service.searchByAlbum("Fine Line");
        songListByAlbum.forEach(song1 -> printSong(song1));

        // should fetch from the cache
        songListByAlbum = service.searchByAlbum("Fine Line");
        songListByAlbum.forEach(song1 -> printSong(song1));

    }

    private static void printSong(Song song) {
        System.out.println("Title : " + song.getTitle());
        System.out.println("Album : " + song.getAlbum());
        System.out.println("Artist : " + song.getArtist());
        System.out.println(' ');
    }
}
