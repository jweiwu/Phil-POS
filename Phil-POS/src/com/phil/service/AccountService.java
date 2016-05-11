package com.phil.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.phil.model.Account;

public class AccountService {
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public AccountService(Connection conn) {
		this.conn = conn;
	}

	public boolean Login(Account account) throws Exception {
		boolean bool = false;
		String sql = "SELECT * FROM `account` WHERE `username` = ? AND `password` = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getUsername());
			pstmt.setString(2, account.getPassword());
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Account result = new Account();
				result.setAid(rs.getInt("aid"));
				result.setUsername(rs.getString("username"));
				result.setPassword(rs.getString("password"));
				result.setName(rs.getString("name"));
				result.setAuthority(rs.getInt("authority"));
				result.setCreatetime(rs.getString("createtime"));
				Map<String, Object> httpSession = ActionContext.getContext().getSession();
				httpSession.put("account", result);
				bool = true;
			}
			rs.close();

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
