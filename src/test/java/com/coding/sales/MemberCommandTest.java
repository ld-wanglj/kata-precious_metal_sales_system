package com.coding.sales;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MemberCommandTest {

	@Test
	public void should_memneri_member(){
		assertEquals(9860, Member.getMember("6236609999").getMemberPoints());
	}
}
