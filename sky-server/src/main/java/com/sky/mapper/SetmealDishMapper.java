package com.sky.mapper;


import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品id查询对应的套餐id
     * @param ids
     * @return
     */
    List<Long> getSetmealIdByDishIds(List<Long> ids);

    /**
     * 批量插入套餐和菜品的关联数据
     * @param setmealDish
     */
    //setmeal_id, dish_id, name, price, copies
    @Insert("insert into setmeal_dish (setmeal_id, dish_id, name, price, copies) VALUES " +
            "(#{setmealId}, #{dishId}, #{name}, #{price}, #{copies})")
    void insert(SetmealDish setmealDish);


    /**
     * 批量删除套餐和菜品的关联数据
     * @param ids
     */
    void deleteBySetmealIds(List<Long> ids);

    /**
     * 根据套餐id查询套餐和菜品的关联数据
     * @param id
     * @return
     */
    List<SetmealDish> getSetmealDishesBySetmealId(Long id);


    /**
     * 根据套餐id删除套餐和菜品的关联数据
     * @param id
     */
    @Delete("delete from setmeal_dish where setmeal_id = #{id}")
    void deleteBySetmealId(Long id);
}
