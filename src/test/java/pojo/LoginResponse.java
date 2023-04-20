package pojo;

import java.util.List;

public class LoginResponse {
	
	public static String token;
	public static String userId;
	public String message;
	public static String productId;
	public List orders;
	public List productOrderId;
	public DetailsOfOrder data;
	
	
	
	public List getOrders() {
		return orders;
	}
	public void setOrders(List orders) {
		this.orders = orders;
	}
	public List getProductOrderId() {
		return productOrderId;
	}
	public void setProductOrderId(List productOrderId) {
		this.productOrderId = productOrderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	 

}
