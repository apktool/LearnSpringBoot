package com.apktool.mybatis.dao;

import com.apktool.mybatis.entity.UserClassEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserClassDao {
    public UserClassEntity findById(Integer id);

    public List<UserClassEntity> findByIds(List<Integer> ids);
}
