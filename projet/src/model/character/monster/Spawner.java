package model.character.monster;

import model.character.Character;
import model.character.WhoFight;
import model.game_pack.Game;
import model.location.Location;

import java.util.Random;

public abstract class Spawner extends WhoFight {
    public final WhoFight MOB;
    public final Location LOCATION;

    public Spawner(int hp, int armor_start, WhoFight mob, int x, int y, int level) {
        super(hp, armor_start, 0,3,level, x, y);
        this.MOB = mob;
        this.LOCATION = Game.GAME.getMainHero().getLocation();
    }
    @Override
    public void fight(WhoFight enemy){
        int distanceX = this.getPosX() - enemy.getPosX();
        int distanceY = this.getPosY() - enemy.getPosY();
        if ((-this.getRange() <  distanceX && distanceX > this.getRange()) && (-this.getRange() <  distanceY && distanceY > this.getRange())) {
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
