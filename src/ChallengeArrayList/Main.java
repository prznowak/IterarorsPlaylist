package ChallengeArrayList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static Playlist playlist = new Playlist("moja");

    public static void main(String[] args) {


        playlist.addAlbum("Kwasy");
        playlist.addSong("Kwasy", "spiewanko", "4:35");
        playlist.addSong("Kwasy", "grubasy", "3:35");
        playlist.addSong("Kwasy", "barany", "4:23");

        playlist.addAlbum("Kwasy2");
        playlist.addSong("Kwasy2", "snananan", "1:35");
        playlist.addSong("Kwasy2", "lalalasyy", "2:35");
        playlist.addSong("Kwasy2", "brudasy", "1:23");
        playlist.addSong("Kwasy2", "pizmoki", "2:23");
        playlist.addSong("Kwasy2", "danroby", "5:23");

        playlist.addAlbum("Kwasy3");
        playlist.addSong("Kwasy3", "proznioki", "8:11");
        playlist.addSong("Kwasy3", "ananasy", "2:35");
        playlist.addSong("Kwasy3", "banany", "3:13");

        playlist.listAlbums(true);

        System.out.println("===============================================");
        playlist.createOwnPlaylist("grubasy");
        playlist.createOwnPlaylist("brudasy");
        playlist.createOwnPlaylist("ananasy");
        playlist.createOwnPlaylist("danroby");
        playlist.createOwnPlaylist("sssss");
        playlist.showOwnPlaylist();

        System.out.println("=====================================");
        // playlist.deleteFromPlaylist("brudasy");
        playlist.showOwnPlaylist();
        startPlaylist();

    }

    private static void printInstructions() {
        System.out.println("\n");
        System.out.println("0 - Quit the playlist application");
        System.out.println("1 - Start playing first song");
        System.out.println("2 - Play next song");
        System.out.println("3 - Play previous song");
        System.out.println("4 - Replay current song");
        System.out.println("5 - Print instructions");
    }

    private static void startPlaylist() {
        printInstructions();
        int option;
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        LinkedList<Song> tempPlaylist = playlist.getOwnPlaylist();
        ListIterator<Song> songListIterator = tempPlaylist.listIterator();

        while (!quit) {
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (songListIterator.hasNext()) {
                        System.out.println("Now playing " + songListIterator.next().getTitle());
                    } else {
                        System.out.println("No songs on playlist");
                    }
                    break;
                case 2:
                    //next song
                    if (songListIterator.hasNext()) {
                        System.out.println(" Next song! Now playing " + songListIterator.next().getTitle());
                    } else {
                        System.out.println("No next song to play, keep playing " + songListIterator.previous().getTitle());
                        songListIterator.next();
                    }
                    break;
                case 3:
                    //previous song
                    if (songListIterator.hasPrevious()) {
                        songListIterator.previous();
                        if (songListIterator.hasPrevious()) {
                            System.out.println("Previous song! Now playing " + songListIterator.previous().getTitle());
                            songListIterator.next();
                        } else {
                            System.out.println("No previous song");
                        }
                    } else {
                        System.out.println("No previous song ");
                    }
                    break;
                case 4:
                    //replay song
                    if (songListIterator.hasPrevious()) {
                        System.out.println(" Replay ! Now playing " + songListIterator.previous().getTitle());
                        songListIterator.next();
                    } else {
                        System.out.println("Other error");
                    }
                    break;
                case 5:
                    printInstructions();
                    break;
            }
        }
    }
}
