package com.phil.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.phil.model.Custom;

public class CustomService {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public CustomService(Connection conn) {
		this.conn = conn;
	}

	public List<Custom> showCustoms() throws Exception {
		List<Custom> customs = new ArrayList<Custom>();
		String sql = "SELECT * FROM `custom`;";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Custom custom = new Custom();
				custom.setCid(rs.getInt("cid"));
				custom.setItem(rs.getString("item"));
				custom.setPrice(rs.getInt("price"));
				custom.setActive(rs.getInt("active"));
				custom.setCreatetime(rs.getString("createtime"));
				customs.add(custom);
			}

			return customs;
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean insertCustom(Custom custom) throws Exception {
		boolean bool = false;
		String sql = "INSERT INTO `custom` (`item`, `price`, `createtime`) VALUES(?, ?, ?);";

		try {
			Date now = new Date();
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, custom.getItem());
			pstmt.setInt(2, custom.getPrice());
			pstmt.setString(3, sdFormat.format(now));

			if (pstmt.executeUpdate() > 0) {
				bool = true;
				System.out.println("Insert custom successfully");
			} else {
				System.out.println("Insert custom unsuccessfully");
			}

		} catch (Exception e) {
			throw e;
		}

		return bool;
	}

	public boolean deleteCustom(Custom custom) throws Exception {
		boolean bool = false;
		String sql = "DELETE FROM `custom` WHERE `cid` = ?;";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custom.getCid());

			if (pstmt.executeUpdate() > 0) {
				bool = true;
				System.out.println("Delete custom successfully");
			} else {
				System.out.println("Delete custom unsuccessfully");
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
