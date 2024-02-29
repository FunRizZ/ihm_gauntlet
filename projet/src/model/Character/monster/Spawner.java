package model.Character.monster;

import model.Character.Character;
import model.Character.WhoFight;
import model.Location.Location;

import java.util.Random;

public abstract class Spawner extends WhoFight {
    public final WhoFight MOB;
    public final int RANGE;
    public final Location LOCATION;

    public Spawner(int hp, int armor_start, WhoFight mob, int range, Location location, int x, int y) {
        super(hp, armor_start, 0, x, y);
        this.MOB = mob;
        this.RANGE = range;
        this.LOCATION = location;
    }
    @Override
    public void fight(WhoFight enemy){
        int distanceX = this.getPosX() - enemy.getPosX();
        int distanceY = this.getPosY() - enemy.getPosY();
        if ((-this.RANGE <  distanceX && distanceX > this.RANGE) && (-this.RANGE <  distanceY && distanceY > this.RANGE)) {
            Character monster = null;
            do {
                int x = (new Random()).nextInt(distanceX * 2) - distanceX;
                int y = (new Random()).nextInt(distanceY * 2) - distanceY;
                try {
                    monster = (Character) this.MOB.getClass().getConstructors()[0].newInstance(this.getPosX() + x, this.getPosY() + y);
                } catch (Exception e) {
                    System.err.println("error on fight (Spawner)");
                }
            }
            while (this.LOCATION.addCharacter(monster));
        }
    }
}
