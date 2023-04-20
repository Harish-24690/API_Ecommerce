package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.OrderDetails;
import pojo.Orders;
import pojo.UserDetails;

public class TestDataBuild {
	
	
	public UserDetails logintoWebsite() {
		
		UserDetails userDetails = new UserDetails();
		userDetails.setUserEmail("testautomation0691@gmail.com");
        userDetails.setUserPassword("Test@0691");
        return userDetails;
	}
	
	
	
	
	public Orders createOrderPayload(String orderId) {
		
		
		OrderDetails orderDetail = new OrderDetails();
		orderDetail.setCountry("India");
		orderDetail.setProductOrderedId(orderId);
		
		List<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
		orderDetailsList.add(orderDetail);
		
		Orders order = new Orders();
		order.setOrders(orderDetailsList);
		return order;
		
	}
	
	/*
	 * public CreateProduct createProductPayLoad(String userId) { CreateProduct
	 * createProduct = new CreateProduct(); createProduct.setProductName("laptop");
	 * createProduct.setProductAddedBy(userId);
	 * createProduct.setProductCategory("fashion");
	 * createProduct.setProductDescription("Dell");
	 * createProduct.setProductSubCategory("shirts");
	 * createProduct.setProductPrice("1500"); createProduct.setProductFor("All");
	 * return createProduct;
	 * 
	 * 
	 * }
	 */
}
