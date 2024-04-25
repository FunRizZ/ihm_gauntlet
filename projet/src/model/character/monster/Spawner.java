package model.character.monster;

import model.character.Character;
import model.character.WhoFight;
import model.game_pack.Game;
import model.location.Location;

import java.util.Random;

public abstract class Spawner extends WhoFight {
    public final WhoFight MOB;

    public Spawner(int hp, int armor_start, WhoFight mob, int x, int y, int level) {
        super(hp, armor_start, 0,3,level, x, y);
        this.MOB = mob;
    }
    @Override
    public boolean fight(WhoFight enemy){
        int distanceX = Math.abs(this.getPosX() - enemy.getPosX())+1;
        int distanceY = Math.abs(this.getPosY() - enemy.getPosY())+1;
        System.out.println(distanceX +" "+ distanceY+ " disnance "+ this.getDistance(enemy));
        if (this.getDistance(enemy) <= this.getRange()) {
            Character monster = null;
            do {
                int x = (new Random()).nextInt(distanceX * 2) - distanceX;
                int y = (new Random()).nextInt(distanceY * 2) - distanceY;
                try {
                    monster = (Character) this.MOB.getClass().getConstructors()[0].newInstance(this.getPosX() + x, this.getPosY() + y, this.level);
                } catch (Exception e) {
                    System.err.println("error on fight (Spawner)");
                }
            } while (Game.GAME.getMainHero().getLocation().addCharacter(monster));
            return true;
        }
        return false;
    }
}
