package src.system.product;



public interface ProductList {
	void add(Product product);

	void delete(Product product);

	Product get(String name);

	void update(Product product);
}