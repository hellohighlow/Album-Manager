package albumcollection;

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
public class album {
   private String title;
   private String artist;
   private int releaseYear;
   private MusicGenre genre;

   /**
    * Basic Empty constructor that initializes an empty album.
    */
   public album(){}

   /**
    * This constructor initializes the album object. The constructor provides input validation through
    * other methods.
    *
    * @param artist a <b><code>String</code></b> that represents the artist's name.
    * @param title a <b><code>String</code></b> that represents the album title.
    * @param releaseYear an <b><code>int</code></b> that represents the year of the album's release.
    * @param genre a <b><code>String</code></b> that represents the genre of the album.
    */
   public album(String artist, String title, int releaseYear, String genre){
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
    * This method returns the album's title.
    * @return a <b><code>String</code></b> that is the album's title.
    */
   public String getTitle() {
      return title;
   }

   /**
    * This method returns the album's release year.
    * @return an <b><code>int</code></b> that is the album's release year.
    */
   public int getReleaseYear() {
      return releaseYear;
   }

   /**
    * This method returns the album's genre.
    * @return a <b><code>String</code></b> that is the album's genre.
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
    * This method returns the album's title.
    * @return a <b><code>String</code></b> that is the album's title.
    */
   public String getArtist(){
      return artist;
   }

   /**
    * This method returns the album's genre.
    * @return an <b><code>int</code></b> that is the album's genre.
    */
   public int getEGenre(){
      switch(genre){
         case ROCK: return 0;
         case RAP: return 1;
         case POP: return 2;
         case COUNTRY: return 3;
      }
      return 0;
   }

   /**
    * This method sets the artist's name.
    * @param artist a <b><code>String</code></b> that is the artist's name.
    */
   public void setArtist(String artist) {
      this.artist = artist;
   }

   /**
    * This method sets the album's genre.
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
    * This method sets the album's release year.
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
    * This method sets the album's title.
    * @param title a <b><code>String</code></b> that is the albums's title.
    */
   public void setTitle(String title) {
      this.title = title;
   }

   /**
    * This method overrides default toString().
    * @return a <b><code>String</code></b> that is the album's information.
    */
   @Override
   public String toString(){
      String out = "Title: " + title + ", Artist: " + artist + ", Year: " + releaseYear + ", Genre: " + this.getGenre();
      return out;
   }
}
