package com.water.util;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.water.dto.weChat.TextMessage;

import java.util.Map;


/**
 * 
* @Title: WeChatResultMessage.java  
* @Package com.somur.common  
* @Description: 用户返回的message  
* @author lujiasen
* @date 2016年11月16日 下午5:11:09  
* @version V1.3
 */

public class WeChatResultMessage {

	/**
	 * 
	* @return  
	* @Description: 订阅事件返回数据  
	* @author lujiasen
	* @date 2016年11月16日 下午5:12:42  
	* @version V1.2
	 */
	public static String getEvent(Map<String,String> map,String paramEWM){
		String  resultXml="";
		TextMessage textMessage = new TextMessage();
		textMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
		textMessage.setFromUserName(map.get("ToUserName"));
		textMessage.setToUserName(map.get("FromUserName"));
		textMessage.setMsgType("text");
		textMessage.setContent("你好!!!");
		resultXml= MessageUtil.textMessageToXml(textMessage);
		return resultXml;
	}
	
	/**
	 * 
	* @return  
	* @Description: 关键词文章  
	* @author lujiasen
	* @date 2016年11月16日 下午5:12:57  
	* @version V1.2
	 */
	public static String getSearchMessage(Map<String,String> map,String paramEWM){
		String  resultXml = "";
		String content = map.get("Content");
		String return_content = "";
		if(content.startsWith("查询")){
			String express_no = content.substring(2);
			return_content = getExpressCompany(express_no);
		}else{
			return_content = "如若查询快递,请输入:查询+单号.如\"查询3804210740406\"";
		}
		TextMessage textMessage = new TextMessage();
		textMessage.setCreateTime(Long.parseLong(map.get("CreateTime")));
		textMessage.setFromUserName(map.get("ToUserName"));
		textMessage.setToUserName(map.get("FromUserName"));
		textMessage.setMsgType("text");
		textMessage.setContent(return_content);
		resultXml= MessageUtil.textMessageToXml(textMessage);
		return resultXml;
		
	}
	//#wechat_redirect
	public static  String getExpressCompany(String express_no){
		String json_string = KdniaoTrackQueryAPI.getExpressCompany(express_no);
		JSONObject json = JSONObject.parseObject(json_string);
		JSONArray list_exprss = json.getJSONArray("Shippers");
		if(list_exprss ==null || list_exprss.size() == 0){
			return "暂无物流信息";
		}else{
			StringBuffer content = new StringBuffer();
			content.append("点击查看详情\n");
			JSONArray list = json.getJSONArray("Shippers");
			list.forEach((Object j) -> {
				JSONObject company = JSONObject.parseObject(j.toString());
				String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx5179c821a45f7352&redirect_uri=http://www.lujiasen.com/wechat/weChat/redirectUrl?param=expressNo="+
						express_no + ",companyCode="+company.get("ShipperCode")+",company="+company.get("ShipperName")
						+"&response_type=code&scope=snsapi_base&state=express_information&connect_redirect=1#wechat_redirect";
				System.out.println(url);
				content.append("<a href='"+url+"'>"+express_no + "\t" + company.get("ShipperName")+"\t"+"</a>\n");
			});
			return content.toString();
		}
	}
}
