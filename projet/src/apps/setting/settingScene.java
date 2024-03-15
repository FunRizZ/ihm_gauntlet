package apps.setting;

/**
 * Class for the Settings Scene
 */
public class settingScene {
    private double width = 1280;
    private double height = 720;
    private String langue = "fr";

    // getters et setters pour width et height

    /**
     * Get width
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Set width
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Get height
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set height
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Get language of the game
     * @return language
     */
    public String getLangue() {
        return langue;
    }

    /**
     * Set the language
      * @param langue languages french, english or spanish
     */
    public void setLangue(String langue) {
        this.langue = langue;
    }
}