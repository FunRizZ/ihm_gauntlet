package apps.setting;

import javafx.scene.input.KeyCode;


public class setting_personnage {
    private KeyCode UP;
    private KeyCode DOWN;
    private KeyCode LEFT;
    private KeyCode RIGHT;
    private KeyCode Attack;
    private KeyCode Bomb;
    private KeyCode Resurec;

    public setting_personnage(KeyCode UP, KeyCode DOWN, KeyCode LEFT, KeyCode RIGHT, KeyCode Attack, KeyCode Bomb, KeyCode Resurec) {
        this.UP = UP;
        this.DOWN = DOWN;
        this.LEFT = LEFT;
        this.RIGHT = RIGHT;
        this.Attack = Attack;
        this.Bomb = Bomb;
        this.Resurec = Resurec;
    }

    public void setUP(KeyCode UP) {
        this.UP = UP;
    }

    public KeyCode getUP() {
        return this.UP;
    }

    public void setDOWN(KeyCode DOWN) {
        this.DOWN = DOWN;
    }

    public KeyCode getDOWN() {
        return this.DOWN;
    }

    public void setLEFT(KeyCode LEFT) {
        this.LEFT = LEFT;
    }

    public KeyCode getLEFT() {
        return this.LEFT;
    }

    public void setRIGHT(KeyCode RIGHT) {
        this.RIGHT = RIGHT;
    }

    public KeyCode getRIGHT() {
        return this.RIGHT;
    }

    public void setAttack(KeyCode Attack) {
        this.Attack = Attack;
    }

    public KeyCode getAttack() {
        return this.Attack;
    }

    public void setBomb(KeyCode bomb) {
        this.Bomb = bomb;
    }

    public KeyCode getBomb() {
        return this.Bomb;
    }

    public void setResurec(KeyCode resurec) {
        this.Resurec = resurec;
    }

    public KeyCode getResurec() {
        return this.Resurec;
    }

}
