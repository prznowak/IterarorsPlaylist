package ChallengeArrayList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Album {

    private String name;
    private LinkedList<Song> songsList;

    public Album(String name) {
        this.name = name;
        this.songsList = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public LinkedList<Song> getSongsList() {
        return songsList;
    }


    public boolean newSongOnAlbum(String songTitle, String songDuration) {
        if (findSong(songTitle) == null) {
            this.songsList.add(new Song(songTitle, songDuration));
            return true;
        }
        return false;
    }


    private Song findSong(String songTitle) {
        ListIterator<Song> songListIterator = this.songsList.listIterator();
        while (songListIterator.hasNext()) {
            Song checkedSong = songListIterator.next();
            if (checkedSong.getTitle().equals(songTitle)) {
                return checkedSong;
            }
        }
        return null;
    }


}
