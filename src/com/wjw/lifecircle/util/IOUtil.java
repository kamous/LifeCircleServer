package com.wjw.lifecircle.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

public class IOUtil {
	
	/**
	 * 根据具体对象创建JSONObject
	 * 当errorMsg不为空时，JSONObject仅包含errorMsg
	 * 
	 * @param excludes
	 * @param key
	 * @param value
	 * @param errorMsg
	 * @return
	 */
	public static JSONObject getJsonObject(String[] excludes,String key,Object value,String errorMsg)
	{
		JSONObject obj = new JSONObject();
		JsonConfig config = new JsonConfig();
		try {

			config.setIgnoreDefaultExcludes(false);  //设置默认忽略
			config.setExcludes(excludes);
			obj.element("errorMsg", errorMsg);
			if(errorMsg == null || errorMsg.trim().length() == 0)
				obj.element(key, value,config);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
		
	/**
	 * 返回JSONObject，只包含errorMsg字符串
	 * @param errorMsg
	 * @return
	 */
	public static JSONObject getJsonObject(String errorMsg)
	{
		JSONObject obj = new JSONObject();
		obj.element("errorMsg", errorMsg);
		return obj;
	}
	
	/**
	 * 响应返回Json字符串
	 * 
	 * @param obj
	 */
	public static void responseJson(JSONObject obj)
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
		    out = response.getWriter();
			
		} catch (IOException e) {
			String errorMsg="服务器错误！";
			obj.element("errorMsg",errorMsg);
			
			e.printStackTrace();
		}finally
		{
			out.print(obj.toString());
			out.flush();
			out.close();
		}
	}
	
	/**
	 * 直接返回errorMsg
	 * @param errorMsg
	 */
	public static void responseJsonWithErrorMsg(String errorMsg)
	{
		JSONObject obj = IOUtil.getJsonObject(errorMsg);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
		    out = response.getWriter();
			
		} catch (IOException e) {
			String errorMsgs="服务器错误！";
			obj.element("errorMsg",errorMsgs);
			
			e.printStackTrace();
		}finally
		{
			out.print(obj.toString());
			out.flush();
			out.close();
		}
	}
}
