package com.apktool.mybatis.dao;

import com.apktool.mybatis.entity.UserClassEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserClassDao extends BaseMapper<UserClassEntity> {
    @Select("SELECT t.id AS userId, t.name  AS userName, t.age  AS userAge, t.email AS userEmail, c.name AS className" +
            " FROM sys_user AS t" +
            " LEFT JOIN sys_class AS c ON t.class_id = c.id" +
            " WHERE t.id = #{id}")
    public UserClassEntity findById(Integer id);

    @Select("<script>" +
            "SELECT t.id AS userId, t.name  AS userName, t.age  AS userAge, t.email AS userEmail, c.name AS className" +
            " FROM sys_user AS t" +
            " LEFT JOIN sys_class AS c ON t.class_id = c.id" +
            " WHERE t.id IN " +
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>" +
            " #{id,jdbcType=INTEGER}" +
            "</foreach>" +
            "</script>")
    public List<UserClassEntity> findByIds(List<Integer> ids);
}
