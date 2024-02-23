
package apps.controller;


import apps.MainScene;
import apps.game.GameMenuScene;
import apps.setting.JsonSetting;
import apps.setting.settingScene;
import apps.setting.setting_personnage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class SettingController{
    setting_personnage[] players = JsonSetting.getPersonnages();
    settingScene settingScene = JsonSetting.getSettingsScene();
    
    @FXML
    private GridPane Grid;
    @FXML
    private ComboBox<String> Resolution;
    @FXML
    private ComboBox<String> Langue;

    @FXML
    public void initialize() {

        createcontrol(Grid, players);
        updateButtons(players);

        Resolution.setItems(FXCollections.observableArrayList("1280 x 720", "1920 x 1080"));
        Resolution.getSelectionModel().select((int)settingScene.getWidth() + " x " + (int)settingScene.getHeight());
        Resolution.setOnAction(new EventHandler<ActionEvent>() {
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
        Langue.setItems(FXCollections.observableArrayList("fr", "en"));
        Langue.getSelectionModel().select(settingScene.getLangue());
        Langue.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String selectedValue = Langue.getValue();

            settingScene.setLangue(selectedValue);
            JsonSetting.save_control();
            }
        });
    }


    
    private void createcontrol(GridPane grid, setting_personnage[] personnages)
    {
        for (int i = 1; i <= players[0].getClass().getDeclaredFields().length; i++) {
            for (int x = 0; x < personnages.length; x++)
            {
                Label label = new Label("player" + (x+1));
                grid.add(label, x+1, 0);
                Button button = new Button();
                add(button);
                button.setMinWidth(100);
                button.setMinHeight(50);
                GridPane.setHgrow(button, Priority.SOMETIMES);
                GridPane.setVgrow(button, Priority.SOMETIMES);
                grid.add(button, x + 1, i);
            }
        }
    }
    void add(Button button){
        button.setOnAction(event -> {
            Integer columnIndex = GridPane.getColumnIndex(button);
            Integer rowIndex = GridPane.getRowIndex(button);

            KeyCode[] lastKeyCode = new KeyCode[1]; // Utiliser un tableau pour stocker lastKeyCode
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
            //centrer la fenêtre
            double centerXPosition = MainScene.stage.getX() + MainScene.stage.getWidth() / 2d;
            double centerYPosition = MainScene.stage.getY() + MainScene.stage.getHeight() / 2d;

            // On place le stage au centre du parentStage
            stage.setOnShown(evt -> {
                stage.setX(centerXPosition - stage.getWidth() / 2d);
                stage.setY(centerYPosition - stage.getHeight() / 2d);
            });

            stage.show();
            
            //désactiver la fenêtre principale
            MainScene.scene.getRoot().setDisable(true);
            // Ajouter un événement pour activer la fenêtre principale lorsque la nouvelle fenêtre se ferme
            stage.setOnHiding((EventHandler<WindowEvent>) new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    MainScene.scene.getRoot().setDisable(false);
                }
            });
            //force la fenêtre à reprendre le focus lorsqu'elle est perdue
            stage.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    // La fenêtre a perdu le focus, donc nous demandons à la fenêtre de reprendre le focus
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
                    if (lastKeyCode[0] != null) {// Utiliser lastKeyCode[0] pour accéder à la valeur
                        switch (rowIndex) {
                            case 1:
                                players[columnIndex-1].setUP(lastKeyCode[0]);
                                break;
                                
                            case 2:
                                players[columnIndex-1].setDOWN(lastKeyCode[0]);
                                break;
                                
                            case 3:
                                players[columnIndex-1].setLEFT(lastKeyCode[0]);
                                break;
                                
                            case 4:
                                players[columnIndex-1].setRIGHT(lastKeyCode[0]);
                                break;
                                
                            case 5:
                                players[columnIndex-1].setAttack(lastKeyCode[0]);
                                break;
                                
                            case 6:
                                players[columnIndex-1].setBomb(lastKeyCode[0]);
                                break;
                                
                            case 7:
                                players[columnIndex-1].setResurec(lastKeyCode[0]);
                                break;
                        }                        
                        updateButtons(players);
                        JsonSetting.save_control();
                    }
                }
                lastKeyCode[0] = keyName;
                label.setText(""+keyName);
            });
        });
    }

    private void updateButtons(setting_personnage[] personnage) {
        for (Node node : Grid.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                int columnIndex = GridPane.getColumnIndex(button);
                int rowIndex = GridPane.getRowIndex(button);

                setting_personnage player = personnage[columnIndex - 1];

                switch (rowIndex) {
                    case 1:
                        button.setText(player.getUP().getName());
                        break;
                    case 2:
                        button.setText(player.getDOWN().getName());
                        break;
                    case 3:
                        button.setText(player.getLEFT().getName());
                        break;
                    case 4:
                        button.setText(player.getRIGHT().getName());
                        break;
                    case 5:
                        button.setText(player.getAttack().getName());
                        break;
                    case 6:
                        button.setText(player.getBomb().getName());
                        break;
                    case 7:
                        button.setText(player.getResurec().getName());
                        break;
                }
            }
        }
    }
    @FXML
    public void goMenu(ActionEvent event) {
        GameMenuScene GameMenu = new GameMenuScene();
        GameMenu.changeScene(GameMenu.GAME_MENU, GameMenu.SCENE_TITLE);
    }
}