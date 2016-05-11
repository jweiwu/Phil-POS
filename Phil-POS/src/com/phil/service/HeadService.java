package com.phil.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.phil.model.Head;

public class HeadService {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public HeadService(Connection conn) {
		this.conn = conn;
	}

	public List<Head> showHeads() throws Exception {
		List<Head> heads = new ArrayList<Head>();
		String sql = "SELECT * FROM `head`;";

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Head head = new Head();
				head.setHid(rs.getInt("hid"));
				head.setItem(rs.getString("item"));
				head.setCreatetime(rs.getString("createtime"));
				heads.add(head);
			}

			return heads;
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean insertHead(Head head) throws Exception {
		boolean bool = false;
		String sql = "INSERT INTO `head` (`item`, `createtime`) VALUES(?, ?);";

		try {
			Date now = new Date();
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, head.getItem());
			pstmt.setString(2, sdFormat.format(now));

			if (pstmt.executeUpdate() > 0) {
				bool = true;
				System.out.println("Insert head successfully");
			} else {
				System.out.println("Insert head unsuccessfully");
			}

		} catch (Exception e) {
			throw e;
		}

		return bool;
	}

	public boolean deleteHead(Head head) throws Exception {
		boolean bool = false;
		String sql = "DELETE FROM `head` WHERE `hid` = ?;";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, head.getHid());

			if (pstmt.executeUpdate() > 0) {
				bool = true;
				System.out.println("Delete head successfully");
			} else {
				System.out.println("Delete head unsuccessfully");
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
