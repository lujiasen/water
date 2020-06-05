package com.water.resource;

import com.water.service.WeChatService;
import com.water.util.MessageUtil;
import com.water.util.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/weChat")
public class WeChatResource {

    @Autowired
    private WeChatService weChatService;

    public static final Logger logger = LoggerFactory.getLogger(WeChatResource.class);

    @RequestMapping(value = "/callback", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String callback(HttpServletRequest request) {
        String resultStr = null;
        ////微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        //随机字符串
        String echostr = request.getParameter("echostr");
        if (echostr != null) {
            resultStr = echostr;
        } else {
            String signature = request.getParameter("signature");
            //时间戳
            String timestamp = request.getParameter("timestamp");
            //随机数
            String nonce = request.getParameter("nonce");

            logger.info("signature----" + signature);
            logger.info("timestamp----" + timestamp);
            logger.info("nonce----" + nonce);
            logger.info("echostr----" + echostr);
            //此处指令牌
            String token = "lujiasen";
            String getSignatureStr = SignUtil.getSignature(timestamp, nonce, token);
            logger.info("getSignatureStr----" + getSignatureStr);

            try {
                Map<String, String> map = MessageUtil.parseXml(request);
                //根据company_id查询微信端欢迎语
                resultStr = weChatService.callback(map, token);
                logger.info(resultStr);
            } catch (Exception e) {
                // TODO: handle exception
                logger.error("callback.json--出错--", e.fillInStackTrace());
            }
        }
        return resultStr;
    }
}
