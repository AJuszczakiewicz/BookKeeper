package book.keeper.utils.converters;

import book.keeper.database.models.Category;
import book.keeper.modelFX.CategoryFx;

public class ConverterCategory {

    public static CategoryFx convertToCategoryFx(Category category) {
        CategoryFx categoryFx = new CategoryFx();
        categoryFx.setId(category.getId());
        categoryFx.setName(category.getName());
        return categoryFx;
    }
}