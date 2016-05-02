package com.phil.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.phil.model.Account;

public class BossAuthInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8847668120530901673L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		Account account = (Account) session.get("account");

		if (account == null || account.getAuthority() != 0) {
//			Action.addActionError("Fail to login!");
			return Action.ERROR;
		} else {
			return invocation.invoke();
		}
	}

}
