package com.phil.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.phil.model.Meal;
import com.phil.viewmodel.ShowMeal;

public class MealService {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public MealService(Connection conn) {
		this.conn = conn;
	}

	public List<ShowMeal> showMeals() throws Exception {
		List<ShowMeal> meals = new ArrayList<ShowMeal>();
		String sql = "SELECT * FROM `meal` JOIN `head` USING (`hid`) ORDER BY `hid`;";
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ShowMeal showMeal = new ShowMeal();
				showMeal.setMid(rs.getInt("mid"));
				showMeal.setHid(rs.getInt("hid"));
				showMeal.setHead(rs.getString("item"));
				showMeal.setMeal(rs.getString("meal"));
				showMeal.setPrice(rs.getInt("price"));
				showMeal.setDiscount(rs.getFloat("discount"));
				showMeal.setActive(rs.getInt("active"));
				meals.add(showMeal);
			}

		} catch (Exception e) {
			throw e;
		}

		return meals;
	}
	
	public boolean insertMeal(Meal meal) throws Exception {
		boolean bool = false;
		String sql = "INSERT INTO `meal` (`hid`, `meal`, `price`, `createtime`) VALUES(?, ?, ?, ?);";
		
		try {
			Date now = new Date();
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, meal.getHid());
			pstmt.setString(2, meal.getMeal());
			pstmt.setInt(3, meal.getPrice());
			pstmt.setString(4, sdFormat.format(now));
			
			if (pstmt.executeUpdate() > 0) {
				bool = true;
				System.out.println("Insert meal successfully");
			} else {
				System.out.println("Insert meal unsuccessfully");
			}
			
		} catch (Exception e) {
			throw e;
		}
		
		return bool;
	}

	public boolean deleteMeal(Meal meal) throws Exception {
		boolean bool = false;
		String sql = "DELETE FROM `meal` WHERE `mid` = ?;";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, meal.getMid());
			
			if (pstmt.executeUpdate() > 0) {
				bool = true;
				System.out.println("Delete meal successfully");
			} else {
				System.out.println("Delete meal unsuccessfully");
			}
			
		} catch (Exception e) {
			throw e;
		}
		
		return bool;
	}

	public void closeConn() throws Exception {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
			System.out.println("Close connection successfully");
		} catch (Exception e) {
			System.out.println("Something went wrong when closing connection");
			throw e;
		}
	}

}
