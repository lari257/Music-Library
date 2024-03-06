package app.audio.Collections;

import app.audio.Files.AudioFile;
import fileio.input.SongInput;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public final class Album extends AudioCollection {

    private String name;
    private int releaseYear;
    private String description;
    private String owner;

    private int likes;

    private ArrayList<SongInput> albumSongs;

    public Album(final String name,
                 final int releaseYear, final String description,
                 final ArrayList<SongInput> albumSongs,
                 final String username) {
        super(name, username);
        this.name = name;
        this.releaseYear = releaseYear;
        this.description = description;
        this.albumSongs = albumSongs;
        this.owner = username;
        likes = 0;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setReleaseYear(final int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setAlbumSongs(final ArrayList<SongInput> albumSongs) {
        this.albumSongs = albumSongs;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    @Override
    public int getNumberOfTracks() {
        return albumSongs.size();
    }

    @Override
    public AudioFile getTrackByIndex(final int index) {
        return null;
    }

    public void setLikes(final int likes) {
        this.likes = likes;
    }
}
