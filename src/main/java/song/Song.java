package song;

import java.util.HashSet;
import java.util.Set;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
        Set<Song> uniqueSongs=new HashSet<>();
        uniqueSongs.add(this);
        Song next = this.nextSong;
        while (next != null) {
            if (uniqueSongs.contains(next)) {
                return true;
            }
            uniqueSongs.add(next);
            next = next.nextSong;
        }
        return false;
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}
