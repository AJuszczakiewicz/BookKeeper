package book.keeper.modelFX;

import javafx.beans.property.*;

import java.time.LocalDate;

public class BookFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<CategoryFx> categoryFx = new SimpleObjectProperty<>();
    private ObjectProperty<AuthorFx> authorFx = new SimpleObjectProperty<>();
    private SimpleStringProperty title = new SimpleStringProperty();
    private SimpleStringProperty description = new SimpleStringProperty();
    private ObjectProperty<LocalDate> releaseDate = new SimpleObjectProperty<>();
    private SimpleStringProperty isbn = new SimpleStringProperty();
    private IntegerProperty rating = new SimpleIntegerProperty();
    private ObjectProperty<LocalDate> addedDate = new SimpleObjectProperty(LocalDate.now());

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public CategoryFx getCategoryFx() {
        return categoryFx.get();
    }

    public void setCategoryFx(CategoryFx categoryFx) {
        this.categoryFx.set(categoryFx);
    }

    public ObjectProperty<CategoryFx> categoryFxProperty() {
        return categoryFx;
    }

    public AuthorFx getAuthorFx() {
        return authorFx.get();
    }

    public void setAuthorFx(AuthorFx authorFx) {
        this.authorFx.set(authorFx);
    }

    public ObjectProperty<AuthorFx> authorFxProperty() {
        return authorFx;
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public String getIsbn() {
        return isbn.get();
    }

    public void setIsbn(String isbn) {
        this.isbn.set(isbn);
    }

    public SimpleStringProperty isbnProperty() {
        return isbn;
    }

    public int getRating() {
        return rating.get();
    }

    public void setRating(int rating) {
        this.rating.set(rating);
    }

    public IntegerProperty ratingProperty() {
        return rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate.get();
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate.set(releaseDate);
    }

    public ObjectProperty<LocalDate> releaseDateProperty() {
        return releaseDate;
    }

    public LocalDate getAddedDate() {
        return addedDate.get();
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate.set(addedDate);
    }

    public ObjectProperty<LocalDate> addedDateProperty() {
        return addedDate;
    }

    @Override
    public String toString() {
        return "BookFx{" +
                "id=" + id.get() +
                ", categoryFx=" + categoryFx.get() +
                ", authorFx=" + authorFx.get() +
                ", title=" + title.get() +
                ", description=" + description.get() +
                ", releaseDate=" + releaseDate.get() +
                ", isbn=" + isbn.get() +
                ", rating=" + rating.get() +
                ", addedDate=" + addedDate.get() +
                '}';
    }
}