package com.water.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.water.resource.vm.Code;
import com.water.resource.vm.QueryParamsVM;
import com.water.resource.vm.ResultVM;
import com.water.util.KdniaoTrackQueryAPI;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ExpressService {

    public ResultVM queryCompany(QueryParamsVM queryParamsVM){
        if(StringUtils.isBlank(queryParamsVM.getExpressNo())){
            return new ResultVM(Code.ERROR.getCode(),"","快递编号为空");
        }
        String result = KdniaoTrackQueryAPI.getCompanyByJson(queryParamsVM.getExpressNo());
        JSONObject json = JSONObject.parseObject(result);
        return new ResultVM(Code.SUCCESS.getCode(),json.get("Shippers"),"");
    }

    public ResultVM queryLogisticsTrajectory(QueryParamsVM queryParamsVM){
        if(StringUtils.isBlank(queryParamsVM.getShipperCode()) || StringUtils.isBlank(queryParamsVM.getExpressNo())){
            return new ResultVM(Code.ERROR.getCode(),"","参数不全");
        }
        String result = KdniaoTrackQueryAPI.getOrderTracesByJson(queryParamsVM.getShipperCode(), queryParamsVM.getExpressNo());
        JSONObject json = JSONObject.parseObject(result);
        return new ResultVM(Code.SUCCESS.getCode(),json.get("Traces"),"");
    }
}
