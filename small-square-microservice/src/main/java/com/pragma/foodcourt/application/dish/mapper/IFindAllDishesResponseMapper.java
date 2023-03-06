package com.pragma.foodcourt.application.dish.mapper;

import com.pragma.foodcourt.application.dish.dto.response.FindAllDishesResponseDto;
import com.pragma.foodcourt.domain.model.DishModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IFindAllDishesResponseMapper {

    FindAllDishesResponseDto toDishResponse(DishModel dishModel);

    List<FindAllDishesResponseDto> dishResponseList(List<DishModel> dishModelList);

}
