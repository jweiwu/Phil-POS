package com.phil.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.phil.model.CustomList;
import com.phil.model.Order;
import com.phil.model.OrderList;
import com.phil.viewmodel.ViewOrder;

public class OrderService {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public OrderService(Connection conn) {
		this.conn = conn;
	}

	// public List<Head> showHeads() throws Exception {
	// List<Head> heads = new ArrayList<Head>();
	// String sql = "SELECT * FROM `head`;";
	//
	// try {
	// pstmt = conn.prepareStatement(sql);
	// ResultSet rs = pstmt.executeQuery();
	//
	// while (rs.next()) {
	// Head head = new Head();
	// head.setHid(rs.getInt("hid"));
	// head.setItem(rs.getString("item"));
	// head.setCreatetime(rs.getString("createtime"));
	// heads.add(head);
	// }
	//
	// return heads;
	// } catch (Exception e) {
	// throw e;
	// }
	// }

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
						if (orderList.get(i) != null) {
							pstmt.setLong(1, order.getOid());
							pstmt.setInt(2, orderList.get(i).getMid());
							pstmt.setInt(3, orderList.get(i).getQuantity());
							pstmt.addBatch();
						}
					}

					for (int i = 0; i < customList.size(); i++) {
						if (customList.get(i) != null) {
							pstmt2.setLong(1, order.getOid());
							pstmt2.setInt(2, customList.get(i).getMid());
							pstmt2.setInt(3, customList.get(i).getCid());
							pstmt2.addBatch();
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

	// public boolean deleteHead(Head head) throws Exception {
	// boolean bool = false;
	// String sql = "DELETE FROM `head` WHERE `hid` = ?;";
	//
	// try {
	// pstmt = conn.prepareStatement(sql);
	// pstmt.setInt(1, head.getHid());
	//
	// if (pstmt.executeUpdate() > 0) {
	// bool = true;
	// System.out.println("Delete head successfully");
	// } else {
	// System.out.println("Delete head unsuccessfully");
	// }
	//
	// } catch (Exception e) {
	// throw e;
	// }
	//
	// return bool;
	// }

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
