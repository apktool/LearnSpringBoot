package com.apktool.jpa.controller;

import com.apktool.jpa.service.UserClassService;
import com.apktool.jpa.utils.ResponseResult;
import com.apktool.jpa.vo.UserClassVo;
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
    private UserClassService userClassService;

    @GetMapping(value = {"/get"})
    public ResponseResult<UserClassVo> find(@RequestParam Integer id) {
        log.info("get user " + id + " success");
        return getOkResponseResult(userClassService.get(id), "获取用户成功");
    }

    // http://localhost:8080/api/user/gets?id=1&id=2&id=3
    @GetMapping(value = {"/gets"})
    public ResponseResult<List<UserClassVo>> find(@RequestParam List<Integer> id) {
        log.info("get user " + id + " success");
        return getOkResponseResult(userClassService.get(id), "获取所有用户成功");
    }

    @GetMapping(value = {"/select"})
    public ResponseResult<UserClassVo> select(@RequestParam Integer id) {
        log.info("get user " + id + " success");
        return getOkResponseResult(userClassService.select(id), "获取用户成功");
    }

    // http://localhost:8080/api/user/selects?id=1&id=2&id=3
    @GetMapping(value = {"/selects"})
    public ResponseResult<List<UserClassVo>> select(@RequestParam List<Integer> id) {
        log.info("get user " + id + " success");
        return getOkResponseResult(userClassService.select(id), "获取所有用户成功");
    }
}
