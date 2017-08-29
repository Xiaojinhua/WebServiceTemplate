package com.istuary.webserviceTemplate.api.dal.custom;

import com.istuary.webserviceTemplate.api.dal.generated.UserDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xiaojinhua on 17/8/26.
 */
public interface UserCustomMapper
{
    @Select("select * from user where id = #{id}")
    @ResultMap("com.istuary.webserviceTemplate.api.dal.generated.UserDOMapper.BaseResultMap")
    UserDO getByUserId(int id);
    
    @Select("select * from user where name = #{name}")
    @ResultMap("com.istuary.webserviceTemplate.api.dal.generated.UserDOMapper.BaseResultMap")
    UserDO getByUserName(String name);
    
    @Select("select * from user")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "password",property = "password"),
            @Result(column = "desc",property = "desc"),
            @Result(column = "created_date",property = "createdDate"),
            @Result(column = "updated_date",property = "updatedDate")
    })
    List<UserDO> getAllUsers();
    
    @Insert("insert into user(name,password,`desc`,created_date,updated_date) values(#{name},#{password},#{desc},now(),now())")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(UserDO userDO);
    
    @Update("update user set name=#{name},password=#{password},`desc`=#{desc},created_date=#{created_date},updated_date=#{updated_date} where id =#{id}")
    int update(UserDO userDO);
    
    @Delete("delete from user where id =#{id}")
    int delete(int id);
}
