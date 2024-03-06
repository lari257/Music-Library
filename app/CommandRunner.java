package app;

import app.ArtistSupplies.Event;
import app.ArtistSupplies.Merch;
import app.audio.Collections.Album;
import app.audio.Collections.PlaylistOutput;
import app.player.PlayerStats;
import app.searchBar.Filters;
import app.user.Artist;
import app.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.input.CommandInput;
import fileio.input.SongInput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Command runner.
 */
public final class CommandRunner {
    static final int FIVE = 5;
    private static ObjectMapper objectMapper = new ObjectMapper();
    static final int THREE = 3;
    static final int ZERO = 0;
    static final int TWO = 2;
    static final int SIX = 6;
    static final int TEN = 10;
    static final int NINE = 9;
    static final int FOUR = 4;
    static final int ELEVEN = 11;
    static final int YEAR1 = 1990;
    static final int YEAR2 = 2023;
    static final int TWELVE = 12;

    /**
     * The Object mapper.
     */
    private CommandRunner() {
    }

    /**
     * Search object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode search(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());

        if (user.isOnline()) {
            Filters filters = new Filters(commandInput.getFilters());
            String type = commandInput.getType();

            ArrayList<String> results = user.search(filters, type);
            String message = "Search returned " + results.size() + " results";

            objectNode.put("message", message);
            objectNode.put("results", objectMapper.valueToTree(results));
        } else {
            ArrayNode emptyArray = objectMapper.createArrayNode();
            objectNode.put("message",  commandInput.getUsername() + " is offline.");
            objectNode.put("results", emptyArray);
        }

        return objectNode;
    }

    /**
     * Select object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode select(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());

        String message = user.select(commandInput.getItemNumber());

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Load object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode load(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        String message = user.load();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Play pause object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode playPause(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        String message = user.playPause();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Repeat object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode repeat(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        String message = user.repeat();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Shuffle object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode shuffle(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        Integer seed = commandInput.getSeed();
        String message = user.shuffle(seed);

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Forward object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode forward(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        String message = user.forward();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Backward object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode backward(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        String message = user.backward();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Like object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode like(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        String message = user.like();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Next object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode next(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        String message = user.next();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Prev object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode prev(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        String message = user.prev();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Create playlist object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode createPlaylist(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        String message = user.createPlaylist(commandInput.getPlaylistName(),
                                             commandInput.getTimestamp());

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Add remove in playlist object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode addRemoveInPlaylist(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        String message = user.addRemoveInPlaylist(commandInput.getPlaylistId());

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Switch visibility object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode switchVisibility(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        String message = user.switchPlaylistVisibility(commandInput.getPlaylistId());

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Show playlists object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode showPlaylists(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        ArrayList<PlaylistOutput> playlists = user.showPlaylists();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("result", objectMapper.valueToTree(playlists));

        return objectNode;
    }

    /**
     * Follow object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode follow(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        String message = user.follow();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("message", message);

        return objectNode;
    }

    /**
     * Status object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode status(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        PlayerStats stats = user.getPlayerStats();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("stats", objectMapper.valueToTree(stats));

        return objectNode;
    }

    /**
     * Show liked songs object node.
     *
     * @param commandInput the command input
     * @return the object node
     */
    public static ObjectNode showLikedSongs(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        ArrayList<String> songs = user.showPreferredSongs();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("result", objectMapper.valueToTree(songs));

        return objectNode;
    }

    /**
     * Gets preferred genre.
     *
     * @param commandInput the command input
     * @return the preferred genre
     */
    public static ObjectNode getPreferredGenre(final CommandInput commandInput) {
        User user = Admin.getUser(commandInput.getUsername());
        String preferredGenre = user.getPreferredGenre();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("result", objectMapper.valueToTree(preferredGenre));

        return objectNode;
    }

    /**
     * Gets top 5 songs.
     *
     * @param commandInput the command input
     * @return the top 5 songs
     */
    public static ObjectNode getTop5Songs(final CommandInput commandInput) {
        List<String> songs = Admin.getTop5Songs();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("result", objectMapper.valueToTree(songs));

        return objectNode;
    }

    /**
     * Gets top 5 playlists.
     *
     * @param commandInput the command input
     * @return the top 5 playlists
     */
    public static ObjectNode getTop5Playlists(final CommandInput commandInput) {
        List<String> playlists = Admin.getTop5Playlists();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("result", objectMapper.valueToTree(playlists));

        return objectNode;
    }

    /**
     * Add a user
     *
     * @param commandInput the command input
     * @return the output
     */
    public static ObjectNode addUser(final CommandInput commandInput) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());

        String username = commandInput.getUsername();
        int age = commandInput.getAge();
        String city = commandInput.getCity();

        String message = Admin.addUser(username, commandInput.getType(), age, city);

        objectNode.put("message", message);
        return objectNode;
    }

    /**
     * Make an user online or offline.
     *
     * @param commandInput the command input
     */
    public static ObjectNode switchConnectionStatus(final CommandInput commandInput) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());

        String username = commandInput.getUsername();
        User user = Admin.getUser(username);
        if (user == null) {
            if (Admin.getArtist(username) != null) {
                objectNode.put("message", username + " is not a normal user.");
            } else {
                objectNode.put("message", "The username " + username + " doesn't exist.");
            }
            return objectNode;
        }

        boolean online = user.isOnline();
        user.setOnline(!online);

        objectNode.put("message", username + " has changed status successfully.");
        return objectNode;
    }

    /**
     * Gets the online users
     *
     * @param commandInput the command input
     */
    public static ObjectNode getOnlineUsers(final CommandInput commandInput) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("timestamp", commandInput.getTimestamp());

        ArrayNode result = objectMapper.createArrayNode();

        List<User> usersList = Admin.getUsers();
        for (User user : usersList) {
            if (user.isOnline()) {
                result.add(user.getUsername());
            }
        }

        objectNode.put("result", result);
        return objectNode;
    }

    /**
     * Add an album.
     *
     * @param commandInput the command input
     */
    public static ObjectNode addAlbum(final CommandInput commandInput) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());

        String username = commandInput.getUsername();

        Artist artist = Admin.getArtist(username);
        User user = Admin.getUser(username);

        if (user == null && artist == null) {
            objectNode.put("name", "The username " + username + " doesn't exist.");
            return objectNode;
        }

        if (artist == null) {
            objectNode.put("name", username + " is not an artist.");
            return objectNode;
        }

        String message = artist.addAlbum(commandInput);
        objectNode.put("message", message);
        return objectNode;
    }

    /**
     * Shows all albums.
     *
     * @param commandInput the command input
     */
    public static ObjectNode showAlbums(final CommandInput commandInput) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());

        Artist artist = Admin.getArtist(commandInput.getUsername());
        ArrayList<Album> albums = artist.getAlbums();

        ArrayNode resultArrayNode = objectMapper.createArrayNode();

        for (Album album : albums) {
            // Create a new ObjectNode for each album
            ObjectNode albumNode = objectMapper.createObjectNode();

            albumNode.put("name", album.getName());

            ArrayNode songsArrayNode = objectMapper.createArrayNode();
            for (SongInput song : album.getAlbumSongs()) {
                songsArrayNode.add(song.getName());
            }

            albumNode.set("songs", songsArrayNode);

            resultArrayNode.add(albumNode);
        }

        objectNode.set("result", resultArrayNode);
        return objectNode;
    }

    /**
     * Print the informations about the current page.
     *
     * @param commandInput the command input
     */
    public static ObjectNode printCurrentPage(final CommandInput commandInput) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("timestamp", commandInput.getTimestamp());

        User user = Admin.getUser(commandInput.getUsername());
        String message = user.printCurrentPage();

        objectNode.put("message", message);
        return objectNode;
    }

    /**
     * Add merch to an artist.
     *
     * @param commandInput the command input
     */
    public static ObjectNode addMerch(final CommandInput commandInput) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());

        String username = commandInput.getUsername();

        Artist artist = Admin.getArtist(username);
        User user = Admin.getUser(username);

        if (user == null && artist == null) {
            objectNode.put("message", "The username " + username + " doesn't exist.");
            return objectNode;
        }

        if (artist == null) {
            objectNode.put("message", username + " is not an artist.");
            return objectNode;
        }

        Merch merch = artist.findMerch(commandInput.getName());
        if (merch != null)  {
            objectNode.put("message", username + " has merchandise with the same name.");
            return objectNode;
        }

        if (commandInput.getPrice() < 0) {
            objectNode.put("message", "Price for merchandise can not be negative.");
            return objectNode;
        }

        Merch newMerch = new Merch(commandInput.getName(),
                commandInput.getDescription(), commandInput.getPrice());
        artist.getMerches().add(newMerch);

        objectNode.put("message", username + " has added new merchandise successfully.");
        return objectNode;
    }

    /**
     * Add an event for the artist
     *
     * @param commandInput the command input
     */
    public static ObjectNode addEvent(final CommandInput commandInput) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("user", commandInput.getUsername());
        objectNode.put("timestamp", commandInput.getTimestamp());

        String username = commandInput.getUsername();

        Artist artist = Admin.getArtist(username);
        User user = Admin.getUser(username);

        if (user == null && artist == null) {
            objectNode.put("message", "The username " + username + " doesn't exist.");
            return objectNode;
        }

        if (artist == null) {
            objectNode.put("message", username + " is not an artist.");
            return objectNode;
        }

        Event event = artist.findEvent(commandInput.getName());
        if (event != null)  {
            objectNode.put("message", username + " has another album with the same name.");
            return objectNode;
        }

        String dateStr = commandInput.getDate();
        if (!isValidDate(dateStr)) {
            objectNode.put("message", "Event for " + username + " does not have a valid date.");
            return objectNode;
        }

        Event newEvent = new Event(commandInput.getName(),
                commandInput.getDescription(), commandInput.getDate());
        artist.getEvents().add(newEvent);

        objectNode.put("message", username + " has added new event successfully.");
        return objectNode;
    }

    private static boolean isValidDate(final String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(dateStr);
            int day = Integer.parseInt(dateStr.substring(ZERO, TWO));
            int month = Integer.parseInt(dateStr.substring(THREE, FIVE));
            int year = Integer.parseInt(dateStr.substring(SIX, TEN));

            return !(day > 31 || day > 28 && month == TWO
                    || day > 30 && (month == FOUR || month == SIX
                    || month == NINE || month == ELEVEN)
                    || month > TWELVE || year < YEAR1 || year > YEAR2);
        } catch (NumberFormatException | ParseException e) {
            return false;
        }
    }

    public static ObjectNode getTop5Albums(final CommandInput commandInput) {
        List<String> albums = Admin.getTop5Albums();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("command", commandInput.getCommand());
        objectNode.put("timestamp", commandInput.getTimestamp());
        objectNode.put("result", objectMapper.valueToTree(albums));

        return objectNode;
    }

}
