package book.keeper.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TopMenuButtonsController {

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void openLibrary(ActionEvent actionEvent) {
        System.out.println("Open Library");
    }

    @FXML
    public void openBookList(ActionEvent actionEvent) {
        System.out.println("Open Book List");
    }

    @FXML
    public void openStatistics(ActionEvent actionEvent) {
        System.out.println("Open Statistics");
    }
}
