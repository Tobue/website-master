package com.website.utils;

import java.io.Serializable;

public enum ResultEnum implements Serializable {

    ALLCROWD_REQ_SUCCESS("000000", "成功"),

    ALLCROWD_SESSION_OUT("100000", "请求超时"),

    ALLCROWD_REQ_WRANING("888888", "系统警告"),

    ALLCROWD_REQ_FAIL("999999", "系统异常，请联系管理员"),

    G_PARAM_NULL_ERROR("900000", "参数不能为空或解析错误"),

    G_PARAM_ERROR("900001", "参数错误"),

    NO_AUTH_REQ_ERROR("777777", "没有此功能权限"),

    ALLCROWD_ILLEGAL_PARAMETER_ERROR("100001", "非法参数"),;


    /**
     * 错误代码
     */
    private String code;

    /**
     * 详细信息
     */
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    public static ResultEnum getResultEnum(String code) {
        for (ResultEnum value : ResultEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

    /**
     * 根据状态码获取状态对应说明
     *
     * @param code 状态码
     * @return 状态码说明
     */
    public static String getMsg(String code) {
        ResultEnum resultEnum = getResultEnum(code);
        return resultEnum == null ? "" : resultEnum.getMsg();
    }
}
