package com.coding.sales;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ProductCommandTest {

	@Test
	public void should_parse_product_init() {
		List<Map<String, Product>> productList=Product.dataInit();
		assertEquals("世园会五十国钱币册", ((Product)((Map)productList.get(0)).get("001001")).getProductName());
		assertEquals(null, ((Product)((Map)productList.get(0)).get("001001")).getDiscountType());
		//assertTrue(998.00.((Product)((Map)productList.get(0)).get("001001")).getPrice());
		assertEquals(null, ((Product)((Map)productList.get(0)).get("001001")).getFullReductionType());
		assertEquals("册", ((Product)((Map)productList.get(0)).get("001001")).getProductRule());
		assertTrue(((Product)((Map)productList.get(0)).get("001001")).getPrice()==998.00);
	}

}
