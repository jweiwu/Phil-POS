package com.phil.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.phil.dbc.DBconnection;
import com.phil.model.Account;
import com.phil.service.AccountService;

public class LoginAction extends ActionSupport implements ModelDriven<Account>, Preparable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2697163463968653523L;
	private DBconnection dbc = null;
	private Account account = new Account();
	
	@Override
	public void prepare() {
		try {
			dbc = new DBconnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String execute() {
		
		AccountService accountService = new AccountService(dbc.getConnection());
		
		try {
			if (accountService.Login(account)) {
				return SUCCESS;
			} else {
				addActionError("Fail to login!");
				return ERROR;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Fail to login!");
			return ERROR;
		} finally {
			try {
				accountService.closeConn();
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public Account getModel() {
		return account;
	}
}
