package com.shoppingcartlist.model;
import java.sql.Date;

public class ShoppingcartlistVO implements java.io.Serializable{
	private Integer shoppingcartListNo;
	private Integer memNo;
	private Integer goodsNo;
	private Integer goodsNum;
	private Integer goodsPrice;
	private String goodsName;
	private Integer orderTotalprice;
	
	public Integer getShoppingcartListNo() {
		return shoppingcartListNo;
	}
	public void setShoppingcartListNo(Integer shoppingcartListNo) {
		this.shoppingcartListNo = shoppingcartListNo;
	}
	public Integer getMemNo() {
		return memNo;
	}
	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public Integer getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(Integer goodsNo) {
		this.goodsNo = goodsNo;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Integer getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Integer goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getOrderTotalprice() {
		return orderTotalprice;
	}
	public void setOrderTotalprice(Integer orderTotalprice) {
		this.orderTotalprice = orderTotalprice;
	}
}
