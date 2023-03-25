package com.apktool.mybatis.service;

import com.apktool.mybatis.dao.UserDao;
import com.apktool.mybatis.entity.UserEntity;
import com.apktool.mybatis.model.UserModel;
import com.apktool.mybatis.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public Boolean add(UserModel user) {
        UserEntity entity = new UserEntity();
        entity.setId(11);
        entity.setName(user.getName());
        entity.setAge(user.getAge());
        entity.setEmail(user.getEmail());
        userDao.save(entity);
        return true;
    }

    public UserVo get(Integer id) {
        UserEntity entity = Objects.requireNonNullElse(userDao.findById(id), new UserEntity());
        UserVo userVo = new UserVo();
        userVo.setId(entity.getId());
        userVo.setName(entity.getName());
        userVo.setAge(entity.getAge());
        userVo.setEmail(entity.getEmail());
        return userVo;
    }

    public List<UserVo> get(List<Integer> ids) {
        List<UserEntity> entities = userDao.findByIds(ids);
        List<UserVo> res = new ArrayList<>(entities.size());
        for (UserEntity entity : entities) {
            if (entity.equals(null)) {
                continue;
            }
            UserVo userVo = new UserVo();
            userVo.setId(entity.getId());
            userVo.setName(entity.getName());
            userVo.setAge(entity.getAge());
            userVo.setEmail(entity.getEmail());
            res.add(userVo);
        }

        return res;
    }
}
