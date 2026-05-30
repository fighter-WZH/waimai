package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     *
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /**
     * 插入菜品数据
     *
     */
    void insert(Dish dish);


    /**
     * 菜品查询
     *
     */
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);


    /**
     * 根据id查询菜品
     *
     */
    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);



    /**
     * 根据id删除菜品数据
     *
     */
    void deleteByIds(List<Long> ids);

    /**
     * 根据id查询菜品以及分类
     *
     */
    DishVO getByIdWithCategory(Long id);

    /**
     * 修改菜品数据
     *
     */
    void update(Dish dish);

    /**
     * 根据分类id查询菜品
     *
     */
    List<DishVO> list(Long categoryId);

    /**
     * 根据条件统计菜品数量
     * @param map
     * @return
     */
    Integer countByMap(Map map);
}
