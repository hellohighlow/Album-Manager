package albumcollection;

import java.io.*;
import java.util.*;

/**
 * This class handles the management of the <code>album</code> collection.
 * It uses a plain-text file, "database.txt", to persist the collection information.
 * It contains an <code>ArrayList</code> called <code>collection</code> to store the
 * database in a runtime friendly data structure. This class provides all methods for
 * working with the album collection.
 *
 * @author Zachary Goldberg
 */
public class albumcollection {
   private ArrayList<album> collection;
   private static final String DATABASE = "./src/database.txt";
   private File file = new File(DATABASE);

   /**
    * This constructor creates an empty ArrayList then calls the
    * <code>load()</code> method to populate albums previously stored.
    */
   public albumcollection(){
      collection = new ArrayList<album>();
      load();
   }

   /**
    * Private method that loads the albums from the database to
    * the <code>ArrayList</code> collection.
    */
   private void load(){
      try {
         Scanner txt = new Scanner(file);
         while(txt.hasNextLine() && file.length() > 0){
            String cursor = txt.nextLine();
            String[] split = cursor.split("~");
            collection.add(new album(split[0], split[1], Integer.parseInt(split[2]), split[3]));
            this.sort();
         }
      }catch(Exception e){System.out.println("File not found!");}
   }

   /**
    * This method prints out the contents of collection
    * to standard input.
    */
   public void display(){
      for(album a : collection) {
         System.out.println(a);
      }
   }

   /**
    * This method creates a new album and stores it in collection.
    * album information is taken from user input.
    */
   public void addAlbum(){
      album tmp = new album();
      Scanner scan = new Scanner(System.in);
      System.out.print("Title: ");
      tmp.setTitle(scan.nextLine());
      System.out.print("Artist: ");
      tmp.setArtist(scan.nextLine());
      do{
         System.out.print("Release Year: ");
      }while(!tmp.setReleaseYear(scan.nextLine()));
      do {
         System.out.print("Please enter genre (ROCK, RAP, COUNTRY, or POP): ");
      }while(!tmp.setGenre(scan.nextLine()));
      if(collection.size() == 0){
         collection.add(tmp);
         return;
      }
      collection.add(tmp);
      this.sort();
   }

   /**
    * This method is a simple selection sort, which sorts the contents
    * of collection.
    */
   private void sort(){
      int i,j,min;
      for(i = 0; i < collection.size()-1; i++){
         min = i;
         for(j = i+1; j < collection.size(); j++){
            if(collection.get(min).getTitle().compareToIgnoreCase(collection.get(j).getTitle()) > 0){
               min = j;
            }
         }
         Collections.swap(collection, min,i);
      }
   }

   /**
    * This method searches through collection to find a whole, or partial, match for the
    * provided key.
    *
    * @param key a <b><code>String</code></b> that is the whole or partial match.
    * @return an <b><code>ArrayList</code></b> that contains all the whole, or partial, matches.
    */
   public ArrayList<album> search(String key){
      ArrayList<album> ret = new ArrayList<album>();
      for(int i = 0; i < collection.size(); i++){
         if(collection.get(i).getTitle().equalsIgnoreCase(key) || collection.get(i).getArtist().equalsIgnoreCase(key)) {
            ret.add(collection.get(i));
         }
         else if(collection.get(i).getArtist().toUpperCase().contains(key.toUpperCase()) ||
               collection.get(i).getTitle().toUpperCase().contains(key.toUpperCase())) {
            ret.add(collection.get(i));
         }
      }
      return ret;
   }

   /**
    * This method searches through collection to find a whole, or partial, match for the
    * provided key, then provides a list of possible matches, then deletes the chosen album.
    * @param key a <b><code>String</code></b> that is the whole, or partial, match.
    */
   public void delete(String key) {
      ArrayList<album> ret = this.search(key);
      int i = 0;
      for (album a : ret) {
         i++;
         System.out.println(i + ") " +a);
      }
      System.out.println("Which would you like to delete (Enter number title)");
      Scanner scanner = new Scanner(System.in);
      String choice = scanner.nextLine();
      collection.remove(ret.get(Integer.parseInt(choice)-1));
      System.out.println("Album deleted!");
   }

   /**
    * This method writes the <code>ArrayList</code> collection to the file "database.txt".
    */
   public void exit(){
      try{
         FileWriter fileWriter = new FileWriter(file);
         for(int i = 0; i < collection.size(); i++) {
            album tmp = collection.get(i);
            fileWriter.write(""+tmp.getArtist()+"~"+tmp.getTitle()+"~"+tmp.getReleaseYear()+"~"+tmp.getEGenre()+"\n");
            fileWriter.flush();
         }
         fileWriter.close();
      }catch(IOException e){System.out.println("File not found!");}
   }
}
