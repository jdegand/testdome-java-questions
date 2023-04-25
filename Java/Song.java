public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isInRepeatingPlaylist() {
     
      Song song1 = this;       
      Song song2 = this; 

      while (song2 != null && song2.nextSong != null) {
         song1 = song1.nextSong;
         song2 = song2.nextSong.nextSong;
         
        if (song1 == song2) {
           return true;
         }
      }
      return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isInRepeatingPlaylist());
    }
}
