/* This is a stub for the Library class */
import java.nio.file.FileAlreadyExistsException;
import java.util.Hashtable;
public class Library extends Building{
  
    private Hashtable<String, Boolean> collection = new Hashtable<String, Boolean>();

    //overload #1
    public Library(String name, String address){
        super(name, address);
        System.out.println("You have built a library that is not build yet: 📖");
    }

    //overload #2
    public Library(String name, String address, Hashtable nBooks){
        super(name, address);
        this.collection = nBooks;
        System.out.println("You have built a library that has 100 books: 📖, and you have books like " + nBooks);
    }

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      System.out.println("You have built a library: 📖");
    }
    
    //Write methods to update the HashTable containing the collection every time we add/remove a title
    public void addTitle(String title){
      this.collection.put(title, true);
    }

    // return the title that we removed
    public String removeTitle(String title){
      this.collection.remove(title);
      return title;
    }

    //check a book out or return it
    public void checkOut(String title){
      this.collection.replace(title, false);
    }
    public void returnBook(String title){
      this.collection.replace(title, true);
    }
   
    // returns true if the title appears as a key in the Libary's collection, false otherwise
    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    }

     // returns true if the title is currently available, false otherwise
    public boolean isAvailable(String title){
      return this.collection.containsKey(title) && this.collection.get(title) == true;
    }

    // prints out the entire collection in an easy-to-read way (including checkout status)
    public void printCollection(){
      System.out.println(this.collection);
    }

    //wrote showOptions for Library
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook()\n + containsTitle()\n + isAvailable()\n + printCollection()\n" );
    }

    //override goToFloor
    public void goToFloor(int floorNum) {
        System.out.println("You are now on " + this.name + "'s floor " + floorNum);
        super.goToFloor(floorNum);
    }



    public static void main(String[] args) {
      Library NeilsonLibrary = new Library("Neilson Library", "Elm Street", 5);
      NeilsonLibrary.addTitle("of Human Bondage");
      NeilsonLibrary.addTitle("The Razor's Edge");
      NeilsonLibrary.checkOut("The Razor's Edge");
      NeilsonLibrary.addTitle("How to learn cs without losing your hair?");
      NeilsonLibrary.printCollection();
      NeilsonLibrary.showOptions();
      NeilsonLibrary.enter();
      NeilsonLibrary.goToFloor(4);
      System.out.println(NeilsonLibrary);
      Library earthLibrary = new Library("Earth Library", "universe");
      System.out.println(earthLibrary);
      Hashtable<String, Boolean> moonBooks = new Hashtable<String, Boolean>();
      moonBooks.put("Little women", true);
      moonBooks.put("The Bronze Horseman", true);
      Library moonLibrary = new Library("Moon Library", "universe", moonBooks);
      System.out.println(moonLibrary);
    }
}