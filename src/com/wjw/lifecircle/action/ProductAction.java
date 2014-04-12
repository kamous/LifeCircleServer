package com.wjw.lifecircle.action;

import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.wjw.lifecircle.dao.ProductDAO;
import com.wjw.lifecircle.dao.StoreDAO;
import com.wjw.lifecircle.model.Product;
import com.wjw.lifecircle.util.IOUtil;

public class ProductAction extends ActionSupport {
	private ProductDAO productDAO;
	private StoreDAO storeDAO;
	
	private int productId;
	private int page;
	private double lon;
	private double lat;
	private int userId;
	private int typeId;
	
	private int rows;
	
	private String orderBy;
	private String order;
	
	
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public ProductDAO getProductDAO() {
		return productDAO;
	}
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	public StoreDAO getStoreDAO() {
		return storeDAO;
	}
	public void setStoreDAO(StoreDAO storeDAO) {
		this.storeDAO = storeDAO;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	
	public String showAllProduct()
	{
		
		List list = productDAO.findAll();
		String errorMsg = "";
		String[] excludes={"orders","store","description"};
		
		JSONObject obj = IOUtil.getJsonObject(excludes, "productList", list, errorMsg);
		
		IOUtil.responseJson(obj);
		return NONE;
		
	}
	
	public String showProductsInPage()
	{
		if(rows==0)
			rows=5;//default rows
		
		
		List list = productDAO.findProductsInPage(page, rows,typeId,orderBy,order);//page start with 1
		String errorMsg = "";
		String[] excludes={"orders","store","description"};
		
		JSONObject obj = IOUtil.getJsonObject(excludes, "productList", list, errorMsg);
		
		IOUtil.responseJson(obj);
		return NONE;
		
	}
	

	
	
	public String getProductById()
	{
		
		Product product = productDAO.findById(productId);
		JSONObject obj  = null;

		String errorMsg = "";
		if(product != null)
		{
			String[] excludes={"orders","city","type","products"};
			
			obj = IOUtil.getJsonObject(excludes, "product", product, errorMsg);
		}else
		{
			errorMsg = "查询商品不存在";
			obj= IOUtil.getJsonObject(errorMsg);
		}
		IOUtil.responseJson(obj);
		return NONE;
	}
}
