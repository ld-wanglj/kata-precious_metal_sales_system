package com.coding.sales;

public class PointsRule {

	private final static String	PU_CARD="普卡";
	private final static String	GOLD_CARD="金卡";
	private final static String	WHITE_GOLD_CARD="白金卡";
	private final static String	ZUANSHI_CARD="钻石卡";
	// 计算积分
	public static int computingIntegral(double acountMoney, String level,
			int oldIntegral) {
		int toalIntegral = 0;
		int newIntegral = 0;
		newIntegral = (int) Math.floor(acountMoney);
		if (PU_CARD.equals(level)) {
			toalIntegral = oldIntegral + newIntegral;
		} else if (GOLD_CARD.equals(level)) {
			toalIntegral = (int) Math.floor(oldIntegral + newIntegral * 1.5);
		} else if (WHITE_GOLD_CARD.equals(level)) {
			toalIntegral = (int) Math.floor(oldIntegral + newIntegral * 1.8);
		} else if (ZUANSHI_CARD.equals(level)) {
			toalIntegral = oldIntegral + newIntegral * 2;
		}
		return toalIntegral;
	}

	// 计算等级
	public static String computingLevle(int toalIntegral) {
		String level = PU_CARD;
		if (toalIntegral >= 100000) {
			level = ZUANSHI_CARD;
		} else if (toalIntegral >= 50000) {
			level = WHITE_GOLD_CARD;
		} else if (toalIntegral >= 10000) {
			level = GOLD_CARD;
		}
		return level;
	}
}
