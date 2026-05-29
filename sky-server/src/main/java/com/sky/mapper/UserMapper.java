package com.sky.mapper;


import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

@Mapper
public interface UserMapper {


    /**
     * 根据openid查询用户
     * @param openid
     * @return
     */
    @Select("select * from user where openid = #{openid}")
    User getByOpenid(String openid);



    /**
     * 插入用户数据
     * @param user
     */
    void insert(User user);


    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getById(Long userId);

    /**
     * 根据时间统计新用户数量
     * @param beginTime
     * @param endTime
     * @return
     */
    @Select("select count(id) from user where create_time between #{beginTime} and #{endTime}")
    Double sumNewUser(LocalDateTime beginTime, LocalDateTime endTime);

    /**
     * 根据时间统计总用户数量
     * @param endTime
     * @return
     */
    @Select("select count(id) from user where create_time <= #{endTime}")
    Double sumTotalUser(LocalDateTime endTime);
}
