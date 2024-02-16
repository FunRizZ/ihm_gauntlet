package model.Character;

public class Executioner extends Character {
    public Executioner(int x, int y){super(x,y);}
    @Override
    public String toString() {
        return "Executioner";
    }

    @Override
    public String getDescription() {
        return "He seems to enjoy killing prisoners, it's his passion.";
    }
}
