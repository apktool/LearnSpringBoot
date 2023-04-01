package com.apktool.mybatis.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    @Setter
    @Getter
    private Long errcode;

    @Setter
    @Getter
    private String errmsg;

    @Setter
    @Getter
    private T data;

    ResponseResult(Long errcode, String errmsg, T data) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
    }

    public static <T> ResponseResultBuilder<T> builder() {
        return new ResponseResultBuilder<T>();
    }

    public static class ResponseResultBuilder<T> {
        private Long errcode;
        private String errmsg;
        private T data;

        ResponseResultBuilder() {
        }

        public ResponseResultBuilder<T> errcode(Long errcode) {
            this.errcode = errcode;
            return this;
        }

        public ResponseResultBuilder<T> errmsg(String errmsg) {
            this.errmsg = errmsg;
            return this;
        }

        public ResponseResultBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResponseResult<T> build() {
            return new ResponseResult<T>(this.errcode, this.errmsg, this.data);
        }
    }
}
