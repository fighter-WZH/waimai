package com.sky.service;

import com.sky.dto.*;
import com.sky.result.PageResult;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;

public interface OrderService {


    /**
     * 用户下单
     * @param ordersSubmitDTO
     * @return
     */
    OrderSubmitVO submit(OrdersSubmitDTO ordersSubmitDTO);

    /**
     * 订单支付修改订单状态
     * @param ordersPaymentDTO
     * @return
     */
    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO);


    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    OrderVO orderDetail(Long orderId);


    /**
     * 历史订单查询
     * @param page
     * @param pageSize
     * @return
     */
    PageResult historyOrders(Integer page, Integer pageSize, Integer status);

    /**
     * 取消订单
     * @param id
     */
    void cancel(Long id);

    /**
     * 再来一单
     * @param id
     */
    void repetition(Long id);


    /**
     * 条件搜索订单
     * @param ordersPageQueryDTO
     * @return
     */
    PageResult conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 各个状态的订单数量统计
     * @param
     * @retur
     */
    OrderStatisticsVO statistics();


    /**
     * 接单
     * @param ordersConfirmDTO
     */
    void confirm(OrdersConfirmDTO ordersConfirmDTO);

    /**
     * 拒单
     * @param ordersRejectionDTO
     */
    void rejection(OrdersRejectionDTO ordersRejectionDTO);


    /**
     * 商家取消订单
     * @param ordersCancelDTO
     */
    void cancelByEmployee(OrdersCancelDTO ordersCancelDTO);


    /**
     * 派送订单
     * @param orderId
     */
    void delivery(Long orderId);

    /**
     * 完成订单
     * @param orderId
     */
    void complete(Long orderId);
}
