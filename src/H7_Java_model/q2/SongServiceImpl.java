package H7_Java_model.q2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SongServiceImpl implements SongService {
    private static Map<Integer, Song> songCollections = new HashMap<>();

    public SongServiceImpl() {
        loadSongCollections();
    }

    private void loadSongCollections() {
        songCollections.put(1, new Song("Watermelon Sugar", "Harry Styles", "Fine Line", 174, 1));
        songCollections.put(2, new Song("Levitating", "Dua Lipa", "Future Nostalgia", 203, 2));
        songCollections.put(3, new Song("Blinding Lights", "The Weeknd", "After Hours", 200, 3));
        songCollections.put(4, new Song("drivers license", "Olivia Rodrigo", "SOUR", 242, 4));
        songCollections.put(5, new Song("Positions", "Ariana Grande", "Positions", 173, 5));
        songCollections.put(6, new Song("Good 4 U", "Olivia Rodrigo", "SOUR", 178,6));
        songCollections.put(7, new Song("Mood", "24kGoldn ft. Iann Dior", "El Dorado", 140, 7));
        songCollections.put(8, new Song("Montero (Call Me By Your Name)", "Lil Nas X", "Montero", 137, 8));
        songCollections.put(9, new Song("Leave The Door Open", "Silk Sonic", "An Evening with Silk Sonic", 242, 9));
        songCollections.put(10, new Song("Peaches", "Justin Bieber ft. Daniel Caesar, Giveon", "Justice", 198, 10));
        songCollections.put(11, new Song("Good 4 U", "Olivia Rodrigo", "SOUR (Target Exclusive)", 178, 11));
    }

    @Override
    public Song searchById(Integer songId) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return songCollections.get(songId);
    }

    @Override
    public List<Song> searchByTitle(String songTitle) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return songCollections.values()
                .stream()
                .filter(song -> songTitle.equalsIgnoreCase(song.getTitle())).collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByAlbum(String songAlbum) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return songCollections.values()
                .stream()
                .filter(song -> songAlbum.equalsIgnoreCase(song.getAlbum())).collect(Collectors.toList());
    }
}