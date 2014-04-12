package com.wjw.lifecircle.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;

public class IOUtil {
	
	/**
	 * ���ݾ�����󴴽�JSONObject
	 * ��errorMsg��Ϊ��ʱ��JSONObject������errorMsg
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

			config.setIgnoreDefaultExcludes(false);  //����Ĭ�Ϻ���
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
	 * ����JSONObject��ֻ����errorMsg�ַ���
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
	 * ��Ӧ����Json�ַ���
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
			String errorMsg="����������";
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
	 * ֱ�ӷ���errorMsg
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
			String errorMsgs="����������";
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
