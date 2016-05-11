package com.phil.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.phil.dbc.DBconnection;
import com.phil.model.Head;
import com.phil.service.HeadService;

public class HeadAction extends ActionSupport implements ModelDriven<Head>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7156592067323697805L;
	private DBconnection dbc = null;
	private Head head = new Head();
	private List<Head> heads = new ArrayList<Head>();
	
	@Override
	public void prepare() {
		try {
			dbc = new DBconnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String execute() {
		HeadService headService = new HeadService(dbc.getConnection());
		
		try {
			setHeads(headService.showHeads());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {
			try {
				headService.closeConn();
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public String insert() {
		HeadService headService = new HeadService(dbc.getConnection());
		
		try {
			if (headService.insertHead(head)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {
			try {
				headService.closeConn();
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String delete() {
		HeadService headService = new HeadService(dbc.getConnection());
		
		try {
			if (headService.deleteHead(head)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {
			try {
				headService.closeConn();
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public List<Head> getHeads() {
		return heads;
	}

	public void setHeads(List<Head> heads) {
		this.heads = heads;
	}

	@Override
	public Head getModel() {
		return head;
	}

}
