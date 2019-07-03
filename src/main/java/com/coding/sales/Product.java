package com.coding.sales;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private String productNo;//编号
	private String productName;//名称
	private String productRule;//单位
	private double price;//单价
	private String discountType;//折扣类型
	private String fullReductionType;//满减类型

	public Product(String productNo, String productName, String productRule,
			double price,String discountType,String fullReductionType) {
		this.productNo = productNo;
		this.productName = productName;
		this.productRule = productRule;
		this.price = price;
		this.discountType = discountType;
		this.fullReductionType = fullReductionType;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductRule() {
		return productRule;
	}
	public void setProductRule(String productRule) {
		this.productRule = productRule;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public String getFullReductionType() {
		return fullReductionType;
	}
	public void setFullReductionType(String fullReductionType) {
		this.fullReductionType = fullReductionType;
	}
	

	final static List<Product> ls = new ArrayList<Product>();
	static {
		Product p1 = new Product("001001", "世园会五十国钱币册", "册", 998.00,null,null);
		Product p2 = new Product("001002", "2019北京世园会纪念银章大全40g", "盒", 1380.00,Constants.NINE_ZERO,null);
		Product p3 = new Product("003001", "招财进宝", "条", 1580.00,Constants.NINE_FIVE,null);
		Product p4 = new Product("003002", "水晶之恋", "条", 980.00,null,Constants.FULL_THREE_REDUCE_ONE);
		Product p5 = new Product("002002", "中国经典钱币套装", "套", 998.00,null,Constants.FULL_TWO_REDUCE_THREE);
		Product p6 = new Product("002001", "守扩之羽比翼双飞4.8g", "条", 1080.00,Constants.NINE_FIVE,Constants.FULL_THREE_REDUCE_ONE);
		Product p7 = new Product("002003", "中国银象棋12g", "套", 698.00,Constants.NINE_ZERO,Constants.FULL_THREE_REDUCE);
		ls.add(p1);
		ls.add(p2);
		ls.add(p3);
		ls.add(p4);
		ls.add(p5);
		ls.add(p6);
		ls.add(p7);
	}
	public static Product getProduct(String productId){
		for(Product product: ls){
			if(product.getProductNo().equals(productId)){
				return product;
			}
		}
		return null;
	}
}
