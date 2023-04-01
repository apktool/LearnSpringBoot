package com.apktool.jpa.service;

import com.apktool.jpa.dao.UserDao;
import com.apktool.jpa.pojo.UserClassDo;
import com.apktool.jpa.entity.UserEntity;
import com.apktool.jpa.vo.UserClassVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserClassService {
    @Autowired
    private UserDao userDao;

    public UserClassVo get(Integer id) {
        Optional<UserEntity> entityOptional = userDao.findById(id);
        if (entityOptional.isEmpty()) {
            return new UserClassVo();
        }
        UserEntity entity = entityOptional.get();
        UserClassVo userClassVo = new UserClassVo();
        userClassVo.setUserId(entity.getId());
        userClassVo.setUserName(entity.getName());
        userClassVo.setUserAge(entity.getAge());
        userClassVo.setUserEmail(entity.getEmail());
        userClassVo.setClassName(entity.getClazz().getName());
        return userClassVo;
    }

    public List<UserClassVo> get(List<Integer> ids) {
        List<UserEntity> entities = userDao.findAllById(ids);
        List<UserClassVo> res = new ArrayList<>(entities.size());
        for (UserEntity entity : entities) {
            if (entity == null) {
                continue;
            }

            UserClassVo userClassVo = new UserClassVo();
            userClassVo.setUserId(entity.getId());
            userClassVo.setUserName(entity.getName());
            userClassVo.setUserAge(entity.getAge());
            userClassVo.setUserEmail(entity.getEmail());
            userClassVo.setClassName(entity.getClazz().getName());
            res.add(userClassVo);
        }

        return res;
    }

    public UserClassVo select(Integer id) {
        Optional<UserClassDo> entityOptional = userDao.selectById(id);
        if (entityOptional.isEmpty()) {
            return new UserClassVo();
        }

        UserClassDo entity = entityOptional.get();
        UserClassVo userClassVo = new UserClassVo();
        userClassVo.setUserId(entity.getUserId());
        userClassVo.setUserName(entity.getUserName());
        userClassVo.setUserAge(entity.getUserAge());
        userClassVo.setUserEmail(entity.getUserEmail());
        userClassVo.setClassName(entity.getClassName());
        return userClassVo;
    }

    public List<UserClassVo> select(List<Integer> ids) {
        List<UserClassDo> entities = userDao.selectAllById(ids);
        List<UserClassVo> res = new ArrayList<>(entities.size());
        for (UserClassDo entity : entities) {
            if (entity == null) {
                continue;
            }

            UserClassVo userClassVo = new UserClassVo();
            userClassVo.setUserId(entity.getUserId());
            userClassVo.setUserName(entity.getUserName());
            userClassVo.setUserAge(entity.getUserAge());
            userClassVo.setUserEmail(entity.getUserEmail());
            userClassVo.setClassName(entity.getClassName());

            res.add(userClassVo);
        }

        return res;
    }
}
