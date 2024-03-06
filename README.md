
# Music Library
This project implements a Music Library Management System in Java, providing functionalities to manage songs, podcasts, playlists, and user preferences. The system allows users to perform various operations, such as searching for songs, creating playlists, liking songs, and more.

In the second stage of the project, several new features have been introduced, building upon the solution for Stage 1. The key additions include the incorporation of artists and hosts—privileged users with the ability to add and delete posts/items from their respective pages, such as merch, events, and announcements.

Processing Commands:

The processor iterates through a list of commands, updating timestamps and executing corresponding actions based on the command type. The commands are processed using a switch statement, where each case corresponds to a specific command, and the appropriate action is invoked through a CommandRunner class.

Usage
To use this command processor, create a list of CommandInput objects representing the commands you want to execute. The processor will iterate through each command, updating timestamps and performing the associated action.

Commands
The supported commands and their corresponding actions include:

Admin's Commands:

    addUser: Add a new user that can be also a host or an artist or a normal user.

    printCurrentPage: Through this command, we will see the page on which a specific user is located.

Search Bar Commands:
    
    search: Search for songs, podcasts, albums, artists, or playlists.

    select: Select a specific item.

Player's Commands:

    load: Load a song or playlist or podcast ot album or artis's page for playback.

    playPause: Play or pause the current track.

    repeat: An integer indicating the repeat mode.

    shuffle: The playback order will be randomized.

    forward: Advances to the next track or segment in the playlist

    backward: Goes back to the previous track or segment in the playlist.

    like: Like or unlike a song.

    next: Go to the next audio file.

    prev: Go to the previous audio file.

    addRemoveInPlaylist: Add or remove songs from a playlist.

    status: Display the current playback status.

    switchConnectionStatus: It shows if an user is online or offline.

    addAlbum: Add an album;
    
    addMerch: Command for artists only.

    addEvent: Command for artists only.

Playlist Commands:

    createPlaylist: Create a new playlist.

    showPlaylists: Display the user's playlists.

    showPreferredSongs: Display liked songs for a user.

    follow: Follow or unfollow a public playlist.

    switchVisibility: Toggle the visibility of a playlist.

    getTop5Songs: Get the top 5 songs based on likes.

    getTop5Playlists: Get the top 5 playlists based on follows.

    getTop5Albums: Get the top 5 albums based on likes.

    getOnlineUsers: Dsplay all the users that are online.

    showAlbums: Display all the Albums of an artist.

