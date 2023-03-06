package com.pragma.foodcourt.application.dish.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateDishStatusRequestDto {

    @NotNull(message = "Field active cannot empty")
    @NotEmpty(message = "Field active cannot empty")
    private boolean active;

}
