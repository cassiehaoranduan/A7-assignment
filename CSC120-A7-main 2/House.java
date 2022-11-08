/* This is a stub for the House class */
import java.util.ArrayList;
import java.util.jar.Attributes.Name;
public class House extends Building{

    private ArrayList<String> residents;
    private boolean hasDiningRoom;
    private boolean hasELevator;

    //overload #1
    public House(String name, String address, int nFloors){
        super(name, address, nFloors);
        this.residents = new ArrayList<String>();
        this.hasDiningRoom = true;
        this.hasELevator = true;
        System.out.println("You have built a house with a dining room and elevator: 🏠");
    }

    //overload #2
    public House(String name, String address, int nFloors, boolean hasDiningRoom){
        super(name, address, nFloors);
        this.residents = new ArrayList<String>();
        this.hasDiningRoom = hasDiningRoom;
        this.hasELevator = false;
        System.out.println("You have built a house with a dining room but don't have an elevator: 🏠");
    }

    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasELevator) {
        super(name, address, nFloors);
        this.residents = new ArrayList<String>();
        this.hasDiningRoom = hasDiningRoom;
        this.hasELevator = hasELevator;
        System.out.println("You have built a house: 🏠");
    }

  
    //Write the following accessors to retrieve the indicated values
    public boolean hasDiningRoom(){
      return this.hasDiningRoom;
    }
    public int nResidents(){
      return this.residents.size();
    }

    //Write methods to update the ArrayList of residents every time someone moves in
    public void moveIn(String name){
        this.residents.add(name);
    }

    //Write methods to update the ArrayList of residents every time someone moves out
    public String moveOut(String name){
        this.residents.remove(name);
        return name;
    }

    //write a boolean method that tells us whether or not a given person is a resident of the House
    public boolean isResident(String person){
        return this.residents.contains(person);
    }

    //wrote showOptions for House
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + hasDiningRoom() \n + nResidents() \n + moveIn() \n + moveOut()\n + isResident(n)");
    }

    //override goToFloor
    public void goToFloor(int floorNum){
        if(hasELevator == true){
            System.out.println("You are now on " + this.name + "'s floor " + floorNum);
            super.goToFloor(floorNum);
        }else {
            System.out.println("You are now on " + this.name + "'s floor " + activeFloor + " , and you want to go to floor " + floorNum);
            if(activeFloor == floorNum + 1 || activeFloor == floorNum - 1){
                System.out.println("You are now on " + this.name + "'s floor " + floorNum);
                activeFloor = floorNum;
            }else {
                throw new RuntimeException("You don't have an elevator, please call goUp or goDown.");
            }
        }
    }
    

    // overide toString
    public String toString() {
        return "Welcome!! " + this.name + " is a " + this.nFloors + "-story building located at " + this.address + ", and has " + this.nResidents() + " students live in here! Come and visit our residents!";
    }

    public static void main(String[] args) {
        House Albright = new House("Albright", "Elm Street", 4, false, false);
        System.out.println(Albright);
        Albright.showOptions();
        Albright.enter();
        Albright.goToFloor(2);
        Albright.goDown();
        Albright.exit();
        House Earth = new House("Earth", "universe", 100);
        System.out.println(Earth);
        House Moon = new House("Moon", "universe 2", 10 , false);
        System.out.println(Moon);
    }

}