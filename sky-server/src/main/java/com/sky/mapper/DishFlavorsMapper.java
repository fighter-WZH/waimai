package com.sky.mapper;

import com.sky.entity.DishFlavor;
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


}
