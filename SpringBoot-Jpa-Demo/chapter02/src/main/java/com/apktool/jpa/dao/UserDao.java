package com.apktool.jpa.dao;

import com.apktool.jpa.entity.UserEntity;
import com.apktool.jpa.pojo.UserClassDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
    @Query("SELECT new com.apktool.jpa.pojo.UserClassDo(t.id, t.name, t.age, t.email, c.name)" +
            " FROM UserEntity AS t " +
            " LEFT JOIN ClassEntity AS c ON t.clazz.id = c.id " +
            " WHERE t.id = :id")
    Optional<UserClassDo> selectById(@Param("id") Integer id);

    @Query("SELECT new com.apktool.jpa.pojo.UserClassDo(t.id, t.name, t.age, t.email, c.name)" +
            " FROM UserEntity AS t " +
            " LEFT JOIN ClassEntity AS c ON t.clazz.id = c.id " +
            " WHERE t.id in (:ids)")
    List<UserClassDo> selectAllById(@Param("ids") List<Integer> ids);
}
