package albumcollection.album;

/**
 * A simple interface to replace <b><code>Comparable</code></b>
 *
 * @author Zachary Goldberg
 */
public interface IComparable {

   /**
    * A stub for <b><code>compareTo()</code></b>
    * @param a an <b><code>Album</code></b> that is being compared
    * @return an <b><code>int</code></b> that tells whether this <b><code>Album</code></b>
    *          is less than(-1), greater than(1), or equal to(0) <b><code>Album</code></b> a
    */
   public int compareTo(Album a);
}
