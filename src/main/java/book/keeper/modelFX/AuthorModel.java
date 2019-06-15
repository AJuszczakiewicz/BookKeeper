package book.keeper.modelFX;

import book.keeper.database.dao.AuthorDao;
import book.keeper.database.dao.BookDao;
import book.keeper.database.models.Author;
import book.keeper.database.models.Book;
import book.keeper.utils.converters.ConverterAuthor;
import book.keeper.utils.exceptions.ApplicationException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class AuthorModel {

    private ObjectProperty<AuthorFx> authorFxObjectProperty = new SimpleObjectProperty<>(new AuthorFx());
    private ObjectProperty<AuthorFx> authorFxObjectPropertyEdit = new SimpleObjectProperty<>(new AuthorFx());

    private ObservableList<AuthorFx> authorFxObservableList = FXCollections.observableArrayList();


    public void init() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao();
        List<Author> authorList = authorDao.queryForAll(Author.class);
        this.authorFxObservableList.clear();
        authorList.forEach(author -> {
            AuthorFx authorFx = ConverterAuthor.convertToAuthorFx(author);
            this.authorFxObservableList.add(authorFx);
        });

    }

    public void saveAuthorEditInDataBase() throws ApplicationException {
        saveOrUpdate(this.getAuthorFxObjectPropertyEdit());
    }

    public void saveAuthorInDataBase() throws ApplicationException {
        saveOrUpdate(this.getAuthorFxObjectProperty());
    }

    public void deleteAuthorInDataBase() throws ApplicationException, SQLException {
        AuthorDao authorDao = new AuthorDao();
        authorDao.deleteById(Author.class, this.getAuthorFxObjectPropertyEdit().getId());
        BookDao bookDao = new BookDao();
        bookDao.deleteByColumnName(Book.AUTHOR_ID, this.getAuthorFxObjectPropertyEdit().getId());
        this.init();
    }

    private void saveOrUpdate(AuthorFx authorFxObjectPropertyEdit) throws ApplicationException {
        AuthorDao authorDao = new AuthorDao();
        Author author = ConverterAuthor.converToAuthor(authorFxObjectPropertyEdit);
        authorDao.creatOrUpdate(author);
        this.init();
    }


    public AuthorFx getAuthorFxObjectProperty() {
        return authorFxObjectProperty.get();
    }

    public void setAuthorFxObjectProperty(AuthorFx authorFxObjectProperty) {
        this.authorFxObjectProperty.set(authorFxObjectProperty);
    }

    public ObjectProperty<AuthorFx> authorFxObjectPropertyProperty() {
        return authorFxObjectProperty;
    }

    public ObservableList<AuthorFx> getAuthorFxObservableList() {
        return authorFxObservableList;
    }

    public void setAuthorFxObservableList(ObservableList<AuthorFx> authorFxObservableList) {
        this.authorFxObservableList = authorFxObservableList;
    }

    public AuthorFx getAuthorFxObjectPropertyEdit() {
        return authorFxObjectPropertyEdit.get();
    }

    public void setAuthorFxObjectPropertyEdit(AuthorFx authorFxObjectPropertyEdit) {
        this.authorFxObjectPropertyEdit.set(authorFxObjectPropertyEdit);
    }

    public ObjectProperty<AuthorFx> authorFxObjectPropertyEditProperty() {
        return authorFxObjectPropertyEdit;
    }
}