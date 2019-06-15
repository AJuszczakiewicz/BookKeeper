package book.keeper.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    public static final String FXML_BOOKS_LIST_PATH = "/fxml/BooksList.fxml";
    public static final String FXML_ADD_BOOK_PATH = "/fxml/AddBook.fxml";
    public static final String FXML_ADD_CATEGORY_PATH = "/fxml/AddCategory.fxml";
    private static final String ADD_AUTHOR_FXML = "/fxml/AddAuthor.fxml";

    private MainController mainController;

    @FXML
    private ToggleGroup menu;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }


    @FXML
    public void openBookList() {
        mainController.setCenter(FXML_BOOKS_LIST_PATH);
    }


    @FXML
    public void addBook() {
        resetToggleButtons();
        mainController.setCenter(FXML_ADD_BOOK_PATH);

    }


    public void addAuthor() {
        resetToggleButtons();
        mainController.setCenter(ADD_AUTHOR_FXML);
    }


    public void addCategory() {
        resetToggleButtons();
        mainController.setCenter(FXML_ADD_CATEGORY_PATH);
    }


    private void resetToggleButtons() {
        if (menu.getSelectedToggle() != null) {
            menu.getSelectedToggle().setSelected(false);
        }
    }
}
