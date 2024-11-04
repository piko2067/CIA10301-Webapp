package com.shoppingcartlist.model;

import java.util.List;

public class ShoppingcartlistService {

	private ShoppingcartlistDAO_interface dao;
	
	public ShoppingcartlistService() {
		dao = new ShoppingcartlistJDBCDAO();
	}
	
	public ShoppingcartlistVO addShoppingcartlist(Integer memNo,Integer goodsNo,Integer goodsNum,
			Integer goodsPrice,String goodsName,Integer orderTotalprice) {
		
		ShoppingcartlistVO shoppingcartlistVO = new ShoppingcartlistVO();
		
		shoppingcartlistVO.setMemNo(memNo);
		shoppingcartlistVO.setGoodsNo(goodsNo);
		shoppingcartlistVO.setGoodsNum(goodsNum);
		shoppingcartlistVO.setGoodsPrice(goodsPrice);
		shoppingcartlistVO.setGoodsName(goodsName);
		shoppingcartlistVO.setOrderTotalprice(orderTotalprice);
		dao.insert(shoppingcartlistVO);
		
		return shoppingcartlistVO;
	}
	
	public ShoppingcartlistVO updateShoppingcartlist(Integer shoppingcartListNo,Integer memNo,Integer goodsNo,Integer goodsNum,
			Integer goodsPrice,String goodsName,Integer orderTotalprice) {
		
		ShoppingcartlistVO shoppingcartlistVO = new ShoppingcartlistVO();

		shoppingcartlistVO.setShoppingcartListNo(shoppingcartListNo);
		shoppingcartlistVO.setMemNo(memNo);
		shoppingcartlistVO.setGoodsNo(goodsNo);
		shoppingcartlistVO.setGoodsNum(goodsNum);
		shoppingcartlistVO.setGoodsPrice(goodsPrice);
		shoppingcartlistVO.setGoodsName(goodsName);
		shoppingcartlistVO.setOrderTotalprice(orderTotalprice);
		dao.update(shoppingcartlistVO);

		return shoppingcartlistVO;
	}
	
	public void deleteShoppingcartlist(Integer shoppingcartListNo) {
		dao.delete(shoppingcartListNo);
	}
	
	public ShoppingcartlistVO getOneShoppingcartlist(Integer shoppingcartListNo) {
		return dao.findByPrimaryKey(shoppingcartListNo);
	}
	
	public List<ShoppingcartlistVO> getAll() {
		return dao.getAll();
	}
}
