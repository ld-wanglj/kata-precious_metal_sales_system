package com.coding.sales;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductCommandTest {

	@Test
	public void should_parse_product(){
//		Product.dataInit();
		assertEquals("世园会五十国钱币册", Product.getProduct("001001").getProductName());
	}
}
