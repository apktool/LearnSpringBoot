package com.apktool.jpa.controller;

import com.apktool.jpa.model.UserModel;
import com.apktool.jpa.service.UserService;
import com.apktool.jpa.utils.ResponseResult;
import com.apktool.jpa.vo.UserVo;
import jakarta.validation.Valid;
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
public class UserController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping(value = {"/add"})
    public ResponseResult<Boolean> add(@Valid @RequestBody UserModel model) {
        return getOkResponseResult(userService.add(model), "");
    }

    @GetMapping(value = {"/get"})
    public ResponseResult<UserVo> find(@RequestParam Integer id) {
        log.info("get user " + id + " success");
        return getOkResponseResult(userService.get(id), "获取用户成功");
    }

    // http://localhost:8080/api/user/gets?id=1&id=2&id=3
    @GetMapping(value = {"/gets"})
    public ResponseResult<List<UserVo>> find(@RequestParam List<Integer> id) {
        log.info("get user " + id + " success");
        return getOkResponseResult(userService.get(id), "获取所有用户成功");
    }
}
