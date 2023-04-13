package com.website.utils;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -2234571636295254776L;

    /**
     * 编码
     **/
    private String code;
    /**
     * 失败时为失败原因
     **/
    private String msg;
    /**
     * 成功时的返回数据
     **/
    private T data;

    public Result() {

    }

    /**
     * 返回成功
     *
     * @param data
     * @return
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.ALLCROWD_REQ_SUCCESS.getCode());
        result.setMsg(ResultEnum.ALLCROWD_REQ_SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 返回成功
     *
     * @return
     */
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.ALLCROWD_REQ_SUCCESS.getCode());
        result.setMsg(ResultEnum.ALLCROWD_REQ_SUCCESS.getMsg());
        return result;
    }

    /**
     * 返回失败
     *
     * @return
     */
    public static <T> Result<T> fail(ResultEnum errorEnum) {
        Result<T> result = new Result<>();
        result.setCode(errorEnum.getCode());
        result.setMsg(errorEnum.getMsg());
        return result;
    }

    public static <T> Result<T> fail(String msg) {
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.ALLCROWD_REQ_FAIL.getCode());
        result.setMsg(msg);
        return result;
    }

    /**
     * 返回失败
     *
     * @return
     */
    public static <T> Result<T> fail(String code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 构建Result
     *
     * @param errorEnum
     * @return
     */
    public static <T> Result<T> build(ResultEnum errorEnum) {
        return Result.build(errorEnum.getCode(), errorEnum.getMsg());
    }


    /**
     * 构建Result
     *
     * @param errorEnum
     * @param data
     * @return
     */
    public static <T> Result<T> build(ResultEnum errorEnum, T data) {
        return Result.build(errorEnum.getCode(), errorEnum.getMsg(), data);
    }

    /**
     * 构建Result
     *
     * @param code
     * @param data
     * @return
     */
    public static <T> Result<T> build(String code, T data) {
        return Result.build(code, null, data);
    }

    /**
     * 构建Result
     *
     * @param code
     * @param msg
     * @return
     */
    public static <T> Result<T> build(String code, String msg) {
        return Result.build(code, msg, null);
    }

    /**
     * 构建Result
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static <T> Result<T> build(String code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 判断返回结果是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        return StringUtils.equals(code, ResultEnum.ALLCROWD_REQ_SUCCESS.getCode());
    }

    /**
     * 判断返回结果是否成功
     *
     * @return
     */
    public void setSuccess(Boolean success) {

    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
