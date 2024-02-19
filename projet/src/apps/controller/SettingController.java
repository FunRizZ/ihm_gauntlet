
package apps.controller;


import apps.MainScene;
import apps.setting.Json_control_setting_personnage;
import apps.setting.setting_personnage;
import javafx.application.Platform;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SettingController{
    Json_control_setting_personnage Json_control_setting_personnage = new Json_control_setting_personnage();
    setting_personnage[] players = Json_control_setting_personnage.getPerson();
    
    @FXML
    private GridPane Grid;

    @FXML
    public void initialize() {
       
        Grid.setHgap(2);
        Grid.setVgap(2);
        
        Grid.setAlignment(Pos.CENTER); // Centrer le GridPane
        GridPane.setHgrow(Grid, Priority.ALWAYS);
        GridPane.setVgrow(Grid, Priority.ALWAYS);


        String[] labelsText = {"Control", "UP", "DOWN", "LEFT", "RIGHT", "ATTACK", "BOMB", "RESUREC"};

    for (int i = 0; i < labelsText.length; i++) {
        Label label = new Label(labelsText[i]);
        Grid.add(label, 0, i);
    }
        createcontrol(Grid, players);
        updateButtons(players);

        // Résolutions d'écran
        ComboBox<String> resolution = new ComboBox<>();
        resolution.getItems().addAll("1280 x 720", "1920 x 1080", "2560 x 1440");
        resolution.getSelectionModel().selectFirst(); // Sélectionne la première résolution par défaut
        Grid.add(resolution, 0, Grid.getChildren().size()/4);        
    }


    
    private void createcontrol(GridPane grid, setting_personnage[] personnages)
    {
        for (int i = 0; i <= players[0].getClass().getDeclaredFields().length; i++) {
            for (int x = 0; x < personnages.length; x++)
            {
                Label label = new Label("player" + (x+1));
                grid.add(label, x+1, 0);
                Button button = new Button();
                add(button);
                button.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-padding: 5 10 5 10;");
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
            StackPane root = new StackPane();
            root.setStyle("-fx-border-color: black;");
                        root.getChildren().add(label);
            Scene scene = new Scene(root, 80, 60);

            Stage stage = new Stage();
            stage.setScene(scene);
            //ajout un fond gris a la fenetre
            stage.initStyle(StageStyle.TRANSPARENT);  
            
            stage.show();
            MainScene.scene.getRoot().setDisable(true);
            stage.focusedProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue) {
                    // La fenêtre a perdu le focus, donc nous demandons à la fenêtre de reprendre le focus
                    Platform.runLater(stage::requestFocus);
                }
            });
            scene.setOnKeyPressed(keyEvent -> {
                KeyCode keyName = keyEvent.getCode();
                if (keyName == KeyCode.ESCAPE || keyName == KeyCode.ENTER) {
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
                        // Utiliser lastKeyCode[0] pour modifier la valeur
                        updateButtons(players);
                        MainScene.scene.getRoot().setDisable(false);
                        apps.setting.Json_control_setting_personnage.save_control();
                    }
                }
                lastKeyCode[0] = keyName; // Utiliser lastKeyCode[0] pour modifier la valeur
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

                // Assurez-vous que columnIndex et rowIndex ne sont pas null
                if (columnIndex != 0 && rowIndex != 0) {
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
    }
}