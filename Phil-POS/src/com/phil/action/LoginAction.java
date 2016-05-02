package com.phil.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.phil.model.Account;
import com.phil.service.AccountService;

public class LoginAction extends ActionSupport implements ModelDriven<Account> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account account = new Account();

	public String execute() {
		
		AccountService accountService = new AccountService();
		
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
