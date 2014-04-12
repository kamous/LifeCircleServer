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
	 * �¶���������Ʒ
	 * @return 
	 * errorMsg��Ϊ����ʧ��
	 * errorMsgΪ����ɹ�
	 */
	public String buyProduct()
	{
		String errorMsg = "";
		
		try {
			User user = userDAO.findById(userId);
			Product product = productDAO.findById(productId);
			if(user == null)
			{
				errorMsg = "�û���֤ʧ�ܣ������µ�¼";
			}
			else{
				if(product == null)
				{
					errorMsg = "ָ����Ʒ�����ڣ�������ѡ����";
				}else
				{
					Order order = new Order(product,user,count,count*product.getPrice(),new Timestamp(new Date().getTime()));
					orderDAO.save(order);
				}
			
			}
		} catch (Exception e) {
			errorMsg = "�¶���ʧ�ܣ����Ժ����ԣ�";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IOUtil.responseJsonWithErrorMsg(errorMsg);
		
		return "";
	}
	
}
