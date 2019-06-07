package book.keeper.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    public static final String FXML_LIBRARY_PATH = "/fxml/Library.fxml";
    public static final String FXML_BOOKS_LIST_PATH = "/fxml/BooksList.fxml";
    public static final String FXML_STATISTICS_PATH = "/fxml/Statistics.fxml";
    public static final String FXML_ADD_BOOK_PATH = "/fxml/AddBook.fxml";

    private MainController mainController;

    @FXML
    private ToggleGroup menu;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void openLibrary() {

        mainController.setCenter(FXML_LIBRARY_PATH);
    }

    @FXML
    public void openBookList() {

        mainController.setCenter(FXML_BOOKS_LIST_PATH);
    }

    @FXML
    public void openStatistics() {

        mainController.setCenter(FXML_STATISTICS_PATH);
    }

    @FXML
    public void addBook() {
        if (menu.getSelectedToggle() != null) {
            menu.getSelectedToggle().setSelected(false);
        }

        mainController.setCenter(FXML_ADD_BOOK_PATH);

    }
}
