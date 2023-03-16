package com.pragma.foodcourt.infrastructure.output.jpa.adapter.order;

import com.pragma.foodcourt.domain.model.DishOrderModel;
import com.pragma.foodcourt.domain.model.OrderModel;
import com.pragma.foodcourt.domain.spi.order.ICreateOrderPersistencePort;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.order.IDishOrderEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.order.IOrderEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishOrderRepository;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateOrderAdapter implements ICreateOrderPersistencePort {

    private final IOrderRepository orderRepository;
    private final IDishOrderRepository dishOrderRepository;
    private final IOrderEntityMapper orderEntityMapper;
    private final IDishOrderEntityMapper dishOrderEntityMapper;

    @Override
    public void createOrder(OrderModel orderModel, DishOrderModel dishOrderModel) {

        orderRepository.save(orderEntityMapper.toOrderEntity(orderModel));
        dishOrderRepository.save(dishOrderEntityMapper.toDishOrderEntity(dishOrderModel));

    }

    @Override
    public void createOrder(OrderModel orderModel) {
        orderRepository.save(orderEntityMapper.toOrderEntity(orderModel));
    }

    @Override
    public void createDishOrder(DishOrderModel dishOrderModel) {
        dishOrderRepository.save(dishOrderEntityMapper.toDishOrderEntity(dishOrderModel));
    }
}
