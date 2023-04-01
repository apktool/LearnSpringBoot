package com.apktool.mybatis.utils;

import lombok.Getter;

public enum ErrCode {
    OK(0L, "成功"),
    PARAMETER_ERROR(100001L, "参数错误！");

    @Getter
    private final long errCode;
    @Getter
    private final String errMsg;

    private ErrCode(long errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
