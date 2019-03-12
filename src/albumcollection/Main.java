package albumcollection;

import java.util.*;

/**
 * @author Zachary Goldberg
 * This is the main driver and tester class for the albumcollection package.
 */
public class Main {
   public static void main(String[] args) throws Exception{
      int choice;
      Scanner scanner;
      albumcollection ac = new albumcollection();
      do {
         System.out.println("1. Display	list	of	all	albums	in	the	collection.");
         System.out.println("2. Add	a	new	album	to	the	collection.");
         System.out.println("3. Search	for an	album	given	the	name	of	the	artist	or	title	of	the");
         System.out.println("album or	part	of	the	name	of	the	artist	or	title	of	the	album.");
         System.out.println("4. Delete	an	album	from	the	collection.");
         System.out.println("5. Exit	program.");
         scanner = new Scanner(System.in);
         choice = scanner.nextInt();
         scanner.nextLine();
         System.out.println("");
         switch(choice) {
            case (1): ac.display(); break;
            case(2): ac.addAlbum(); break;
            case(3): System.out.println("Enter search term");
            ArrayList<album> ret = ac.search(scanner.nextLine());
            for(int i = 0; i < ret.size(); i++){
               System.out.println(i + 1 +") "+ ret.get(i));
            }
            break;
            case(4): System.out.println("Enter search term"); ac.delete(scanner.nextLine()); break;
            case(5): System.out.println("Goodbye!");break;
            default: System.out.println("Invalid Input");
         }
      }while(choice != 5);
      ac.exit();
   }

}
