package com.shoppingcartlist.model;

import java.util.*;

public interface ShoppingcartlistDAO_interface {
	      public void insert(ShoppingcartlistVO shoppingcartlistVO);
	      public void update(ShoppingcartlistVO shoppingcartlistVO);
	      public void delete(Integer shoppingcartlisto);
	      public ShoppingcartlistVO findByPrimaryKey(Integer shoppingcartlistno);
	      public List<ShoppingcartlistVO> getAll();
	    //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  	  public List<EmpVO> getAll(Map<String, String[]> map); 
}