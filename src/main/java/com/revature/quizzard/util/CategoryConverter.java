package com.revature.quizzard.util;

import com.revature.quizzard.models.Category;
import com.revature.quizzard.models.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null) {
            throw new IllegalArgumentException();
        }
        return category.toString();
    }

    @Override
    public Category convertToEntityAttribute(String categoryName) {
        return Stream.of(Category.values())
                .filter(c -> c.toString().equals(categoryName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
