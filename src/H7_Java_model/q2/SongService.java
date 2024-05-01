package H7_Java_model.q2;


import java.util.List;

public interface SongService {
    Song searchById(Integer songId);
    List<Song> searchByTitle(String songTitle);
    List<Song> searchByAlbum(String songAlbum);
}