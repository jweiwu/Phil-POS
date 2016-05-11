package com.phil.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.phil.dbc.DBconnection;
import com.phil.model.Custom;
import com.phil.service.CustomService;

public class CustomAction extends ActionSupport implements ModelDriven<Custom>, Preparable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5561247795639217065L;
	private DBconnection dbc = null;
	private Custom custom = new Custom();
	private List<Custom> customs = new ArrayList<Custom>();
	
	@Override
	public void prepare() {
		try {
			dbc = new DBconnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String execute() {
		CustomService customService = new CustomService(dbc.getConnection());
		
		try {
			setCustoms(customService.showCustoms());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {
			try {
				customService.closeConn();
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	
	public String insert() {
		CustomService customService = new CustomService(dbc.getConnection());
		
		try {
			if (customService.insertCustom(custom))  {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {
			try {
				customService.closeConn();
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String delete() {
		CustomService customService = new CustomService(dbc.getConnection());
		
		try {
			if (customService.deleteCustom(custom)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}finally {
			try {
				customService.closeConn();
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public List<Custom> getCustoms() {
		return customs;
	}

	public void setCustoms(List<Custom> customs) {
		this.customs = customs;
	}

	@Override
	public Custom getModel() {
		return custom;
	}

}
