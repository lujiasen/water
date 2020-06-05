package com.water.resource.vm;

/**
 * @Description 分页入参类
 * @Author       lingchen
 * @Email        lingchen@winning.com.cn
 * @CreateDate  2019/5/22 8:55
 * @Version      v1.0
 */
public class PageVM {

    private int pi;
    private int ps;
    private int total;

    public int getPi() {
        if (pi == 0) {
            pi = 1;
        }
        return pi;
    }

    public void setPi(int pi) {
        this.pi = pi;
    }

    public int getPs() {
        if(ps <= 0){
            ps = 1;
        }
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageVM{" +
                "pi=" + pi +
                ", ps=" + ps +
                ", total=" + total +
                '}';
    }
}
