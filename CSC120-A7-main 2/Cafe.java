/* This is a stub for the Cafe class */
public class Cafe extends Building{

    //write to keep track of its inventory
    private int nCoffeeOunces = 100; 
    private int nSugarPackets = 100;
    private int nCreams = 100;
    private int nCups = 100; 

    //overload #1
    public Cafe(String name, String address){
        super(name, address);
        System.out.println("You have built a cafe that is in construction: ☕");
    }

    //overload #2
    public Cafe(String name, String address, int nCups, int nCreams){
        super(name, address);
        this.nCups = nCups;
        this.nCreams = nCreams;
        System.out.println("You have built a cafe that has 1000 cups and 1000 creams: ☕");
    }



    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
    }
    
    //Write a method to decrease the remaining inventory when the Cafe sells a cup of coffee
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        if (nCoffeeOunces < 0 || nSugarPackets < 0 || nCreams < 0 || nCups < 0){
            this.restock(size, nSugarPackets, nCreams, 1);
        }
    }

    //write a method to restock
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups +=1;
        System.out.println("we have " + this.nCoffeeOunces +" coffee ounces," + " we have " + this.nSugarPackets + " sugar packets," + " we have " + this.nCreams + " creams," + " we have " + this.nCups + " cups.");
    }

    //wrote showOptions for Library
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + sellCoffee() \n + restock()\n " );
     }


    //override goToFloor
    public void goToFloor(int floorNum){
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if(floorNum != 1){
            throw new RuntimeException("You are not an employee, please stay at 1st floor, thank you for your understanding!");
        }
    }



    public static void main(String[] args) {
        Cafe campusCafe = new Cafe("campus center", "Elm Street", 2);
        campusCafe.sellCoffee(10, 10, 10);
        campusCafe.restock(100, 100, 100, 100);
        System.out.println(campusCafe);
        campusCafe.showOptions();
        campusCafe.enter();
        campusCafe.goToFloor(1);
        Cafe earthCafe = new Cafe("Earth Cafe", "universe");
        System.out.println(earthCafe);
        Cafe moonCafe = new Cafe("Moon Cafe", "universe with a lot of cups and creams", 1000, 1000);
        System.out.println(moonCafe);
    }
    
}