package com.coding.sales;


public class CalAmountSum {
	
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
	//每满3000元减350, 每满2000减30，每满1000减10优惠金额
	public static double calDiscountmoney12(double amountMoney){
		double lessAmountMoney=amountMoney;
		int i=0;
		int j=0;
		int k=0;
		if(lessAmountMoney>=3000){
			lessAmountMoney=lessAcountMoney(amountMoney,3000,350);
			i=calDiscountCount(amountMoney,3000,350);
		}
		if(lessAmountMoney>=2000){
			amountMoney=lessAcountMoney(amountMoney,2000,50);
			j=calDiscountCount(amountMoney,2000,50);
		}
		if(lessAmountMoney>=1000){
			amountMoney=lessAcountMoney(amountMoney,1000,10);
			k=calDiscountCount(amountMoney,1000,10);
		}
		return 350*i+50*j+10*k;
	}	
	//每满2000减30，每满1000减10优惠金额
	public static double calDiscountmoney13(double amountMoney){
		double lessAmountMoney=amountMoney;
		int j=0;
		int k=0;
		if(lessAmountMoney>=2000){
			j=calDiscountCount(amountMoney,2000,50);
			lessAmountMoney=lessAcountMoney(lessAmountMoney,2000,50);
			
		}
		System.out.println(lessAmountMoney);
		if(lessAmountMoney>=1000){
			k=calDiscountCount(lessAmountMoney,1000,10);
			lessAmountMoney=lessAcountMoney(lessAmountMoney,1000,10);
			
		}
		System.out.println(j+"**"+k+"**"+(50*j+10*k));
		return 50*j+10*k;
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
