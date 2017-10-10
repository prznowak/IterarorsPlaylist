package ChallengeArrayList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {
    private String name;
    private LinkedList<Album> albumsList;
    private LinkedList<Song> ownPlaylist = new LinkedList<Song>();


    public Playlist(String name) {
        this.name = name;
        this.albumsList = new LinkedList<Album>();
    }

    public boolean addAlbum(String albumName) {
        if (findAlbum(albumName) == null) {
            this.albumsList.add(new Album(albumName));
            return true;
        }
        return false;
    }

    public LinkedList<Song> getOwnPlaylist() {
        return ownPlaylist;
    }

    public void startPlay() {
        ListIterator<Song> albumListIterator = this.ownPlaylist.listIterator();
       if(albumListIterator.hasNext()){
            System.out.println("First song is playing" + albumListIterator.next().getTitle());
        }
    }


    public void showOwnPlaylist() {
        ListIterator<Song> albumListIterator = this.ownPlaylist.listIterator();
        while (albumListIterator.hasNext()) {
            Song checkedSong = albumListIterator.next();
            System.out.println("Song Title: " + checkedSong.getTitle());
        }
    }

    public void createOwnPlaylist(String songTitle) {
        Song songToBeAdded = seekForASong(songTitle);
        if (songToBeAdded != null) {
            ownPlaylist.add(songToBeAdded);
        }
    }

    public void deleteFromPlaylist(String songTitle) {
        ListIterator<Song> songListIterator = this.ownPlaylist.listIterator();
        while (songListIterator.hasNext()) {
            if (songListIterator.next().getTitle().equals(songTitle)) {
                //System.out.println("deleted " + songListIterator.next().getTitle());
                songListIterator.remove();
            }
        }
    }

    public Song seekForASong(String songTitle) {
        ListIterator<Album> albumListIterator = this.albumsList.listIterator();
        while (albumListIterator.hasNext()) {
            Album checkedAlbum = albumListIterator.next();
            LinkedList<Song> tempSongList = checkedAlbum.getSongsList();
            for (int i = 0; i < tempSongList.size(); i++) {
                if (tempSongList.get(i).getTitle().equals(songTitle)) {
                    return tempSongList.get(i);
                }
            }
        }

        System.out.println("Song not found! Cannot add!");
        return null;
    }

    public boolean addSong(String albumName, String songTitle, String songDuration) {
        Album album = findAlbum(albumName);
        if (album != null) {
            return album.newSongOnAlbum(songTitle, songDuration);
        }
        return false;
    }


    private Album findAlbum(String albumName) {
        ListIterator<Album> albumListIterator = this.albumsList.listIterator();
        while (albumListIterator.hasNext()) {
            Album checkedAlbum = albumListIterator.next();
            if (checkedAlbum.getName().equals(albumName)) {
                return checkedAlbum;
            }
        }
        return null;
    }

    public boolean listAlbums(boolean showSongs) {
        ListIterator<Album> albumListIterator = this.albumsList.listIterator();
        while (albumListIterator.hasNext()) {
            Album checkedAlbum = albumListIterator.next();
            System.out.println("Album Title: " + checkedAlbum.getName());
            if (showSongs == true) {

                LinkedList<Song> tempSongList = checkedAlbum.getSongsList();
                ListIterator<Song> songListIterator = tempSongList.listIterator();
                System.out.println("Songs list:");
                while (songListIterator.hasNext()) {

                    System.out.println((songListIterator.nextIndex() + 1) + " " +
                            songListIterator.next().getTitle() + "\t"
                            + songListIterator.previous().getDuration());
                    songListIterator.next();
                }
            }
        }
        return false;
    }

}
