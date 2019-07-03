package com.coding.sales;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.input.PaymentCommand;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;
import com.coding.sales.output.PaymentRepresentation;

/**
 * 销售系统的主入口 用于打印销售凭证
 */
public class OrderApp {

	public static void main(String[] args) {
		if (args.length != 2) {
			throw new IllegalArgumentException(
					"参数不正确。参数1为销售订单的JSON文件名，参数2为待打印销售凭证的文本文件名.");
		}

		String jsonFileName = args[0];
		String txtFileName = args[1];

		String orderCommand = FileUtils.readFromFile(jsonFileName);
		OrderApp app = new OrderApp();
		String result = app.checkout(orderCommand);
		FileUtils.writeToFile(result, txtFileName);
	}

	public String checkout(String orderCommand) {
		OrderCommand command = OrderCommand.from(orderCommand);
		OrderRepresentation result = checkout(command);

		return result.toString();
	}

	OrderRepresentation checkout(OrderCommand command) {
		OrderRepresentation result = null;
		try {
			result = this.getOrderRepresentation(command);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO: 请完成需求指定的功能

		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public OrderRepresentation getOrderRepresentation(OrderCommand command)
			throws ParseException {
//		String orderId = command.getOrderId();
		List orderProducts = command.getItems();// 购买的产品列表
		List discounts = command.getDiscounts();// 存在的优惠券列表
		List pList = command.getPayments();
		String memberId = command.getMemberId();
		Member member = Member.getMember(memberId);
		String oldMemberType = member.getMemberType();
		List itemsList = new ArrayList();
		List printDiscounts = new ArrayList();
		List paymentList = new ArrayList();
		List discountList = new ArrayList();
		double totalAmt = 0.00;// 总金额
		double discountAmt = 0.00;// 优惠金额
		double endAmt = 0.00;// 实际支付金额
		for (int i = 0; i < orderProducts.size(); i++) {
			OrderItemCommand orderItem = (OrderItemCommand) orderProducts
					.get(i);
			String productId = orderItem.getProduct();
			BigDecimal amt = orderItem.getAmount();
			double amtDou = amt.doubleValue();
			Product product = Product.getProduct(productId);
			double discountAmt1 = 0.00;
			double discountAmt2 = 0.00;
			double price = product.getPrice();// 产品单价
			String discountType = product.getDiscountType();// 打折
			String fullReductionType = product.getFullReductionType();// 满减
			totalAmt = totalAmt + amtDou * price;// 总金额
			double productTotalAmt = amtDou * price;// 单个商品总金额
			// 存在优惠券计算优惠金额，根据优惠金额计算实际支付金额,且当前商品有优惠规则时计算优惠金额
			if (discounts.size() > 0
					&& (discountType != null || fullReductionType != null)) {
				for (int k = 0; k < discounts.size(); k++) {
					String discount = (String) discounts.get(k);
					// 存在优惠券且商品存在打折优惠规则，计算优惠金额
					if (Constants.NINE_ZERO.equals(discount)
							&& Constants.NINE_ZERO.equals(product
									.getDiscountType())) {
						discountAmt1 += CalAmountSum.calDiscountSum(
								productTotalAmt, Constants.NINE_ZERO);
					} else if (Constants.NINE_FIVE.equals(discount)
							&& Constants.NINE_FIVE.equals(product
									.getDiscountType())) {
						discountAmt1 += CalAmountSum.calDiscountSum(
								productTotalAmt, Constants.NINE_FIVE);
					}
					// 存在满减券，且商品存在满减优惠规则，计算优惠金额
					if (Constants.FULL_THREE_REDUCE.equals(product
							.getFullReductionType())) {
						discountAmt2 += CalAmountSum
								.calDiscountmoney12(productTotalAmt);
					} else if (Constants.FULL_THREE_REDUCE_ONE.equals(product
							.getFullReductionType())) {
						discountAmt2 += CalAmountSum
								.discount_FULL_THREE_REDUCE_ONE(amtDou, price);
					} else if (Constants.FULL_TWO_REDUCE_THREE.equals(product
							.getFullReductionType())) {
						discountAmt2 += CalAmountSum
								.calDiscountmoney13(productTotalAmt);
					}
					if (discountAmt1 > discountAmt2) {
						DiscountItemRepresentation discountItemRepresentation = new DiscountItemRepresentation(
								product.getProductNo(),
								product.getProductName(), new BigDecimal(
										discountAmt1));
						printDiscounts.add(discountItemRepresentation);
					} else if (discountAmt1 < discountAmt2) {
						DiscountItemRepresentation discountItemRepresentation = new DiscountItemRepresentation(
								product.getProductNo(),
								product.getProductName(), new BigDecimal(
										discountAmt2));
						printDiscounts.add(discountItemRepresentation);
					}
				}

				// 计算本商品的最终优惠金额
				if (discountAmt1 > discountAmt2) {
					discountAmt += discountAmt1;
				} else if (discountAmt1 < discountAmt2) {
					discountAmt += discountAmt2;
				}
			}
			OrderItemRepresentation orderItemRepresentation = new OrderItemRepresentation(
					product.getProductNo(), product.getProductName(),
					new BigDecimal(price), new BigDecimal(amtDou),
					new BigDecimal(productTotalAmt));
			itemsList.add(orderItemRepresentation);
		}
		for (int m = 0; m < pList.size(); m++) {
			PaymentCommand paymentCommand = (PaymentCommand) pList.get(m);
			PaymentRepresentation paymentRepresentation = new PaymentRepresentation(
					paymentCommand.getType(), paymentCommand.getAmount());
			paymentList.add(paymentRepresentation);
		}
		for (int i = 0; i < discounts.size(); i++) {
			String discount = (String) discounts.get(i);
			discountList.add(discount);
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		endAmt = totalAmt - discountAmt;
		int points = member.getMemberPoints();
		member.setMemberPoints(PointsRule.computingIntegral(endAmt,
				member.getMemberType(), points));
		member.setMemberType(PointsRule.computingLevle(member.getMemberPoints()));
		return new OrderRepresentation(command.getOrderId(),
				formatter.parse(command.getCreateTime()),
				command.getMemberId(), member.getMemberName(), oldMemberType,
				member.getMemberType(), points, member.getMemberPoints(),
				itemsList, new BigDecimal(totalAmt), printDiscounts,
				new BigDecimal(discountAmt), new BigDecimal(endAmt),
				paymentList, discountList);

	}

	
}
