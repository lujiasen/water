package com.water.resource.vm;

import java.util.Arrays;
import java.util.Map;

/**
 * @Description 查询列表入参类
 * @Author lingchen
 * @Email lingchen@winning.com.cn
 * @CreateDate 2019/5/22 8:55
 * @Version v1.0
 */
public class QueryParamsVM {
    //分页信息
    private PageVM pagevm;
    //查询条件
    private Map<String, Object> criteriaMap;

    private String expressNo;
    private String shipperName;
    private String shipperCode;

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public PageVM getPagevm() {
        return pagevm;
    }

    public void setPagevm(PageVM pagevm) {
        this.pagevm = pagevm;
    }

    public Map<String, Object> getCriteriaMap() {
        return criteriaMap;
    }

    public void setCriteriaMap(Map<String, Object> criteriaMap) {
        this.criteriaMap = criteriaMap;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }
}
