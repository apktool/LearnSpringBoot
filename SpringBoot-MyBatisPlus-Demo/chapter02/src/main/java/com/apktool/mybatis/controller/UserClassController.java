package com.apktool.mybatis.controller;

import com.apktool.mybatis.service.UserClassService;
import com.apktool.mybatis.utils.ResponseResult;
import com.apktool.mybatis.vo.UserClassVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = {"/user"})
@ResponseBody
public class UserClassController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(UserClassController.class);
    @Autowired
    private UserClassService userService;

    @GetMapping(value = {"/get"})
    public ResponseResult<UserClassVo> find(@RequestParam Integer id) {
        log.info("get user " + id + " success");
        return getOkResponseResult(userService.get(id), "获取用户班级成功");
    }

    // http://localhost:8080/api/user/gets?id=1&id=2&id=3
    @GetMapping(value = {"/gets"})
    public ResponseResult<List<UserClassVo>> find(@RequestParam List<Integer> id) {
        log.info("get user " + id + " success");
        return getOkResponseResult(userService.get(id), "获取所有用户班级成功");
    }
}