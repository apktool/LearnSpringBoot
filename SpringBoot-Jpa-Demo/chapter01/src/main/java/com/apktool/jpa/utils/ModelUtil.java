package com.apktool.jpa.utils;

import com.apktool.jpa.entity.BaseEntity;
import com.apktool.jpa.model.BaseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ModelUtil {
    private static final Logger log = LoggerFactory.getLogger(ModelUtil.class);
    public static final String[] DEFAULT_IGNORE = new String[]{"tableName"};

    public static <T> T toModel(BaseEntity entity, Class<T> clazz) {
        return ModelUtil.toModel(entity, clazz, DEFAULT_IGNORE);
    }

    public static <T> T toModel(BaseEntity entity, Class<T> clazz, String... properties) {
        if (entity == null) {
            return null;
        }
        try {
            T model = clazz.newInstance();
            BeanUtils.copyProperties((Object) entity, model, (String[]) properties);
            return model;
        } catch (IllegalAccessException | InstantiationException e) {
            log.error("对象转换错误, error: " + e.getMessage(), (Throwable) e);
            return null;
        }
    }

    public static <T> List<T> toModel(List<? extends BaseEntity> entityList, Class<T> clazz) {
        return ModelUtil.toModel(entityList, clazz, null);
    }

    public static <T> List<T> toModel(List<? extends BaseEntity> entityList, Class<T> clazz, String... properties) {
        if (CollectionUtils.isEmpty(entityList)) {
            return new ArrayList();
        }
        ArrayList<T> list = new ArrayList<T>(entityList.size());
        for (BaseEntity baseEntity : entityList) {
            list.add(ModelUtil.toModel(baseEntity, clazz, properties));
        }
        return list;
    }

    public static <T> T toEntity(BaseModel model, Class<T> clazz) {
        return ModelUtil.toEntity(model, clazz, DEFAULT_IGNORE);
    }

    public static <T> T toEntity(BaseModel model, Class<T> clazz, String... properties) {
        if (model == null) {
            return null;
        }
        try {
            T entity = clazz.newInstance();
            BeanUtils.copyProperties((Object) model, entity, (String[]) properties);
            return entity;
        } catch (IllegalAccessException | InstantiationException e) {
            log.error("对象转换错误, error: " + e.getMessage(), (Throwable) e);
            return null;
        }
    }

    public static <T> List<T> toEntity(List<? extends BaseModel> modelList, Class<T> clazz) {
        if (modelList == null) {
            return null;
        }
        ArrayList<T> list = new ArrayList<T>(modelList.size());
        for (BaseModel baseModel : modelList) {
            list.add(ModelUtil.toEntity(baseModel, clazz));
        }
        return list;
    }

    public static <T> List<T> toEntity(List<? extends BaseModel> modelList, Class<T> clazz, String... properties) {
        ArrayList<T> list = new ArrayList<T>(modelList.size());
        for (BaseModel baseModel : modelList) {
            list.add(ModelUtil.toEntity(baseModel, clazz, properties));
        }
        return list;
    }
}
