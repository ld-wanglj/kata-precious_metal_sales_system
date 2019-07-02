package com.coding.sales;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.coding.sales.Member;

public class MemberCommandTest {

	@SuppressWarnings("rawtypes")
	@Test
	public void should_parse_member_init() {

		List<Map<String, Member>> memberList=Member.dataInit();
		assertEquals("马丁", ((Member)((Map)memberList.get(0)).get("6236609999")).getMemberName());
		assertEquals("普卡", ((Member)((Map)memberList.get(0)).get("6236609999")).getMemberType());
		assertEquals(9860, ((Member)((Map)memberList.get(0)).get("6236609999")).getMemberPoints());
		assertEquals("王立", ((Member)((Map)memberList.get(1)).get("6630009999")).getMemberName());
		assertEquals("金卡", ((Member)((Map)memberList.get(1)).get("6630009999")).getMemberType());
		assertEquals(48860, ((Member)((Map)memberList.get(1)).get("6630009999")).getMemberPoints());
		assertEquals("李想", ((Member)((Map)memberList.get(2)).get("8230009999")).getMemberName());
		assertEquals("白金卡", ((Member)((Map)memberList.get(2)).get("8230009999")).getMemberType());
		assertEquals(98860, ((Member)((Map)memberList.get(2)).get("8230009999")).getMemberPoints());
		assertEquals("张三", ((Member)((Map)memberList.get(3)).get("9230009999")).getMemberName());
		assertEquals("钻石卡", ((Member)((Map)memberList.get(3)).get("9230009999")).getMemberType());
		assertEquals(198860, ((Member)((Map)memberList.get(3)).get("9230009999")).getMemberPoints());
	}

}
