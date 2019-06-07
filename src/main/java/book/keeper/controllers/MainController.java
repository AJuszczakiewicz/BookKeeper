package book.keeper.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class MainController {

    @FXML
    private TopMenuButtonsController topMenuButtonsController;

    @FXML
    private BorderPane borderPane;

    @FXML
    private void initialize() {
        topMenuButtonsController.setMainController(this);
    }


}
