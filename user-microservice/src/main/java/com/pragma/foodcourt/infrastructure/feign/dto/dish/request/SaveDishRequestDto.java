package com.pragma.foodcourt.infrastructure.feign.dto.dish.request;

import com.pragma.foodcourt.infrastructure.feign.pojos.RestaurantModel;
import com.pragma.foodcourt.infrastructure.feign.pojos.CategoryModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class SaveDishRequestDto {

    @NotNull(message = "Field name cannot empty")
    @NotEmpty(message = "Field name cannot empty")
    private String name;
    @NotNull(message = "Field price cannot empty")
    @NotEmpty(message = "Field price cannot empty")
    @Positive
    private int price;
    @NotNull(message = "Field description cannot empty")
    @NotEmpty(message = "Field description cannot empty")
    private String description;
    @NotEmpty(message = "Field url image cannot empty")
    private String urlImage;
    @NotEmpty(message = "Field active cannot empty")
    private boolean active = true;
    @NotEmpty(message = "Field restaurant cannot empty")
    private RestaurantModel idRestaurant;
    @NotEmpty(message = "Field category cannot empty")
    private CategoryModel idCategory;

}
