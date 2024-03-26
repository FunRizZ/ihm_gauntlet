
package apps.controller;


import apps.MainScene;
import apps.mainMenu.MainMenuScene;
import apps.setting.JsonSetting;
import apps.setting.SettingCreatorScene;
import apps.setting.settingScene;
import apps.setting.SettingPersonnage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Class Controller for the Settings
 */
public class SettingController{
    SettingPersonnage[] players = JsonSetting.getSetting();
    settingScene settingScene = JsonSetting.getSettingsScene();

    //language is the Resource Bundle of the different languages, use in the FXML LOADER to change languages in scenes
    public static ResourceBundle language = ResourceBundle.getBundle("language/texts", new Locale(JsonSetting.getSettingsScene().getLangue()));
    
    @FXML
    private GridPane Grid;
    @FXML
    private ComboBox<String> Resolution;
    @FXML
    private ComboBox<String> Langue;

    /**
     * Initialize the setting scene
     */
    @FXML
    public void initialize() {

        createcontrol(Grid, players);
        updateButtons(players);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Resolution.setItems(FXCollections.observableArrayList("1280 x 720", (int)screenBounds.getWidth()+" x "+(int)screenBounds.getHeight()));
        Resolution.getSelectionModel().select((int)settingScene.getWidth() + " x " + (int)settingScene.getHeight());
        Resolution.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * Allow the resolution change
             * @param event the event which occurred
             */
        @Override
        public void handle(ActionEvent event) {
            String selectedValue = Resolution.getValue();
            String[] dimensions = selectedValue.split(" x ");
            double width = Double.parseDouble(dimensions[0]);
            double height = Double.parseDouble(dimensions[1]);

            settingScene.setWidth(width);
            settingScene.setHeight(height);
            MainScene.stage.setWidth(width);
            MainScene.stage.setHeight(height);
            JsonSetting.save_control();

            }
        });
        Langue.setItems(FXCollections.observableArrayList("fr", "en", "es"));
        Langue.getSelectionModel().select(settingScene.getLangue());
        Langue.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * Allow the language change with the Resource Bundle
             * @param event the event which occurred
             */
        @Override
        public void handle(ActionEvent event) {
            String selectedValue = Langue.getValue();

            if(Objects.equals(selectedValue, "fr")){
                language = ResourceBundle.getBundle("language/texts", new Locale("fr"));
            }
            else if(Objects.equals(selectedValue, "es")){
                language = ResourceBundle.getBundle("language/texts", new Locale("es"));
            }
            else {
                language = ResourceBundle.getBundle("language/texts", new Locale("en"));
            }

            settingScene.setLangue(selectedValue);
            JsonSetting.save_control();
            SettingCreatorScene Setting = new SettingCreatorScene();
            Setting.load();
            }
        });
    }


    /**
     * Create the controller binds of each character
     * @param grid
     * @param personnages
     */
    private void createcontrol(GridPane grid, SettingPersonnage[] personnages) {
        String[] actions = {"UP", "DOWN", "LEFT", "RIGHT", "Attack", "Bomb", "Resurec"};

        for (int i = 0; i < actions.length; i++) {
            for (int x = 0; x < personnages.length; x++) {
                Label label = new Label("player" + (x+1));
                grid.add(label, x+1, 0);
                Button button = new Button();
                button.setMinWidth(100);
                button.setMinHeight(50);
                add(button);
                GridPane.setHgrow(button, Priority.SOMETIMES);
                GridPane.setVgrow(button, Priority.SOMETIMES);
                grid.add(button, x + 1, i + 1);
            }
        }
    }

    /**
     * Add a button
     * @param button
     */
    void add(Button button){
        button.setOnAction(event -> {
            Integer columnIndex = GridPane.getColumnIndex(button);
            Integer rowIndex = GridPane.getRowIndex(button);

            KeyCode[] lastKeyCode = new KeyCode[1]; // Save lastKeyCode in a tab
            lastKeyCode[0] = KeyCode.getKeyCode(button.getText());

            Label label = new Label("...");
            label.setFont(new Font(15));
            StackPane stackPane = new StackPane();
            Text text = new Text("enter/escape to close");
            text.setFont(new Font(10));
            stackPane.setStyle("-fx-border-color: black;");
            StackPane.setAlignment(text, Pos.BOTTOM_RIGHT);
            stackPane.getChildren().add(text);
            stackPane.getChildren().add(label);

            Scene enterKey = new Scene(stackPane, 100, 100);
            Stage stage = new Stage();
            stage.setScene(enterKey);
            stage.initStyle(StageStyle.TRANSPARENT);  
            //Center the window
            double centerXPosition = MainScene.stage.getX() + MainScene.stage.getWidth() / 2d;
            double centerYPosition = MainScene.stage.getY() + MainScene.stage.getHeight() / 2d;

            // Place the stage in the center of the Parent stage
            stage.setOnShown(evt -> {
                stage.setX(centerXPosition - stage.getWidth() / 2d);
                stage.setY(centerYPosition - stage.getHeight() / 2d);
            });

            stage.show();
            
            //Deactivate the main window
            MainScene.scene.getRoot().setDisable(true);
            // Add an event to activate the main window when the new window closes
            stage.setOnHiding((EventHandler<WindowEvent>) new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    MainScene.scene.getRoot().setDisable(false);
                }
            });
            //forces window to regain focus when lost
            stage.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    // The window has lost focus, so we ask the window to regain focus
                    Platform.runLater(stage::requestFocus);
                }
            });

            enterKey.setOnKeyPressed(keyEvent -> {
                KeyCode keyName = keyEvent.getCode();
                if(keyName == KeyCode.ESCAPE){
                    stage.close();
                }
                if (keyName == KeyCode.ENTER) {
                    stage.close();
                    if (lastKeyCode[0] != null) {
                        for (int i = 0; i < players.length; i++) {
                            if (players[i].getKeyString(lastKeyCode[0]) != null) {
                                players[i].setKey(players[i].getKeyString(lastKeyCode[0]), null);
                            }
                        }
                        switch (rowIndex) {
                            case 1:
                                players[columnIndex-1].setKey("UP", lastKeyCode[0]);
                                break;
                                
                            case 2:
                                players[columnIndex-1].setKey("DOWN", lastKeyCode[0]);
                                break;
                                
                            case 3:
                                players[columnIndex-1].setKey("LEFT", lastKeyCode[0]);
                                break;
                                
                            case 4:
                                players[columnIndex-1].setKey("RIGHT", lastKeyCode[0]);
                                break;
                                
                            case 5:
                                players[columnIndex-1].setKey("Attack", lastKeyCode[0]);
                                break;
                                
                            case 6:
                                players[columnIndex-1].setKey("Bomb", lastKeyCode[0]);
                                break;
                                
                            case 7:
                                players[columnIndex-1].setKey("Resurec", lastKeyCode[0]);
                                break;
                        }
                    }                        
                        updateButtons(players);
                        JsonSetting.save_control();
                }
                lastKeyCode[0] = keyName;
                label.setText(""+keyName);
            });
        });
    }

    /**
     * Update the buttons
     * @param personnage
     */
    private void updateButtons(SettingPersonnage[] personnage) {
        for (Node node : Grid.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                int columnIndex = GridPane.getColumnIndex(button);
                int rowIndex = GridPane.getRowIndex(button);

                SettingPersonnage player = personnage[columnIndex - 1];
                KeyCode key = null;

                switch (rowIndex) {
                    case 1:
                        key = player.getKey("UP");
                        break;
                    case 2:
                        key = player.getKey("DOWN");
                        break;
                    case 3:
                        key = player.getKey("LEFT");
                        break;
                    case 4:
                        key = player.getKey("RIGHT");
                        break;
                    case 5:
                        key = player.getKey("Attack");
                        break;
                    case 6:
                        key = player.getKey("Bomb");
                        break;
                    case 7:
                        key = player.getKey("Resurec");
                        break;
                }

                if (key != null) {
                    button.setText(key.getName());
                } else {
                    button.setText("");
                }
            }
        }
    }

    /**
     * Change the actual scene to the Main Menu scene
     */
    @FXML
    public void goMenu() {
        MainMenuScene GameMenu = new MainMenuScene();
        GameMenu.changeScene(GameMenu.GAME_MENU, GameMenu.SCENE_TITLE);
    }

    /**
     * Reinitialize the setting
     */
    @FXML
    public void reinit_setting() {
        JsonSetting.reinitialize_setting_personnage();
        language = ResourceBundle.getBundle("language/texts", new Locale("fr"));
        MainScene.stage.setWidth(JsonSetting.getSettingsScene().getWidth());
        MainScene.stage.setHeight(JsonSetting.getSettingsScene().getHeight());
        SettingCreatorScene Setting = new SettingCreatorScene();
        Setting.load();
    }
}