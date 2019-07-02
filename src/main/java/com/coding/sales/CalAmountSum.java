package com.coding.sales;


public class CalAmountSum {
	public static final double BASE_MONEY_MAX =3000;
	 public static final double BASE_MONEY_MIDDLE =2000;
	 public static final double BASE_MONEY_MIN =1000;
	 public static final double DISACOUNT_MAX =350;
	 public static final double DISACOUNT_MIDDLE =50;
	 public static final double DISACOUNT_MIN =10;
	//优惠笔数
	public static int calDiscountCount(double amountMoney,double discountBase,double discount){
		int i;
		int j;
		for(i=0,j=1;amountMoney-discountBase*j>=0;i++,j++){
			amountMoney=amountMoney-discount;
		}
		return i;
	}
	//优惠后剩余计算金额
	public static double lessAcountMoney(double amountMoney,double discountBase,double discount){
		double amountMoneyLess=0.00;
		int i;
		int j;
		for(i=0,j=1;amountMoney-discountBase*j>=0;i++,j++){
			amountMoney=amountMoney-discount;
			amountMoneyLess=amountMoney-discountBase*j;
		}
		return amountMoneyLess;
	}
	//每满BASE_MONEY_MAX元减DISACOUNT_MAX, 每满BASE_MONEY_MIDDLE减30，每满BASE_MONEY_MIN减DISACOUNT_MIN优惠金额
	public static double calDiscountmoney12(double amountMoney){
		double lessAmountMoney=amountMoney;
		int i=0;
		int j=0;
		int k=0;
		if(lessAmountMoney>=BASE_MONEY_MAX){
			lessAmountMoney=lessAcountMoney(amountMoney,BASE_MONEY_MAX,DISACOUNT_MAX);
			i=calDiscountCount(amountMoney,BASE_MONEY_MAX,DISACOUNT_MAX);
		}
		if(lessAmountMoney>=BASE_MONEY_MIDDLE){
			amountMoney=lessAcountMoney(amountMoney,BASE_MONEY_MIDDLE,DISACOUNT_MIDDLE);
			j=calDiscountCount(amountMoney,BASE_MONEY_MIDDLE,DISACOUNT_MIDDLE);
		}
		if(lessAmountMoney>=BASE_MONEY_MIN){
			amountMoney=lessAcountMoney(amountMoney,BASE_MONEY_MIN,DISACOUNT_MIN);
			k=calDiscountCount(amountMoney,BASE_MONEY_MIN,DISACOUNT_MIN);
		}
		return DISACOUNT_MAX*i+DISACOUNT_MIDDLE*j+DISACOUNT_MIN*k;
	}	
	//每满BASE_MONEY_MIDDLE减30，每满BASE_MONEY_MIN减DISACOUNT_MIN优惠金额
	public static double calDiscountmoney13(double amountMoney){
		double lessAmountMoney=amountMoney;
		int j=0;
		int k=0;
		if(lessAmountMoney>=BASE_MONEY_MIDDLE){
			j=calDiscountCount(amountMoney,BASE_MONEY_MIDDLE,DISACOUNT_MIDDLE);
			lessAmountMoney=lessAcountMoney(lessAmountMoney,BASE_MONEY_MIDDLE,DISACOUNT_MIDDLE);
			
		}
		System.out.println(lessAmountMoney);
		if(lessAmountMoney>=BASE_MONEY_MIN){
			k=calDiscountCount(lessAmountMoney,BASE_MONEY_MIN,DISACOUNT_MIN);
			lessAmountMoney=lessAcountMoney(lessAmountMoney,BASE_MONEY_MIN,DISACOUNT_MIN);
			
		}
		System.out.println(j+"**"+k+"**"+(DISACOUNT_MIDDLE*j+DISACOUNT_MIN*k));
		return DISACOUNT_MIDDLE*j+DISACOUNT_MIN*k;
	}
	
	//打折优惠金额
	public static double calDiscountSum(double amountMoney,String discountType){
		double discountMoney=amountMoney;
		if(Constants.NINE_ZERO.equals(discountType)){
			discountMoney=amountMoney*0.1;
		}else if(Constants.NINE_FIVE.equals(discountType)){
			discountMoney=amountMoney*0.05;
		}
		return discountMoney;
	}
	//第3件半价，满3送1优惠金额
	public static double discount_FULL_THREE_REDUCE_ONE(double count,double price){
		double discountMoney=0.00;
		if(count>=4){
			discountMoney=price;
		}else if(count==3){
			discountMoney=price*0.5;
		}else{
			discountMoney=0.00;
		}
		
		return discountMoney;
	}
}
