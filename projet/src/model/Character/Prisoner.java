package model.Character;

public class Prisoner extends Character {
    public Prisoner(int x, int y){super(x, y);}
    @Override
    public String toString() {
        return "Prisoners";
    }

    @Override
    public String getDescription() {
        return "They are prisoners. They have done some terrible crimes.";
    }
}
