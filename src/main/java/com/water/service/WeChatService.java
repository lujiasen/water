package com.water.service;

import com.water.resource.WeChatResource;
import com.water.util.WeiXinServerMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WeChatService {

    public static final Logger logger = LoggerFactory.getLogger(WeChatResource.class);


    public String callback(Map<String, String> map, String type) {

        //获取二维码Ticket
        String openid=map.get("FromUserName");
        logger.info("openid--"+openid);
        String Ticket = map.get("Ticket");
        logger.info("Ticket--"+Ticket);
        String paramEWM="-1";
        //获取二维码参数
        if(Ticket!=null){
            String EventKey = map.get("EventKey");
            if(EventKey.indexOf("qrscene_")!=-1){
                String[] temparr = EventKey.split("_");
                paramEWM = temparr[1];
                logger.info("EventKey--"+EventKey);
                logger.info("paramEWM--"+paramEWM);

            }

        }
//        String msgType = map.get("MsgType");
//        User user = (User)wechatDao.queryOne("User.getUser",openid);
//        //获取用户信息
//        if(user == null){
//            user = new User();
//            user.setOpenId(openid);
//            wechatDao.insert("User.insertUser",user);
//        }
//        map.put("userId",String.valueOf(user.getId()));
        String resultxXml = WeiXinServerMenu.replyMessage(map,paramEWM);
        return resultxXml;
    }
}
