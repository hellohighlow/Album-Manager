package albumcollection;

import albumcollection.album.Album;
import java.util.*;

/**
 * The <b><code>Menu</code></b> for the <b><code>albumcollection</code></b> package
 *
 * @author Zachary Goldberg
 */
public class Menu {
   public Menu(){}
   public void run() {
      int choice;
      AlbumCollection ac = new AlbumCollection();
      Scanner scanner = new Scanner(System.in);
      do {
         System.out.println("1. Display	list	of	all	albums	in	the	collection.");
         System.out.println("2. Add	a	new	album	to	the	collection.");
         System.out.println("3. Search	for an	album	given	the	name	of	the	artist	or	title	of	the");
         System.out.println("album or	part	of	the	name	of	the	artist	or	title	of	the	album.");
         System.out.println("4. Delete	an	album	from	the	collection.");
         System.out.println("5. Play an album.");
         System.out.println("6. Exit	program.");
         choice = Integer.parseInt(scanner.nextLine());
         System.out.println("");
         switch (choice) {
            case (1):
               ac.display();
               break;
            case (2):
               ac.addAlbum();
               break;
            case (3):
               System.out.println("Enter search term");
               ArrayList<Album> ret = ac.search(scanner.nextLine());
               for (int i = 0; i < ret.size(); i++) {
                  System.out.println(i + 1 + ") " + ret.get(i));
               }
               break;
            case (4):
               System.out.println("Enter search term");
               ac.delete(scanner.nextLine());
               break;
            case (5):
               System.out.println("What album would you like to listen to?");
               System.out.println("Enter search term");
               ArrayList<Album> list = ac.search(scanner.nextLine());
               for (int i = 0; i < list.size(); i++) {
                  System.out.println(i + 1 + ") " + list.get(i));
               }
               Album loadedAlbum = list.get(Integer.parseInt(scanner.nextLine()) - 1);
               int player = 0;
               do {
                  System.out.println("1) Play");
                  System.out.println("2) Fast forward");
                  System.out.println("3) Rewind");
                  System.out.println("4) Skip to next track (If album is a CD)");
                  System.out.println("5) Skip to previous track (If album is a CD)");
                  System.out.println("6) Exit player");
                  player = Integer.parseInt(scanner.nextLine());
                  switch (player) {
                     case (1):
                        loadedAlbum.play();
                        break;
                     case (2):
                        loadedAlbum.fastForward();
                        break;
                     case (3):
                        loadedAlbum.rewind();
                        break;
                     case (4):
                        loadedAlbum.skipToNext();
                        break;
                     case (5):
                        loadedAlbum.previousTrack();
                        break;
                     case (6):
                        break;
                     default:
                        System.out.println("Invalid input!");
                        break;
                  }
               } while (player != 6);
            case (6):
               System.out.println("Goodbye!");
               break;
            default:
               System.out.println("Invalid Input");
               break;
         }
      } while (choice != 6);
      ac.exit();
   }
}