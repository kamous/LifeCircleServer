package com.wjw.lifecircle.action;

import java.sql.Timestamp;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.wjw.lifecircle.dao.OrderDAO;
import com.wjw.lifecircle.dao.ProductDAO;
import com.wjw.lifecircle.dao.UserDAO;
import com.wjw.lifecircle.model.Order;
import com.wjw.lifecircle.model.Product;
import com.wjw.lifecircle.model.User;
import com.wjw.lifecircle.util.IOUtil;

public class OrderAction extends ActionSupport {
	
	private int userId;
	private int productId;
	private int count;
	private UserDAO userDAO;
	private ProductDAO productDAO;
	private OrderDAO orderDAO;
	
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public ProductDAO getProductDAO() {
		return productDAO;
	}
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	public OrderDAO getOrderDAO() {
		return orderDAO;
	}
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	
	/**
	 * 下订单购买商品
	 * @return 
	 * errorMsg不为空则失败
	 * errorMsg为空则成功
	 */
	public String buyProduct()
	{
		String errorMsg = "";
		
		try {
			User user = userDAO.findById(userId);
			Product product = productDAO.findById(productId);
			if(user == null)
			{
				errorMsg = "用户验证失败，请重新登录";
			}
			else{
				if(product == null)
				{
					errorMsg = "指定商品不存在，请重新选择购买";
				}else
				{
					Order order = new Order(product,user,count,count*product.getPrice(),new Timestamp(new Date().getTime()));
					orderDAO.save(order);
				}
			
			}
		} catch (Exception e) {
			errorMsg = "下订单失败，请稍后再试！";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IOUtil.responseJsonWithErrorMsg(errorMsg);
		
		return "";
	}
	
}
