package com.apktool.mybatis.dao;

import com.apktool.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public UserEntity findById(Integer id);

    public void save(@Param("user") UserEntity entity);

    public List<UserEntity> findByIds(List<Integer> ids);
}
