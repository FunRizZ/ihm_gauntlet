package model.character.other;

import model.character.Character;

public class Chef extends Character {
    public Chef(int x, int y){super(x,y);}
    @Override
    public String toString() {
        return "Chef";
    }

    @Override
    public String getDescription() {
        return "The Chef continue to make dinner even if he is not paid.";
    }
}
