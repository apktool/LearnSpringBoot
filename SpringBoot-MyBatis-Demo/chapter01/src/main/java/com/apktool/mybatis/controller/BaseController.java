package com.apktool.mybatis.controller;

import com.apktool.mybatis.utils.ErrCode;
import com.apktool.mybatis.utils.ResponseResult;

public abstract class BaseController {
    protected ResponseResult<Void> getErrResponseResult(Long errCode, String errMsg) {
        return ResponseResult.<Void>builder().errcode(errCode).errmsg(errMsg).build();
    }

    protected <T> ResponseResult<T> getErrResponseResult(T t, Long errCode, String errMsg) {
        return ResponseResult.<T>builder().data(t).errcode(errCode).errmsg(errMsg).build();
    }

    protected <T> ResponseResult<T> getOkResponseResult(T t, String errMsg) {
        return getErrResponseResult(t, ErrCode.OK.getErrCode(), errMsg);
    }

    protected ResponseResult<Void> getOkResponseResult(String errMsg) {
        return getErrResponseResult(ErrCode.OK.getErrCode(), errMsg);
    }
}
