package albumcollection.album;

import java.io.Serializable;

/**
 * A simple representation of a Cassette Tape
 * Extends <b><code>Album</code></b> and Implements <b><code>Serializable</code></b> and <b><code>IPlayable</code></b>
 *
 * @author Zachary Goldberg
 */
public class CassetteTape extends Album implements Serializable, IPlayable{

   private double lengthInSeconds;
   private double currentPosition;

   /**
    * A default constructor.
    */
   public CassetteTape(){
      lengthInSeconds = 0.0;
      currentPosition = 0.0;
   }

   /**
    * A constructor that initializes <b>lengthInSeconds</b>
    * @param lengthInSeconds a <b><code>Double</code></b> that is the length of the <b><code>CassetteTape</code></b>
    */
   public CassetteTape(double lengthInSeconds){
      this.lengthInSeconds = lengthInSeconds;
      currentPosition = 0.0;
   }

   /**
    * A getter for lengthInSeconds
    * @return a <b><code>Double</code></b> that is the length in seconds of the <b><code>CassetteTape</code></b>
    */
   public double getLengthInSeconds(){
      return lengthInSeconds;
   }

   /**
    * A getter for currentPosition
    * @return a <b><code>Double</code></b> that is the current position of the <b><code>CassetteTape</code></b>
    */
   public double getCurrentPosition(){
      return currentPosition;
   }

   /**
    * A mutator for lengthInSeconds
    * @param lengthInSeconds  a <b><code>Double</code></b> that is the length in seconds of the <b><code>CassetteTate</code></b>
    */
   public void setLengthInSeconds(double lengthInSeconds){this.lengthInSeconds = lengthInSeconds;}

   /**
    * A simple function to simulate playing a <b><code>CassetteTape</code></b>
    */
   @Override
   public void play(){
      System.out.println("Playing " + getTitle() + " by " + getArtist());
   }

   /**
    * A simple function to simulate rewinding a <b><code>CassetteTape</code></b>
    */
   @Override
   public void rewind(){
      currentPosition = 0.0;
   }

   /**
    * A simple function to simulate fast forwarding a <b><code>CassetteTape</code></b>
    */
   @Override
   public void fastForward(){currentPosition += lengthInSeconds/6;}

   /**
    * Overrides the <b><code>toString</code></b> function in the <b><code>Album</code></b> class to include more information
    * @return a <b><code>String</code></b> that is a readable form of the <b><code>CassetteTape</code></b>
    */
   @Override
   public String toString(){
      String out = "Title: " + getTitle() + ", Artist: " + getArtist() + ", Year: " + getReleaseYear() + ", Genre: " + getGenre() +
                  ", Format Cassette Tape" + ", Runtime: " + lengthInSeconds + " seconds";
      return out;
   }

}
