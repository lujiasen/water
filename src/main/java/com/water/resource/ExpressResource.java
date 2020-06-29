package com.water.resource;

import com.water.resource.vm.QueryParamsVM;
import com.water.resource.vm.ResultVM;
import com.water.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/express")
public class ExpressResource {

    @Autowired
    private ExpressService expressService;

    @PostMapping("/queryCompany")
    public ResultVM queryCompany(@RequestBody QueryParamsVM queryParamsVM){
        return expressService.queryCompany(queryParamsVM);
    }

    @PostMapping("/queryLogisticsTrajectory")
    public ResultVM queryLogisticsTrajectory(@RequestBody QueryParamsVM queryParamsVM){
        return expressService.queryLogisticsTrajectory(queryParamsVM);
    }

}
