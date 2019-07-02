package com.coding.sales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	

	public static List dataInit() {
		List<Map<String,Product>> ls = new ArrayList<Map<String,Product>>();
//Product(String productNo, String productName, String productRule,	int price,String discountType,String fullReductionType) 
		Product p1 = new Product("001001", "世园会五十国钱币册", "册", 998.00,null,null);
		Product p2 = new Product("001002", "2019北京世园会纪念银章大全40g", "盒", 1380.00,Constants.NINE_ZERO,null);
		Product p3 = new Product("003001", "招财进宝", "条", 1580.00,Constants.NINE_FIVE,null);
		Product p4 = new Product("003002", "水晶之恋", "条", 980.00,null,Constants.FULL_THREE_REDUCE_ONE);
		Product p5 = new Product("002002", "中国经典钱币套装", "套", 998.00,null,Constants.FULL_TWO_REDUCE_THREE);
		Product p6 = new Product("002001", "守扩之羽比翼双飞4.8g", "条", 1080.00,Constants.NINE_FIVE,Constants.FULL_THREE_REDUCE_ONE);
		Product p7 = new Product("002003", "中国银象棋12g", "套", 698.00,Constants.NINE_ZERO,Constants.FULL_THREE_REDUCE);
		for (int i = 0; i < 7; i++) {
			Map<String,Product> map = new HashMap<String,Product>();
			if (i == 0) {
				map.put("001001", p1);
			} else if (i == 1) {
				map.put("001002", p2);
			}else if(i==2){
				map.put("003001", p3);
			}else if(i==3){
				map.put("003002", p4);
			}else if(i==4){
				map.put("002002", p5);
			}else if(i==5){
				map.put("002001", p6);
			}else if(i==6){
				map.put("002003", p7);
			}
			ls.add(map);
		}
		return ls;
	}
}
