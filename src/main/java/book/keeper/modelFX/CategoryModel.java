package book.keeper.modelFX;

import book.keeper.database.dao.BookDao;
import book.keeper.database.dao.CategoryDao;
import book.keeper.database.models.Book;
import book.keeper.database.models.Category;
import book.keeper.utils.converters.ConverterCategory;
import book.keeper.utils.exceptions.ApplicationException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import java.sql.SQLException;
import java.util.List;

public class CategoryModel {

    private ObservableList<CategoryFx> categoryList = FXCollections.observableArrayList();
    private ObjectProperty<CategoryFx> category = new SimpleObjectProperty<>();
    private TreeItem<String> root = new TreeItem<>();


    public void init() throws ApplicationException {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categories = categoryDao.queryForAll(Category.class);
        initCategoryList(categories);
        initRoot(categories);
    }

    private void initRoot(List<Category> categories) {
        this.root.getChildren().clear();
        categories.forEach(c -> {
            TreeItem<String> categoryItem = new TreeItem<>(c.getName());
            c.getBooks().forEach(b -> {
                categoryItem.getChildren().add(new TreeItem<>(b.getTitle()));
            });
            root.getChildren().add(categoryItem);
        });
    }

    private void initCategoryList(List<Category> categories) {
        this.categoryList.clear();
        categories.forEach(c -> {
            CategoryFx categoryFx = ConverterCategory.convertToCategoryFx(c);
            this.categoryList.add(categoryFx);
        });
    }

    public void deleteCategoryById() throws ApplicationException, SQLException {
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.deleteById(Category.class, category.getValue().getId());
        BookDao bookDao = new BookDao();
        bookDao.deleteByColumnName(Book.CATEGORY_ID, category.getValue().getId());
        init();
    }

    public void saveCategoryInDataBase(String name) throws ApplicationException {
        CategoryDao categoryDao = new CategoryDao();
        Category category = new Category();
        category.setName(name);
        categoryDao.creatOrUpdate(category);
        init();
    }

    public void updateCategoryInDataBase() throws ApplicationException {
        CategoryDao categoryDao = new CategoryDao();
        Category tempCategory = categoryDao.findById(Category.class, getCategory().getId());
        tempCategory.setName(getCategory().getName());
        categoryDao.creatOrUpdate(tempCategory);
        init();
    }

    public ObservableList<CategoryFx> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(ObservableList<CategoryFx> categoryList) {
        this.categoryList = categoryList;
    }

    public CategoryFx getCategory() {
        return category.get();
    }

    public void setCategory(CategoryFx category) {
        this.category.set(category);
    }

    public ObjectProperty<CategoryFx> categoryProperty() {
        return category;
    }

    public TreeItem<String> getRoot() {
        return root;
    }

    public void setRoot(TreeItem<String> root) {
        this.root = root;
    }
}