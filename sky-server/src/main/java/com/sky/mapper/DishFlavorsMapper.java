package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorsMapper {

    /**
     * 根据id插入口味集合
     * @param flavors
     * @return
     */
    void insertBatch(List<DishFlavor> flavors);


    /**
     * 根据菜品id删除对应的口味数据
     * @param ids
     * @return
     */
    void deleteByDishIds(List<Long> ids);


    /**
     * 根据菜品id查询对应的口味数据
     * @param id
     * @return
     */
    List<DishFlavor> getByDishId(Long id);


    /**
     * 根据菜品id删除对应的口味数据
     * @param id
     * @return
     */
    @Delete("delete from dish_flavor where dish_id = #{id}")
    void deleteByDishId(Long id);
}
