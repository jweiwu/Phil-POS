package com.phil.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.phil.model.CustomList;
import com.phil.model.Order;
import com.phil.model.OrderList;
import com.phil.viewmodel.OverallInfo;
import com.phil.viewmodel.ShowOrderList;
import com.phil.viewmodel.ViewMeal;
import com.phil.viewmodel.ViewOrder;

public class OrderService {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public OrderService(Connection conn) {
		this.conn = conn;
	}

	public boolean insertOrder(ViewOrder viewOrder) throws Exception {
		boolean bool = false;
		Order order = viewOrder.getOrder();
		List<OrderList> orderList = viewOrder.getOrderList();
		List<CustomList> customList = viewOrder.getCustomList();

		String sql = "INSERT INTO `order` (`discount`, `total`, `createtime`) VALUES(?, ?, ?);";

		try {
			Date now = new Date();
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getDiscount());
			pstmt.setInt(2, order.getTotal());
			pstmt.setString(3, sdFormat.format(now));

			if (pstmt.executeUpdate() > 0) {
				System.out.println("Insert order successfully");

				if (orderList.size() > 0) {
					sql = "SELECT `oid` FROM `order` ORDER BY `oid` DESC LIMIT 1;";
					pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					rs.next();
					order.setOid(rs.getLong("oid"));

					sql = "INSERT INTO `orderlist` (`oid`, `mid`, `quantity`) VALUES (?, ?, ?);";
					pstmt = conn.prepareStatement(sql);
					sql = "INSERT INTO `customlist` (`oid`, `mid`, `cid`) VALUES (?, ?, ?);";
					PreparedStatement pstmt2 = conn.prepareStatement(sql);
					conn.setAutoCommit(false);

					for (int i = 0; i < orderList.size(); i++) {
						if (orderList.get(i) != null && orderList.get(i).getMid() != 0) {
							pstmt.setLong(1, order.getOid());
							pstmt.setInt(2, orderList.get(i).getMid());
							pstmt.setInt(3, orderList.get(i).getQuantity());

							pstmt.addBatch();
						}
					}

					if (customList != null) {
						for (int i = 0; i < customList.size(); i++) {
							if (customList.get(i) != null && customList.get(i).getCid() != 0) {
								pstmt2.setLong(1, order.getOid());
								pstmt2.setInt(2, customList.get(i).getMid());
								pstmt2.setInt(3, customList.get(i).getCid());
								pstmt2.addBatch();
							}
						}
					}

					int[] updateCount = pstmt.executeBatch();
					int[] updateCount2 = pstmt2.executeBatch();

					if (Arrays.binarySearch(updateCount, 0) == -1 && Arrays.binarySearch(updateCount2, 0) == -1) {
						conn.commit();
						System.out.println("Insert orderlist successfully");
						System.out.println("Insert customlist successfully");
						bool = true;
					} else {
						if (Arrays.binarySearch(updateCount, 0) != -1)
							System.out.println("Insert orderlist unsuccessfully");

						if (Arrays.binarySearch(updateCount2, 0) != -1)
							System.out.println("Insert customlist unsuccessfully");
					}

				}

			} else {
				System.out.println("Insert order unsuccessfully");
			}

		} catch (Exception e) {
			throw e;
		}

		return bool;
	}

	public boolean deleteOrder(Order order) throws Exception {
		boolean bool = false;
		String sql = "UPDATE `order` SET `delete` = '1', deletetime = ? WHERE `oid` = ?";

		try {
			Date now = new Date();
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String deletetime = sdFormat.format(now);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deletetime);
			pstmt.setLong(2, order.getOid());
			
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Delete order successfully");
				bool = true;
			} else {
				System.out.println("Delete order unsuccessfully");
			}
		} catch (Exception e) {
			throw e;
		}

		return bool;
	}

	public List<Order> TodayOrders() throws Exception {
		Date date = new Date();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		String startTime = sdFormat.format(date) + " 00:00:00";
		String endTime = sdFormat.format(date) + " 23:59:59";

		return getDayOrders(startTime, endTime);
	}

	public List<Order> DayOrders(Order order) throws Exception {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdFormat.parse(order.getCreatetime());
		String startTime = sdFormat.format(date) + " 00:00:00";
		String endTime = sdFormat.format(date) + " 23:59:59";

		return getDayOrders(startTime, endTime);
	}

	private List<Order> getDayOrders(String startTime, String endTime) throws Exception {
		List<Order> orders = new ArrayList<Order>();

		try {
			String sql = "SELECT * FROM `order` WHERE `delete` = '0' AND `createtime` BETWEEN ? AND ? ORDER BY `createtime` DESC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startTime);
			pstmt.setString(2, endTime);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Order order = new Order();
				order.setOid(rs.getLong("oid"));
				order.setDiscount(rs.getInt("discount"));
				order.setTotal(rs.getInt("total"));
				order.setCreatetime(rs.getString("createtime"));
				orders.add(order);
			}

		} catch (Exception e) {
			throw e;
		}

		return orders;
	}

	public List<ShowOrderList> ShowOrderLists(Order order) throws Exception {
		List<ShowOrderList> showOrderLists = new ArrayList<ShowOrderList>();

		try {
			String sql = "SELECT * FROM `orderlist` JOIN `meal` USING(`mid`) WHERE oid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, order.getOid());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ShowOrderList showOrderList = new ShowOrderList();
				showOrderList.setOid(rs.getLong("oid"));
				showOrderList.setMid(rs.getInt("mid"));
				showOrderList.setMeal(rs.getString("meal"));
				showOrderList.setPrice(rs.getInt("price"));
				showOrderList.setQuantity(rs.getInt("quantity"));
				showOrderLists.add(showOrderList);
			}
		} catch (Exception e) {
			throw e;
		}

		return showOrderLists;
	}

	public OverallInfo getOverallInfo(int year, int month) throws Exception {
		DateTimeUtil dtu = new DateTimeUtil();
		String start = dtu.getFistdayOfMonth(year, month);
		String end = dtu.getLastdayOfMonth(year, month);

		return overallInfo(start, end);
	}

	public OverallInfo getOverallInfo(int year, int month, int day) throws Exception {
		String date = year + "-" + month + "-" + day;
		String start = date + " 00:00:00";
		String end = date + " 23:59:59";

		return overallInfo(start, end);
	}

	public OverallInfo overallInfo(String start, String end) throws Exception {
		OverallInfo overallInfo = new OverallInfo();

		try {
			String sql = "SELECT SUM(`total`) AS `total`, SUM(`discount`) AS `discount` FROM `order` WHERE `delete` = '0' AND `createtime` BETWEEN ? AND ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, start);
			pstmt.setString(2, end);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				overallInfo.setTotal(rs.getInt("total"));
				overallInfo.setDiscount(rs.getInt("discount"));
			}

		} catch (Exception e) {
			throw e;
		}

		return overallInfo;
	}

	public List<ViewMeal> getDetailInfo(int year, int month) throws Exception {
		DateTimeUtil dtu = new DateTimeUtil();
		String start = dtu.getFistdayOfMonth(year, month);
		String end = dtu.getLastdayOfMonth(year, month);

		return DetailInfo(start, end);
	}

	public List<ViewMeal> getDetailInfo(int year, int month, int day) throws Exception {
		String date = year + "-" + month + "-" + day;
		String start = date + " 00:00:00";
		String end = date + " 23:59:59";

		return DetailInfo(start, end);
	}

	public List<ViewMeal> DetailInfo(String start, String end) throws Exception {
		List<ViewMeal> viewMeals = new ArrayList<ViewMeal>();

		try {
			String sql = "SELECT `mid`, `meal`, SUM(`quantity`) AS `number`, SUM(`price`*`quantity`) AS `amount`"
					+ "FROM `order` AS `o` JOIN `orderlist` USING(`oid`) JOIN `meal` USING(`mid`)"
					+ "WHERE `o`.`delete` = '0' AND `o`.`createtime` BETWEEN ? AND ? GROUP BY `mid`;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, start);
			pstmt.setString(2, end);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ViewMeal viewMeal = new ViewMeal();
				viewMeal.setMid(rs.getInt("mid"));
				viewMeal.setMeal(rs.getString("meal"));
				viewMeal.setNumber(rs.getInt("number"));
				viewMeal.setAmount(rs.getInt("amount"));
				viewMeals.add(viewMeal);
			}

		} catch (Exception e) {
			throw e;
		}

		return viewMeals;
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
