package com.coding.sales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Member {

	private String memberId;
	private String memberName;
	private String memberType;
	private int memberPoints;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public int getMemberPoints() {
		return memberPoints;
	}

	public void setMemberPoints(int memberPoints) {
		this.memberPoints = memberPoints;
	}

	public Member(String memberId, String memberName, String memberType,
			int memberPoints) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberType = memberType;
		this.memberPoints = memberPoints;
	}

	public static List dataInit() {
		List<Map<String,Member>> ls = new ArrayList<Map<String,Member>>();

		Member m1 = new Member("6236609999", "马丁", "普卡", 9860);
		Member m2 = new Member("6630009999", "王立", "金卡", 48860);
		Member m3 = new Member("8230009999", "李想", "白金卡", 98860);
		Member m4 = new Member("9230009999", "张三", "钻石卡", 198860);
		for (int i = 0; i < 4; i++) {
			Map<String,Member> map = new HashMap<String,Member>();
			if (i == 0) {
				map.put("6236609999", m1);
			} else if (i == 1) {
				map.put("6630009999", m2);
			}else if(i==2){
				map.put("8230009999", m3);
			}else if(i==3){
				map.put("9230009999", m4);
			}
			ls.add(map);
		}
		return ls;
	}
}
