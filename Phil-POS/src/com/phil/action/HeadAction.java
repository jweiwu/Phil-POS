package com.phil.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.phil.model.Head;
import com.phil.service.HeadService;

public class HeadAction extends ActionSupport implements ModelDriven<Head> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7156592067323697805L;
	private Head head = new Head();
	private List<Head> heads = new ArrayList<Head>();

	public String execute() {
		try {
			HeadService headService = new HeadService();
			setHeads(headService.showHeads());
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String insert() {
		try {
			HeadService headService = new HeadService();
			if (headService.insertHead(head)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
	}

	public String delete() {
		try {
			HeadService headService = new HeadService();
			if (headService.deleteHead(head)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
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
