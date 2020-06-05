package com.water.resource.vm;

import java.io.Serializable;

/**
 * @Description 返回结果出参类
 * @Author       lingchen
 * @Email        lingchen@winning.com.cn
 * @CreateDate  2019/5/20 10:32
 * @Version      v1.0
 */
public class ResultVM implements Serializable {

    private String code;//是否成功，1成功，0失败
    private String msg;//提示信息
    private Object data;//返回值

    public ResultVM(String code, Object data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
        this.code = code;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
