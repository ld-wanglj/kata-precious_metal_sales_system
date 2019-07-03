package com.coding.sales;

import java.util.ArrayList;
import java.util.List;

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

	static List<Member> memberList=new ArrayList<Member>();
	static {
		Member m1 = new Member("6236609999", "马丁", "普卡", 9860);
		Member m2 = new Member("6630009999", "王立", "金卡", 48860);
		Member m3 = new Member("8230009999", "李想", "白金卡", 98860);
		Member m4 = new Member("9230009999", "张三", "钻石卡", 198860);
		memberList.add(m1);
		memberList.add(m2);
		memberList.add(m3);
		memberList.add(m4);
	}
	
	public static Member getMember(String memberId){
		for(Member member:memberList){
			if(member.getMemberId().equals(memberId)){
				return member;
			}
		}
		return null;
	}
	public Member(){
	}
}
