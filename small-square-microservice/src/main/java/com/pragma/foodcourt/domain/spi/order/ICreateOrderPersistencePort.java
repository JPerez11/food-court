package com.pragma.foodcourt.domain.spi.order;

import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;

public interface ICreateOrderPersistencePort {

    void createOrder(OrderModel orderModel, DishOrderModel dishOrderModel);

    void createOrder(OrderModel orderModel);

    void createDishOrder(DishOrderModel dishOrderModel);

}
