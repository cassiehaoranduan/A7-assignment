import java.util.ArrayList;
import java.util.Hashtable;
public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        
        //add house, cafe, and library to the campus map
        myMap.addBuilding(new Building("Seelye Hall", "100 Green Street Northampton, MA 01063", 3));
        myMap.addBuilding(new House("Albright", "Some Street Northampton, MA 01063", 3));
        myMap.addBuilding(new House("Chase House", "Some Street Northampton, MA 01063", 4, true));
        myMap.addBuilding(new House("Duckett House", "Some Street Northampton, MA 01063", 5, true, true));
        myMap.addBuilding(new House("Chapin House", "Center Road at Northampton, MA 01063", 3, true, false));
        myMap.addBuilding(new Cafe("Campus Cafe", "100 Green Street Northampton, MA 01063", 1));
        myMap.addBuilding(new Cafe("Center Cafe", "Center Road at Northampton, MA 01063", 40, 10));
        myMap.addBuilding(new Cafe("Neilson Cafe", "Neilson Library Northampton, MA 01063", 2));
        Library liLibrary = new Library("Li Library", "100 Green Street Northampton, MA 01063", 10);
        myMap.addBuilding(liLibrary);
        myMap.removeBuilding(liLibrary);
        Hashtable<String, Boolean> duanBooks = new Hashtable<String, Boolean>();
        duanBooks.put("Little women by Duan", true);
        duanBooks.put("The Bronze Horseman by Duan translate version", true);
        myMap.addBuilding(new Library("Duan Library", "100 Green Street Northampton, MA 01063", duanBooks));
        Hashtable<String, Boolean> youngBooks = new Hashtable<String, Boolean>();
        youngBooks.put("How to learn cs #1", true);
        duanBooks.put("How to learn cs #2", true);
        myMap.addBuilding(new Library("Young Library", "100 Green Street Northampton, MA 01063", youngBooks));









        System.out.println(myMap);
    }
    
}
