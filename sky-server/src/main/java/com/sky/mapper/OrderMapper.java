package com.sky.mapper;


import com.github.pagehelper.Page;
import com.sky.dto.GoodsSalesDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    /**
     * 插入订单数据
     * @param orders
     */
    void insert(Orders orders);

    /**
     * 根据订单号查询订单
     * @param orderNumber
     */
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    /**
     * 修改订单信息
     * @param orders
     */
    void update(Orders orders);

    /**
     * 根据id查询订单
     * @param orderId
     * @return
     */
    @Select("select * from orders where id = #{orderId}")
    Orders getById(Long orderId);

    /**
     * 订单分页查询
     * @param ordersPageQueryDTO
     * @return
     */
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);


    /**
     * 统计订单数据
     * @param
     * @return
     */
    Integer countStatus(Integer status);

    /**
     * 获取超时的订单
     * @return
     */
    @Select("select * from orders where status = #{status} and order_time < #{outTime}")
    List<Orders> cancelOutTimeOrder(Integer status, LocalDateTime outTime);


    /**
     * 根据日期统计营业额
     * @param map
     * @return
     */
    @Select("select sum(amount) from orders where order_time between #{begin} and #{end} and status = #{status}")
    Double sumByDate(Map map);

    /**
     * 根据日期统计订单数量
     * @param beginTime
     * @param endTime
     * @param status
     * @return
     */
    Integer getOrderCount(LocalDateTime beginTime, LocalDateTime endTime, Integer status);

    /**
     * 查询销量排名top10
     * @param beginTime
     * @param endTime
     * @return
     */
    List<GoodsSalesDTO> getTop10(LocalDateTime beginTime, LocalDateTime endTime);
}
