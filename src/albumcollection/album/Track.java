package albumcollection.album;
import java.io.Serializable;

/**
 * A simple representation fo an audio <b><code>Track</code></b>
 * Implements <b><code>IPlayable</code></b> and <b><code>Serializable</code></b>
 *
 * @author Zachary Goldberg
 */
public class Track  implements IPlayable, Serializable {

   private double lengthInSeconds;
   private double currentPosition;
   private String title;

   /**
    * A constructor for a <b><code>Track</code></b>
    * @param lengthInSeconds a <b><code>Double</code></b> that is the length of the <b><code>Track</code></b>
    * @param title a <b><code>String</code></b> that is the title of the <b><code>Track</code></b>
    */
   public Track(double lengthInSeconds, String title){
      this.title = title;
      this.lengthInSeconds = lengthInSeconds;
      currentPosition = 0;
   }

   /**
    * a getter for the current position of the <b><code>Track</code></b>
    * @return a <b><code>Double</code></b> that is the current position of the <b><code>Track</code></b>
    */
   public double getCurrentPosition() {
      return currentPosition;
   }

   /**
    * a getter for the length in seconds of the <b><code>Track</code></b>
    * @return a <b><code>Double</code></b> that is the length in seconds of the <b><code>Track</code></b>
    */
   public double getLengthInSeconds() {
      return lengthInSeconds;
   }

   /**
    * a getter for the title of the <b><code>Track</code></b>
    * @return a <b><code>String</code></b> that is the title of the <b><code>Track</code></b>
    */
   public String getTitle(){return title;}

   /**
    * A method that simulates playing the <b><code>Track</code></b>
    */
   @Override
   public void play(){
      System.out.println("Playing: " + title);
   }

   /**
    * A method that simulates rewinding the <b><code>Track</code></b>
    */
   @Override
   public void rewind(){
      currentPosition = 0;
   }

   /**
    * A method that simulates fast forwarding the <b><code>Track</code></b>
    */
   @Override
   public void fastForward(){currentPosition += lengthInSeconds/6;}

   /**
    * A method that does nothing
    */
   @Override
   public void skipToNext() {}

   /**
    * A method that does nothing
    */
   @Override
   public void previousTrack() {}
}
