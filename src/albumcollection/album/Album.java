package albumcollection.album;

import java.io.Serializable;

/**
 * Enumerator of <code>MusicGenre</code> to fill <code>genre</code> field .
 */
enum MusicGenre{
   ROCK, RAP, COUNTRY, POP
}

/**
 * This is a simple representation of an Album.
 * @author Zachary Goldberg
 */
public class Album implements IComparable, IPlayable, Serializable {
   private String title;
   private String artist;
   private int releaseYear;
   private MusicGenre genre;

   /**
    * Basic Empty constructor that initializes an empty Album.
    */
   public Album(){}

   /**
    * This constructor initializes the Album object. The constructor provides input validation through
    * other methods.
    *
    * @param artist a <b><code>String</code></b> that represents the artist's name.
    * @param title a <b><code>String</code></b> that represents the Album title.
    * @param releaseYear an <b><code>int</code></b> that represents the year of the Album's release.
    * @param genre a <b><code>String</code></b> that represents the genre of the Album.
    */
   public Album(String artist, String title, int releaseYear, String genre){
      this.title = title;
      this.artist = artist;
      switch(Integer.parseInt(genre)){
         case 0: this.genre = MusicGenre.ROCK;
         case 1: this.genre = MusicGenre.RAP;
         case 2: this.genre = MusicGenre.POP;
         case 3: this.genre = MusicGenre.COUNTRY;
      }
      this.setReleaseYear(Integer.toString(releaseYear));
   }

   /**
    * This method returns the Album's title.
    * @return a <b><code>String</code></b> that is the Album's title.
    */
   public String getTitle() {
      return title;
   }

   /**
    * This method returns the Album's release year.
    * @return an <b><code>int</code></b> that is the Album's release year.
    */
   public int getReleaseYear() {
      return releaseYear;
   }

   /**
    * This method returns the Album's genre.
    * @return a <b><code>String</code></b> that is the Album's genre.
    */
   public String getGenre() {
      switch(this.genre) {
         case ROCK: return "Rock";
         case POP: return "Pop";
         case COUNTRY: return "Country";
         case RAP: return "Rap";
      }
      return "";
   }

   /**
    * This method returns the Album's title.
    * @return a <b><code>String</code></b> that is the Album's title.
    */
   public String getArtist(){
      return artist;
   }

   /**
    * This method sets the artist's name.
    * @param artist a <b><code>String</code></b> that is the artist's name.
    */
   public void setArtist(String artist) {
      this.artist = artist;
   }

   /**
    * This method sets the Album's genre.
    * @param genre a <b><code>String</code></b> that is the artist's genre.
    * @return a <b><code>boolean</code></b> that tells if the input is valid.
    */
   public boolean setGenre(String genre) {
      switch(genre.toUpperCase()){
         case("ROCK"): this.genre = MusicGenre.ROCK; return true;
         case("POP"): this.genre = MusicGenre.POP; return true;
         case("COUNTRY"): this.genre = MusicGenre.COUNTRY; return true;
         case("RAP"): this.genre = MusicGenre.RAP; return true;
      }
      return false;
   }

   /**
    * This method sets the Album's release year.
    * @param releaseYear a <b><code>String</code></b> of the release year.
    * @return a <b><code>boolean</code></b> that tells if the input is valid.
    */
   public boolean setReleaseYear(String releaseYear) {
      int tmp = Integer.parseInt(releaseYear);
      if(releaseYear.matches("[0-9]{1,4}")){
         this.releaseYear = tmp;
         return true;
      }
      return false;
   }

   /**
    * This method sets the Album's title.
    * @param title a <b><code>String</code></b> that is the Albums's title.
    */
   public void setTitle(String title) {
      this.title = title;
   }

   /**
    * This method overrides default toString().
    * @return a <b><code>String</code></b> that is the Album's information.
    */
   @Override
   public String toString(){
      String out = "Title: " + title + ", Artist: " + artist + ", Year: " + releaseYear + ", Genre: " + this.getGenre();
      return out;
   }

   /**
    * This method is from the IComparable interface.
    * @param a an <b><code>Album</code></b> that is the Album to compare this Album to.
    * @return an <b><code>int</code></b> that is whether the Albums matches (0), is bigger(1), or is less than(-1).
    */
   @Override
   public int compareTo(Album a){
      char[] artist = (this.artist.toUpperCase()).toCharArray();
      char[] aartist = (a.getArtist().toUpperCase()).toCharArray();
      for(int i = 0; i < this.artist.length(); i++){
         if(artist[i] < aartist[i])
            return -1;
         if(artist[i] > aartist[i])
            return 1;
      }
      return 0;
   }

   /**
    * This method adds a deep copy for Albums
    * @param a an <b><code>Album</code></b> that is copied.
    */
   public void equals(Album a){
      this.artist = a.getArtist();
      this.title = a.getTitle();
      this.releaseYear = a.getReleaseYear();
      setGenre(a.getGenre());
   }

   /**
    * This is a stub for the play method
    */
   public void play(){}

   /**
    * This is a stub for the rewind method
    */
   public void rewind(){}

   /**
    * This is a stub for the fastForward method
    */
   public void fastForward(){}

   /**
    * This is a stub for the skipToNext method
    */
   public void skipToNext(){}

   /**
    * This is a stub for the previousTrack method
    */
   public void previousTrack(){}
}
