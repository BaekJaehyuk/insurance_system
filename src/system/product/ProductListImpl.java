package src.system.product;


import java.util.ArrayList;

public class ProductListImpl implements ProductList {
	private ArrayList<Product> productList;

	public ProductListImpl() {
		productList = new ArrayList<>();
	}

	@Override
	public void add(Product product) {
		productList.add(product);
	}

	@Override
	public void delete(Product product) {
		productList.remove(product);
	}

	@Override
	public Product get(String name) {
		for (Product product : productList) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		return null;
	}



	@Override
	public void update(Product product) {
		int index = productList.indexOf(product);
		if (index >= 0) {
			productList.set(index, product);
		}
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}
}
