package com.apktool.jpa.service;

import com.apktool.jpa.dao.UserDao;
import com.apktool.jpa.entity.UserEntity;
import com.apktool.jpa.model.UserModel;
import com.apktool.jpa.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public Boolean add(UserModel user) {
        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        entity.setAge(user.getAge());
        entity.setEmail(user.getEmail());
        userDao.save(entity);
        userDao.flush();
        return true;
    }

    public UserVo get(Integer id) {
        Optional<UserEntity> entityOptional = userDao.findById(id);
        if (entityOptional.isEmpty()) {
            return new UserVo();
        }
        UserEntity entity = entityOptional.get();
        UserVo userVo = new UserVo();
        userVo.setId(entity.getId());
        userVo.setName(entity.getName());
        userVo.setAge(entity.getAge());
        userVo.setEmail(entity.getEmail());
        return userVo;
    }

    public List<UserVo> get(List<Integer> ids) {
        List<UserEntity> entities = userDao.findAllById(ids);
        List<UserVo> res = new ArrayList<>(entities.size());
        for (UserEntity entity : entities) {
            if (entity == null) {
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
