package com.phil.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.phil.dbc.DBconnection;
import com.phil.viewmodel.ShowMeal;

public class MealService {
	private DBconnection dbc = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public MealService() {
		try {
			dbc = new DBconnection();
			conn = dbc.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ShowMeal> showMeals() throws Exception {
		List<ShowMeal> meals = new ArrayList<ShowMeal>();
		String sql = "SELECT * FROM `meal` JOIN `head` USING (`hid`);";
		
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
		} finally {
			if (closeConn()) {
				System.out.println("Close connection successfully");
			} else {
				System.out.println("Something went wrong");
			}
		}

		return meals;
	}

	private boolean closeConn() throws Exception {
		if (pstmt != null) {
			try {
				pstmt.close();
				conn.close();
				dbc.close();
				return true;
			} catch (Exception e) {
				throw e;
			}
		} else {
			return false;
		}
	}

}
