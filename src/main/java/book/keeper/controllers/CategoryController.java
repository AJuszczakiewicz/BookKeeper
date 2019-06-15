package book.keeper.controllers;

import book.keeper.modelFX.CategoryFx;
import book.keeper.modelFX.CategoryModel;
import book.keeper.utils.DialogsUtils;
import book.keeper.utils.exceptions.ApplicationException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;

import java.sql.SQLException;

public class CategoryController {

    @FXML
    private Button addCategoryButton;
    @FXML
    private Button deleteCategoryButton;
    @FXML
    private Button editCategoryButton;
    @FXML
    private TextField categoryTextField;
    @FXML
    private ComboBox<CategoryFx> categoryComboBox;
    @FXML
    private TreeView<String> categoryTreeView;

    private CategoryModel categoryModel;

    @FXML
    public void initialize() {
        this.categoryModel = new CategoryModel();
        try {
            this.categoryModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.categoryComboBox.setItems(this.categoryModel.getCategoryList());
        this.categoryTreeView.setRoot(this.categoryModel.getRoot());
        initBindings();
    }

    private void initBindings() {
        this.addCategoryButton.disableProperty().bind(categoryTextField.textProperty().isEmpty());
        this.deleteCategoryButton.disableProperty().bind(this.categoryModel.categoryProperty().isNull());
        this.editCategoryButton.disableProperty().bind(this.categoryModel.categoryProperty().isNull());
    }


    public void addCategoryOnAction() {
        try {
            categoryModel.saveCategoryInDataBase(categoryTextField.getText());
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        categoryTextField.clear();
    }

    public void onActionDeleteButton() {
        try {
            this.categoryModel.deleteCategoryById();
        } catch (ApplicationException | SQLException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }

    public void onActionComboBox() {
        this.categoryModel.setCategory(this.categoryComboBox.getSelectionModel().getSelectedItem());
    }

    public void onActionEditCategory() {
        String newCategoryName = DialogsUtils.editDialog(this.categoryModel.getCategory().getName());
        if (newCategoryName != null) {
            this.categoryModel.getCategory().setName(newCategoryName);
            try {
                this.categoryModel.updateCategoryInDataBase();
            } catch (ApplicationException e) {
                DialogsUtils.errorDialog(e.getMessage());
            }
        }

    }
}