package com.sky.mapper;

import com.sky.dto.SetmealDTO;
import com.sky.entity.Setmeal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SetmealMapper {


    /**
     * 根据分类id查询套餐的数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);



    /**
     * 插入套餐数据
     * @param setmeal
     */
    void insert(Setmeal setmeal);
}
