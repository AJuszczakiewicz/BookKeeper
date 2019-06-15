package book.keeper.modelFX;

import book.keeper.database.dao.AuthorDao;
import book.keeper.database.dao.BookDao;
import book.keeper.database.dao.CategoryDao;
import book.keeper.database.models.Author;
import book.keeper.database.models.Book;
import book.keeper.database.models.Category;
import book.keeper.utils.converters.ConverterAuthor;
import book.keeper.utils.converters.ConverterBook;
import book.keeper.utils.converters.ConverterCategory;
import book.keeper.utils.exceptions.ApplicationException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;


public class BookModel {


    private ObjectProperty<BookFx> bookFxObjectProperty = new SimpleObjectProperty<>(new BookFx());
    private ObservableList<CategoryFx> categoryFxObservableList = FXCollections.observableArrayList();
    private ObservableList<AuthorFx> authorFxObservableList = FXCollections.observableArrayList();


    public void init() throws ApplicationException {
        initAuthorList();
        initCategoryList();
    }

    private void initCategoryList() throws ApplicationException {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categoryList = categoryDao.queryForAll(Category.class);
        categoryFxObservableList.clear();
        categoryList.forEach(c -> {
            CategoryFx categoryFx = ConverterCategory.convertToCategoryFx(c);
            categoryFxObservableList.add(categoryFx);
        });
    }

    private void initAuthorList() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao();
        List<Author> authorList = authorDao.queryForAll(Author.class);
        this.authorFxObservableList.clear();
        authorList.forEach(author -> {
            AuthorFx authorFx = ConverterAuthor.convertToAuthorFx(author);
            this.authorFxObservableList.add(authorFx);
        });
    }

    public void saveBookInDataBase() throws ApplicationException {
        Book book = ConverterBook.convertToBook(this.getBookFxObjectProperty());

        CategoryDao categoryDao = new CategoryDao();
        Category category = categoryDao.findById(Category.class, this.getBookFxObjectProperty().getCategoryFx().getId());

        AuthorDao authorDao = new AuthorDao();
        Author author = authorDao.findById(Author.class, this.getBookFxObjectProperty().getAuthorFx().getId());

        book.setCategory(category);
        book.setAuthor(author);

        BookDao bookDao = new BookDao();
        bookDao.creatOrUpdate(book);

    }


    public BookFx getBookFxObjectProperty() {
        return bookFxObjectProperty.get();
    }

    public void setBookFxObjectProperty(BookFx bookFxObjectProperty) {
        this.bookFxObjectProperty.set(bookFxObjectProperty);
    }

    public ObjectProperty<BookFx> bookFxObjectPropertyProperty() {
        return bookFxObjectProperty;
    }

    public ObservableList<CategoryFx> getCategoryFxObservableList() {
        return categoryFxObservableList;
    }

    public void setCategoryFxObservableList(ObservableList<CategoryFx> categoryFxObservableList) {
        this.categoryFxObservableList = categoryFxObservableList;
    }

    public ObservableList<AuthorFx> getAuthorFxObservableList() {
        return authorFxObservableList;
    }

    public void setAuthorFxObservableList(ObservableList<AuthorFx> authorFxObservableList) {
        this.authorFxObservableList = authorFxObservableList;
    }
}