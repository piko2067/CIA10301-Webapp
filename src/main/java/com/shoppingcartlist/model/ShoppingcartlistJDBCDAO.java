package com.shoppingcartlist.model;

import java.util.*;

import com.emp.model.EmpJDBCDAO;
import com.emp.model.EmpVO;

import java.sql.*;

public class ShoppingcartlistJDBCDAO implements ShoppingcartlistDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";

	private static final String INSERT_STMT = 
		"INSERT INTO shoppingcartlist (memNo,goodsNo,goodsNum,goodsPrice,goodsName,orderTotalprice) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT shoppingcartListNo,memNo,goodsNo,goodsNum,goodsPrice,goodsName,orderTotalprice FROM shoppingcartlist order by shoppingcartListNo";
	private static final String GET_ONE_STMT = 
		"SELECT shoppingcartListNo,memNo,goodsNo,goodsNum,goodsPrice,goodsName,orderTotalprice FROM shoppingcartlist where shoppingcartListNo = ?";
	private static final String DELETE = 
		"DELETE FROM shoppingcartlist where shoppingcartListNo = ?";
	private static final String UPDATE = 
		"UPDATE shoppingcartlist set memNo=?,goodsNo=?,goodsNum=?,goodsPrice=?,goodsName=?,orderTotalprice=?  where shoppingcartListNo = ?";

	@Override
	public void insert(ShoppingcartlistVO shoppingcartlistVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, shoppingcartlistVO.getMemNo());
			pstmt.setInt(2, shoppingcartlistVO.getGoodsNo());
			pstmt.setInt(3, shoppingcartlistVO.getGoodsNum());
			pstmt.setInt(4, shoppingcartlistVO.getGoodsPrice());
			pstmt.setString(5, shoppingcartlistVO.getGoodsName());
			pstmt.setInt(6, shoppingcartlistVO.getOrderTotalprice());
			
			pstmt.executeUpdate();
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " 
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " 
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	@Override
	public void update(ShoppingcartlistVO shoppingcartlistVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, shoppingcartlistVO.getMemNo());
			pstmt.setInt(2, shoppingcartlistVO.getGoodsNo());
			pstmt.setInt(3, shoppingcartlistVO.getGoodsNum());
			pstmt.setInt(4, shoppingcartlistVO.getGoodsPrice());
			pstmt.setString(5, shoppingcartlistVO.getGoodsName());
			pstmt.setInt(6, shoppingcartlistVO.getOrderTotalprice());
			pstmt.setInt(7, shoppingcartlistVO.getShoppingcartListNo());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	@Override
	public void delete(Integer shoppingcartListNo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1,shoppingcartListNo);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	@Override
	public ShoppingcartlistVO findByPrimaryKey(Integer shoppingcartListNo) {
		
		ShoppingcartlistVO shoppingcartlistVO= null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, shoppingcartListNo);
		
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// empVo 也稱為 Domain objects
				shoppingcartlistVO = new ShoppingcartlistVO();
				shoppingcartlistVO.setShoppingcartListNo(rs.getInt("shoppingcartListNo"));
				shoppingcartlistVO.setMemNo(rs.getInt("memNo"));
				shoppingcartlistVO.setGoodsNo(rs.getInt("goodsNo"));
				shoppingcartlistVO.setGoodsNum(rs.getInt("goodsNum"));
				shoppingcartlistVO.setGoodsPrice(rs.getInt("goodsPrice"));
				shoppingcartlistVO.setGoodsName(rs.getString("goodsName"));
				shoppingcartlistVO.setOrderTotalprice(rs.getInt("orderTotalprice"));
			}
			// Handle any driver errors
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return shoppingcartlistVO;
	}
	@Override
	public List<ShoppingcartlistVO> getAll() {
		List<ShoppingcartlistVO> list = new ArrayList<ShoppingcartlistVO>();
		ShoppingcartlistVO shoppingcartlistVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				shoppingcartlistVO = new ShoppingcartlistVO();
				shoppingcartlistVO.setShoppingcartListNo(rs.getInt("shoppingcartListNo"));
				shoppingcartlistVO.setMemNo(rs.getInt("memNo"));
				shoppingcartlistVO.setGoodsNo(rs.getInt("goodsNo"));
				shoppingcartlistVO.setGoodsNum(rs.getInt("goodsNum"));
				shoppingcartlistVO.setGoodsPrice(rs.getInt("goodsPrice"));
				shoppingcartlistVO.setGoodsName(rs.getString("goodsName"));
				shoppingcartlistVO.setOrderTotalprice(rs.getInt("orderTotalprice"));
				list.add(shoppingcartlistVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {

		ShoppingcartlistJDBCDAO dao = new ShoppingcartlistJDBCDAO();

		// 新增
//		ShoppingcartlistVO shoppingcartlistVO1 = new ShoppingcartlistVO();
//		shoppingcartlistVO1.setMemNo(11);
//		shoppingcartlistVO1.setGoodsNo(11);
//		shoppingcartlistVO1.setGoodsNum(1);
//		shoppingcartlistVO1.setGoodsPrice(500);
//		shoppingcartlistVO1.setGoodsName("Product K");
//		shoppingcartlistVO1.setOrderTotalprice(500);
//		dao.insert(shoppingcartlistVO1);

		// 修改
//		ShoppingcartlistVO shoppingcartlistVO2 = new ShoppingcartlistVO();
//		shoppingcartlistVO2.setShoppingcartListNo(11);
//		shoppingcartlistVO2.setMemNo(11);
//		shoppingcartlistVO2.setGoodsNo(11);
//		shoppingcartlistVO2.setGoodsNum(1);
//		shoppingcartlistVO2.setGoodsPrice(700);
//		shoppingcartlistVO2.setGoodsName("Product K");
//		shoppingcartlistVO2.setOrderTotalprice(700);
//		dao.update(shoppingcartlistVO2);
		
//		// 刪除
		dao.delete(11);

//		// 查詢
//		ShoppingcartlistVO shoppingcartlistVO3 = dao.findByPrimaryKey(1);
//		System.out.print(shoppingcartlistVO3.getShoppingcartListNo() + ",");
//		System.out.print(shoppingcartlistVO3.getMemNo() + ",");
//		System.out.print(shoppingcartlistVO3.getGoodsNo() + ",");
//		System.out.print(shoppingcartlistVO3.getGoodsNum() + ",");
//		System.out.print(shoppingcartlistVO3.getGoodsPrice() + ",");
//		System.out.print(shoppingcartlistVO3.getGoodsName() + ",");
//		System.out.println(shoppingcartlistVO3.getOrderTotalprice());
//		System.out.println("---------------------");

//		// 查詢
//		List<ShoppingcartlistVO> list = dao.getAll();
//		for (ShoppingcartlistVO Shoppingcartlist : list) {
//			System.out.print(Shoppingcartlist.getShoppingcartListNo() + ",");
//			System.out.print(Shoppingcartlist.getMemNo() + ",");
//			System.out.print(Shoppingcartlist.getGoodsNo() + ",");
//			System.out.print(Shoppingcartlist.getGoodsNum() + ",");
//			System.out.print(Shoppingcartlist.getGoodsPrice() + ",");
//			System.out.print(Shoppingcartlist.getGoodsName() + ",");
//			System.out.print(Shoppingcartlist.getOrderTotalprice());
//			System.out.println();
//		}
	}
}
