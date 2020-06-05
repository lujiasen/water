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

    private PageVM pagevm;//分页信息
    private Map<String, Object> criteriaMap;//查询条件
    private Integer chaperoneId;// 陪护卡用户
    private String hospitalId;
    private String chaperoneIdCard;
    private String authCode;
    private Integer inpatientAreaId;
    private String module;
    private String type;
    private String deviceId;
    private String[] types;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getChaperoneIdCard() {
        return chaperoneIdCard;
    }

    public void setChaperoneIdCard(String chaperoneIdCard) {
        this.chaperoneIdCard = chaperoneIdCard;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getChaperoneId() {
        return chaperoneId;
    }

    public void setChaperoneId(Integer chaperoneId) {
        this.chaperoneId = chaperoneId;
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

    public Integer getInpatientAreaId() {
        return inpatientAreaId;
    }

    public void setInpatientAreaId(Integer inpatientAreaId) {
        this.inpatientAreaId = inpatientAreaId;
    }

    @Override
    public String toString() {
        return "QueryParamsVM{" +
                "pagevm=" + pagevm +
                ", criteriaMap=" + criteriaMap +
                ", chaperoneId=" + chaperoneId +
                ", hospitalId='" + hospitalId + '\'' +
                ", inpatientAreaId=" + inpatientAreaId +
                ", type='" + type + '\'' +
                ", types=" + Arrays.toString(types) +
                '}';
    }
}
