package H7_Java_model.q2;

import H7_Java_model.q2.Song;
import H7_Java_model.q2.SongService;

import java.util.*;
import java.util.stream.Collectors;

public class SongProxyService implements SongService {
    private SongServiceImpl songService;
    private Map<Integer, List<Song>> CACHE = new HashMap<>();

    public SongProxyService() {
        songService = new SongServiceImpl();
    }

    @Override
    public Song searchById(Integer songId) {
        long start = System.currentTimeMillis();
        Song result = null;
        if(CACHE.containsKey(songId)) {
            System.out.println("SongProxyService : Fetched song from Cache.");
            result = Optional.ofNullable(CACHE.get(songId).get(0)).orElse(null);
        }
        else {
            System.out.println("SongProxyService : Song is not found in Cache so calling the service");
            result = songService.searchById(songId);
            // putting in cache
            CACHE.put(songId, Arrays.asList(result));
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("SongProxyService : Total time elapsed to fetch song by id : " + elapsedTime + " milliseconds");
        return result;
    }

    @Override
    public List<Song> searchByTitle(String songTitle) {
        long start = System.currentTimeMillis();
        // check in Cache first
        List<Song> result = CACHE.values()
                .stream()
                .map(songs -> {
                    List<Song> songList = songs.stream().filter(song -> songTitle.equalsIgnoreCase(song.getTitle())).collect(Collectors.toList());
                    return songList;
                }).findFirst().orElse(null);
        if (result.isEmpty()) {
            // calling service
            System.out.println("SongProxyService : Song is not found in Cache so calling the service");
            result = songService.searchByTitle(songTitle);
            // put the list in cache
            CACHE.put(result.get(0).getSongId(), result);
        }
        else {
            System.out.println("SongProxyService : Fetched song from Cache.");
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("SongProxyService : Total time elapsed to fetch song by song title : " + elapsedTime + " milliseconds");
        return result;
    }

    @Override
    public List<Song> searchByAlbum(String songAlbum) {
        long start = System.currentTimeMillis();
        // check in Cache first
        List<Song> result = CACHE.values()
                .stream()
                .map(songs -> {
                    List<Song> songList = songs.stream().filter(song -> songAlbum.equalsIgnoreCase(song.getAlbum())).collect(Collectors.toList());
                    return songList;
                }).findFirst().orElse(null);
        if (result.isEmpty()) {
            // calling service
            System.out.println("SongProxyService : Song is not found in Cache so calling the service");
            result = songService.searchByAlbum(songAlbum);
            // put the list in cache
            CACHE.put(result.get(0).getSongId(), result);
        }
        else {
            System.out.println("SongProxyService : Fetched song from Cache.");
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("SongProxyService : Total time elapsed to fetch song by song Album : " + elapsedTime + " milliseconds");
        return result;
    }
}