package org.pdas.designPatterns.learning_1.goodCode.gameObserers;
// concrete observer
public class SoundEngine implements GameObserver{
    @Override
    public void update(int health) {
        if (health < 20){
            System.out.println("SOUND: *Heartbeat increases... thump-thump...*");
        }
    }
}
