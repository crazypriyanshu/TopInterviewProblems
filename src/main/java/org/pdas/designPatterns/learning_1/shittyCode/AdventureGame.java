package org.pdas.designPatterns.learning_1.shittyCode;


// God class
public class AdventureGame {
    public void play(String enemyType, String powerUp, String action){
        //
        if (enemyType.equals("ORC")){
            System.out.println("An ORC appears with a club!");
        } else if (enemyType.equals("SLIME")) {
            System.out.println("A slime is in the club.. Wokoooohu");
        }

        String description = "Player";
        if (powerUp.equals("FIRE-SWORD")){
            description += " with a Flaming Sword";
        } else if (powerUp.equals("SHIELD")) {
            description += "with a Sturdy Shield";
        }
        System.out.println("You are: " + description);

        if (action.equals("ATTACK")){
            if (enemyType.equals("ORC")){
                System.out.println("You swing and hit the Orc for 10 damage!");
            }else if (enemyType.equals("SLIME")) {
                System.out.println("You poke the slime! It splits in two!");
            }
        } else if (action.equals("DEFEND")){
            System.out.println("You hide behind your gear.");
        }
    }
}

/*
* Problems with this class : and why is this code shitty???
* 1. Let's say if we want to add new enemy say "Zombie" we have to add if else - changing same class - violating Open close principle
* 2. Changing anything like FIRE-SWORD logic might affect the 2Orc combat logic as it lies in the same method
* 3. Most of the things are hardcoded here
* 4. God class - having too many responsibilities
* 5. Use of Strings everywhere, instead of Enum or something, typos can cause runtime bugs, no type safety
* 6. Tight coupling because of if-else
* 7. No null safety checks
* */

