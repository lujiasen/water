package com.water.resource.vm;

public enum Code {
    EXPRESS_NO_ERROR("0", "暂无轨迹信息"),
    SUCCESS("0000","成功"),
    ERROR("9999","失败"),
    ERROR_AUTH("9997","auth未认证"),
    TOKEN_FAIL("9998","token");
    // 编码
    public String code;
    // msg
    public String msg;

    Code(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
