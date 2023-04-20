package resources;

public enum ResourcesAPI {

	LogintoWebsite("/api/ecom/auth/login"),
	CreateProductAPI("api/ecom/product/add-product"),
	CreateOrderAPI("api/ecom/order/create-order"),
	GetOrderDetails("api/ecom/order/get-orders-details"),
	DeleteOrder("api/ecom/product/delete-product/{id}");
	
	public String resource;

	ResourcesAPI(String resource) {
		this.resource = resource;

	}

	public String getResource() {
		return resource;
	}

}
