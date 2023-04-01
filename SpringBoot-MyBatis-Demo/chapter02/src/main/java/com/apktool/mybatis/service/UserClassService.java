package com.apktool.mybatis.service;

import com.apktool.mybatis.dao.UserClassDao;
import com.apktool.mybatis.entity.UserClassEntity;
import com.apktool.mybatis.vo.UserClassVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserClassService {
    @Autowired
    private UserClassDao userClassDao;

    public UserClassVo get(Integer id) {
        UserClassEntity entity = Objects.requireNonNullElse(userClassDao.findById(id), new UserClassEntity());
        UserClassVo userClassVo = new UserClassVo();
        userClassVo.setUserId(entity.getUserId());
        userClassVo.setUserName(entity.getUserName());
        userClassVo.setUserAge(entity.getUserAge());
        userClassVo.setUserEmail(entity.getUserEmail());
        userClassVo.setClassName(entity.getClassName());
        return userClassVo;
    }

    public List<UserClassVo> get(List<Integer> ids) {
        List<UserClassEntity> entities = userClassDao.findByIds(ids);
        List<UserClassVo> res = new ArrayList<>(entities.size());
        for (UserClassEntity entity : entities) {
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
