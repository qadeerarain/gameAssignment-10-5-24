//Imagine creating a simple text-based fighting game! Design a class named Fighter with the following 
//functionalities:
//1. Member Variables:
//o name: String representing the fighter's name (e.g., "Ali", "Aisha")
//o health: int representing the fighter's current health points (HP)
//o attackPower: int representing the fighter's attack strength
//2. Member Methods:
//o Fighter(String name, int health, int attackPower): Constructor to initialize the fighter's 
//name, HP, and attack power.
//o attack(Fighter opponent): This method simulates an attack on another Fighter object 
//(opponent). It should: 
// Reduce the opponent's HP by the attacker's attackPower.
// Print a message like "{Attacker Name} attacks {Opponent Name} for {Attack 
//Power} damage!"
//o isAlive(): This method checks if the fighter's HP is greater than 0 and returns true if alive, 
//false if defeated.
//Bonus:
// In your main method, create two Fighter objects with different names, HP, and attack power.
// Simulate a fight by calling the attack method on each other repeatedly until one fighter's HP 
//reaches 0.
// After each attack, print the remaining HP of both fighters.
// Declare the fighter with remaining HP as the winner and print a victory messag
import java.util.Random;

class Fighter {
    private String name;
    private int health;
    private int attackPower;

    public Fighter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack(Fighter opponent) {
        Random rand = new Random();
        int damage = rand.nextInt(this.attackPower) + 1;
        opponent.health -= damage;
        System.out.println(this.name + " attacks " + opponent.name + " for " + damage + " damage!");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}

public class Main {
    public static void main(String[] args) {
        Fighter fighter1 = new Fighter("Ali", 100, 20);
        Fighter fighter2 = new Fighter("Aisha", 120, 15);

        while (fighter1.isAlive() && fighter2.isAlive()) {
            fighter1.attack(fighter2);
            System.out.println("Remaining HP for " + fighter1.getName() + ": " + fighter1.getHealth());
            System.out.println("Remaining HP for " + fighter2.getName() + ": " + fighter2.getHealth());
            if (!fighter2.isAlive()) {
                System.out.println(fighter1.getName() + " wins!");
                break;
            }

            fighter2.attack(fighter1);
            System.out.println("Remaining HP for " + fighter1.getName() + ": " + fighter1.getHealth());
            System.out.println("Remaining HP for " + fighter2.getName() + ": " + fighter2.getHealth());
            if (!fighter1.isAlive()) {
                System.out.println(fighter2.getName() + " wins!");
                break;
            }
        }
    }
}
