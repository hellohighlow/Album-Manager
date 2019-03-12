package albumcollection;

import albumcollection.album.*;

import java.io.*;
import java.util.*;

/**
 * This class handles the management of the <code>AlbumCollection</code>.
 * It uses a <b><code>Serialized</code></b> file, "database.dat", to persist the collection information.
 * It contains an <code>ArrayList</code> called <code>collection</code> to store the
 * database in a runtime friendly data structure. This class provides all methods for
 * working with the AlbumCollection.
 * Implements <b><code>Serializable</code></b>
 *
 * @author Zachary Goldberg
 */
public class AlbumCollection implements Serializable{
   private ArrayList<Album> collection;
   private static final String DATABASE = "./src/database.dat";

   /**
    * This constructor creates an empty ArrayList then calls the
    * <code>load()</code> method to populate albums previously stored.
    */
   public AlbumCollection(){
      collection = new ArrayList<Album>();
      load();
   }

   /**
    * Private method that loads the Albums from the database to
    * the <code>ArrayList</code> collection.
    */
   private void load(){
      try {
         ObjectInputStream inputStream = new ObjectInputStream((new FileInputStream(DATABASE)));
         collection = (ArrayList<Album>) inputStream.readObject();
         sort();
      }catch(Exception e){System.out.println("File not found!");}
   }

   /**
    * This method prints out the contents of collection
    * to standard input.
    */
   public void display(){
      for(Album a : collection) {
         System.out.println(a.toString());
      }
   }

   /**
    * This method creates a new Album and stores it in collection.
    * Album information is taken from user input.
    */
   public void addAlbum(){
      Album temp;
      Scanner scan = new Scanner(System.in);
      String type;
      do {
         System.out.println("Is this a CD or a Cassette");
         type = scan.nextLine();
         type = type.toUpperCase();
      }while(!(type.equals("CD") || type.equals("CASSETTE")));
      switch (type) {
         case ("CD"):
            temp = new CompactDisk();
            System.out.println("Enter artist name");
            temp.setArtist(scan.nextLine());
            System.out.println("Enter album title");
            temp.setTitle(scan.nextLine());
            do {
               System.out.println("Enter genre (ROCK, RAP, COUNTRY, POP)");
            }while(!temp.setGenre(scan.nextLine()));
            do{
               System.out.println("Enter release year (0-9999)");
            }while(!temp.setReleaseYear(scan.nextLine()));
            System.out.println("How many tracks?");
            int tracks = Integer.parseInt(scan.nextLine());
            for(int i = 0; i < tracks; i++){
               System.out.println("Please enter track title");
               String title = scan.nextLine();
               System.out.println("Please enter track length in seconds");
               Double time = Double.parseDouble(scan.nextLine());
               ((CompactDisk) temp).addTrack(new Track(time, title));
            }
            break;
         case ("CASSETTE"):
            temp = new CassetteTape();
            System.out.println("Enter artist name");
            temp.setArtist(scan.nextLine());
            System.out.println("Enter album title");
            temp.setTitle(scan.nextLine());
            do {
               System.out.println("Enter genre (ROCK, RAP, COUNTRY, POP)");
            }while(!temp.setGenre(scan.nextLine()));
            do{
               System.out.println("Enter release year (0-9999)");
            }while(!temp.setReleaseYear(scan.nextLine()));
            System.out.println("Enter length in seconds");
            ((CassetteTape) temp).setLengthInSeconds(Double.parseDouble(scan.nextLine()));
            break;
         default:
            System.out.println("Invalid entry");
            temp = new Album();
            break;
      }
      collection.add(temp);
      sort();
   }

   /**
    * This method is a simple selection sort, which sorts the contents
    * of collection.
    */
   private void sort(){
      if(collection.size() <= 1) return;
      for(int i = 0; i < collection.size()-1; i++){
         if((collection.get(i)).compareTo(collection.get(i+1)) == 1){
            Album temp = new Album();
            temp.equals(collection.get(i+1));
            collection.get(i+1).equals(collection.get(i));
            collection.get(i).equals(temp);
         }
         if((collection.get(i)).compareTo(collection.get(i+1)) == -1){
            for(int x = i; x > 0; x--){
               if((collection.get(x)).compareTo(collection.get(x-1)) == -1){
                  Album temp = new Album();
                  temp.equals(collection.get(x-1));
                  collection.get(x-1).equals(collection.get(x));
                  collection.get(x).equals(temp);
               }
               else break;
            }
         }
      }
   }

   /**
    * This method searches through collection to find a whole, or partial, match for the
    * provided key.
    *
    * @param key a <b><code>String</code></b> that is the whole or partial match.
    * @return an <b><code>ArrayList</code></b> that contains all the whole, or partial, matches.
    */
   public ArrayList<Album> search(String key){
      ArrayList<Album> ret = new ArrayList<Album>();
      for(int i = 0; i < collection.size(); i++){
         if(collection.get(i).getArtist().toUpperCase().contains(key.toUpperCase()) ||
               collection.get(i).getTitle().toUpperCase().contains(key.toUpperCase())) {
            ret.add(collection.get(i));
         }
      }
      return ret;
   }

   /**
    * This method searches through collection to find a whole, or partial, match for the
    * provided key, then provides a list of possible matches, then deletes the chosen Album.
    * @param key a <b><code>String</code></b> that is the whole, or partial, match.
    */
   public void delete(String key) {
      ArrayList<Album> ret = this.search(key);
      int i = 0;
      if(ret.size() == 0){
         System.out.println("Nothing Found");
         return;
      }
      for (Album a : ret) {
         i++;
         System.out.println(i + 1 + ") " +a);
      }
      System.out.println("Which would you like to delete (Enter number title)");
      Scanner scanner = new Scanner(System.in);
      String choice = scanner.nextLine();
      collection.remove(ret.get(Integer.parseInt(choice)-1));
      System.out.println("Album deleted!");
   }

   /**
    * This method writes the <code>ArrayList</code> collection to the file "database.dat".
    */
   public void exit(){
      try{
         ObjectOutputStream outputStream = new ObjectOutputStream((new FileOutputStream(DATABASE)));
         outputStream.writeObject(collection);
         outputStream.close();
      }catch(IOException e){System.out.println("File not found!");}
   }
}
