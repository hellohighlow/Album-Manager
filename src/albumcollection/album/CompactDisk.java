package albumcollection.album;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A simple representation of a Compact disk
 * Extends <b><code>Album</code></b> and Implements <b><code>Serializable</code></b> and <b><code>IPlayable</code></b>
 *
 * @author Zachary Goldberg
 */
public class CompactDisk extends Album implements Serializable, IPlayable {

   private ArrayList<Track> tracks;
   private int currentIndex;

   /**
    * A default constructor for a <b><code>CompactDisk</code></b>
    */
   public CompactDisk(){
      currentIndex = 0;
      tracks = new ArrayList<Track>();
   }

   /**
    * A getter for current index
    * @return an <b><code>int</code></b> that is the current index in the <b><code>CompactDisk</code></b>
    */
   public int getCurrentIndex(){
      return currentIndex;
   }

   /**
    * A method to add a new <b><code>Track</code></b> to the <b><code>CompactDisk</code></b>
    * @param track a <b><code>Track</code></b> that belongs on the <b><code>CompactDisk</code></b>
    */
   public void addTrack(Track track){
      tracks.add(track);
   }

   /**
    * Simulates playing a <b><code>CompactDisk</code></b>
    */
   @Override
   public void play(){
      System.out.println("Playing from CD: " + getTitle() + " by " + getArtist());
      tracks.get(currentIndex).play();
   }

   /**
    * Simulates skipping to next <b><code>Track</code></b> on a <b><code>CompactDisk</code></b>
    */
   @Override
   public void skipToNext() {
      if(currentIndex < tracks.size()) {
         currentIndex++;
         return;
      }
      currentIndex = 0;
   }

   /**
    * Simulates skipping to previous <b><code>Track</code></b> on a <b><code>CompactDisk</code></b>
    */
   @Override
   public void previousTrack() {
      if(currentIndex > 0){
         currentIndex--;
         return;
      }
      currentIndex = tracks.size()-1;
   }

   /**
    * Calls fast forward on the current <b><code>Track</code></b> on the <b><code>CompactDisk</code></b>
    */
   @Override
   public void fastForward() {
      tracks.get(currentIndex).fastForward();
   }

   /**
    * Calls rewind on the current <b><code>Track</code></b> on the <b><code>CompactDisk</code></b>
    */
   @Override
   public void rewind() {
      tracks.get(currentIndex).rewind();
   }

   /**
    * Overrides the <b><code>toString()</code></b> method in <b><code>Album</code></b> to include <b><code>CompactDisk</code></b> information
    * @return a <b><code>String</code></b> that is a readable version of this <b><code>CompactDisk</code></b>
    */
   @Override
   public String toString(){
      String out = "Title: " + getTitle() + ", Artist: " + getArtist() + ", Year: " + getReleaseYear() + ", Genre: " + getGenre()
            + ", Format: CD" + ", # of tracks: " + tracks.size();
      return out;
   }
}
