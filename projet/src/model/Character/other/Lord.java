package model.Character.other;

import model.Character.Character;

public class Lord extends Character {
    public Lord(int x, int y){super(x,y);}
    @Override
    public String toString() {
        return "Lord";
    }

    @Override
    public String getDescription() {
        return "He is mefiant, he can become your enemy.";
    }
}
