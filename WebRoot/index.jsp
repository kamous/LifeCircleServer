<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>LifeCircle API</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   	<h4>LifeCircle API</h4> <br>
   	<h3>用户相关</h3>
   	<hr/>
   	登录：userAction!login<br/>
   	<form method="post" action="userAction!login">
   		邮箱：<input type = "text" name = "email"/><br/>
   		密码：<input type = "password" name="password"/><br/>
   		<input type="submit" value="Login"/>
   	</form>
   	
   	<hr/>
   	注册：userAction!regist<br/>
   	<form method="post" action="userAction!regist">
   		用户名：<input type = "text" name = "userName"/><br/>
   		邮箱：<input type = "text" name = "email"/><br/>
   		密码：<input type = "password" name="password"/><br/>
   		<input type="submit" value="Regist"/>
   	</form>
   	
   	<br/>
   	
   	<h3>产品相关</h3>
   	<hr/>
   	<a href="productAction!showAllProduct">查询所有商品：</a>productAction!showAllProduct<br/>
   	
   	
   	<hr/>
   	<a href="productAction!showProductsInPage?page=1&&rows=2&&typeId=0&&orderBy=price&&order=desc">分页查询商品：</a>productAction!showProductsInPage?page=1&&rows=2&&typeId=0&&orderBy=price&&order=desc<br/>
   	<form method="post" action="productAction!showProductsInPage">
   		页数：<input type = "text" name = "page"/ value="1"><br/>
   		每页行数：<input type = "text" name = "rows"/ value="2"><br/>
   		种类：<select name ="typeId">
   			<option value="0">全部</option>
   			<option value="1">美食</option>
   			<option value="2">电影</option>
   			<option value="3">KTV</option>
   			<option value="4">其他</option>
   		</select><br/>
   		排序：<select name="orderBy">
   				<option value="price">价格</option>
   				<option value="id">id</option>
   				<option value="loc">距离</option>
   				<option value="">智能排序</option>
   			</select>
   		顺序：<select name="order">
   			<option value="desc">desc</option>
   			<option value="asc">asc</option>
   		</select>
   		<br/>
   		<input type="submit" value="查询"/>
   	</form>
   	
   	
   	 	<hr/>
   	<a href="productAction!getProductById?productId=1">根据ID查询具体商品：</a>productAction!getProductById?productId=1<br/>
   	<form method="post" action="productAction!getProductById">
   		ID：<input type = "text" name = "productId"/><br/>
   		<input type="submit" value="查询"/>
   	</form>
   	
   	
   	<hr/>
   	<a href="orderAction!buyProduct?userId=1&&productId=2&&count=3">购买商品：</a>orderAction!buyProduct?userId=1&&productId=2&&count=3<br/>
   	<form method="post" action="orderAction!buyProduct">
   		用户ID：<input type = "text" name = "userId" value="1"/><br/>
   		商品ID：<input type = "text" name = "productId" value="2"/><br/>
   		数量：<input type = "text" name="count" value="3"><br/>
   		<input type="submit" value="购买"/>
   	</form>
   	
  </body>
</html>
