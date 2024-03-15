package apps.controller;

import java.time.LocalDate;
import java.util.List;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import apps.MainScene;
import apps.game.GameMenuScene;
import apps.scoreboard.Scoreboard;

public class ScoreboardController {
    @FXML
    private TableView<Scoreboard.Score> scoreTable;
    @FXML
    private TableColumn<Scoreboard.Score, String> playerColumn;
    @FXML
    private TableColumn<Scoreboard.Score, Integer> scoreColumn;
    @FXML
    private TableColumn<Scoreboard.Score, LocalDate> dateColumn;
    @FXML
    private TableColumn<Scoreboard.Score, Integer> rankColumn;

    /**
     * Initialize the scoreboard
     */
    @FXML
    public void initialize() {
        playerColumn.setCellValueFactory(new PropertyValueFactory<>("player"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Define the cellFactory for column "Rank"
        rankColumn.setCellFactory(column -> {
            return new TableCell<Scoreboard.Score, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);

                    if (this.getTableRow() != null && this.getTableRow().getIndex() >= 0 && this.getTableRow().getIndex() < 10) {
                        setText(this.getTableRow().getIndex() + 1 + "");
                    } else {
                        setText("");
                    }
                }
            };
        });

        // Get the 10 first scores
        List<Scoreboard.Score> topScores = Scoreboard.getScores().subList(0, Math.min(10, Scoreboard.getScores().size()));

        // Define the elements of scoreTable
        scoreTable.getItems().setAll(topScores);

        for (TableColumn<Scoreboard.Score, ?> column : scoreTable.getColumns()) {
            column.setSortable(false);
            column.setResizable(false);
            column.setReorderable(false);

        }
        scoreTable.setSelectionModel(null);


        scoreTable.maxWidthProperty().bind(MainScene.stage.widthProperty().multiply(0.75));
        scoreTable.maxHeightProperty().bind(MainScene.stage.heightProperty().multiply(0.75));


        scoreTable.setFixedCellSize((scoreTable.getMaxHeight() / 10.5));
        for (TableColumn<Scoreboard.Score, ?> column : scoreTable.getColumns()) {
            column.setPrefWidth((scoreTable.getMaxWidth() / 4.01));
        }
        

    }

    /**
     * Change the actual scene to the Main Menu scene
     */
    @FXML
    public void goMenu() {
        GameMenuScene GameMenu = new GameMenuScene();
        GameMenu.changeScene(GameMenu.GAME_MENU, GameMenu.SCENE_TITLE);
    }
}