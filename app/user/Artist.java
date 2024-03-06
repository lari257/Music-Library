package app.user;

import app.Admin;
import app.ArtistSupplies.Event;
import app.ArtistSupplies.Merch;
import app.audio.Collections.Album;
import app.audio.Files.Song;
import fileio.input.CommandInput;
import fileio.input.SongInput;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public final class Artist extends User {

    private ArrayList<Album> albums;
    private ArrayList<Merch> merches;
    private ArrayList<Event> events;

    public Artist(final String username, final int age, final String city) {
        super(username, age, city);
        albums = new ArrayList<>();
        merches = new ArrayList<>();
        events = new ArrayList<>();
    }

    public void setAlbums(final ArrayList<Album> albums) {
        this.albums = albums;
    }

    public Album getAlbum(final String name) {

        for (Album album : Admin.getAlbums()) {
            if (album.getName().equals(name)) {
                return album;
            }
        }

        // Return null if the album is not found
        return null;
    }
    public String addAlbum(CommandInput command) {
        String name = command.getName();
        int releaseYear = command.getReleaseYear();
        String description = command.getDescription();
        String username = command.getUsername();

        ArrayList<SongInput> songs = command.getSongs();


        if (getAlbum(name) != null) {
            return username + " has another album with the same name.";
        }

        HashMap<String, Integer> songCountMap = new HashMap<>();

        for (SongInput song : songs) {
            String songName = song.getName();
            songCountMap.put(songName, songCountMap.getOrDefault(songName, 0) + 1);
        }

        for (int count : songCountMap.values()) {
            if (count >= 2) {
                return username + " has the same song at least twice in this album.";
            }
        }

        Album newAlbum = new Album(name, releaseYear, description, songs, username);
        albums.add(newAlbum);
        Admin.getAlbums().add(newAlbum);

        List<Song> songsList = Admin.getSongs();
        for (SongInput song : songs) {
            String nameSong = song.getName();
            Integer duration = song.getDuration();
            String album = song.getAlbum();
            ArrayList<String> tags = song.getTags();
            String lyrics = song.getLyrics();
            String genre = song.getGenre();
            Integer releaseYearSong = song.getReleaseYear();
            String artist = song.getArtist();
            Song newSong = new Song(nameSong,
                    duration, album, tags, lyrics, genre, releaseYearSong, artist);
            Admin.addSong(newSong);
        }

        return username + " has added new album successfully.";
    }

    public void setMerches(final ArrayList<Merch> merches) {
        this.merches = merches;
    }

    public Merch findMerch(final String name) {
        for (Merch merch : this.merches) {
            if (merch.getName().equals(name)) {
                return merch;
            }
        }

        return null;
    }

    public Event findEvent(final String name) {
        for (Event event : this.events) {
            if (event.getName().equals(name)) {
                return event;
            }
        }

        return null;
    }

    public void setEvents(final ArrayList<Event> events) {
        this.events = events;
    }
}
