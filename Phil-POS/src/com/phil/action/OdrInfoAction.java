package com.phil.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.phil.dbc.DBconnection;
import com.phil.model.Order;
import com.phil.service.OrderService;

public class OdrInfoAction extends ActionSupport implements ModelDriven<Order>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9098450876255590067L;
	private DBconnection dbc = null;
	private Order order = new Order();
	private List<Order> orders = new ArrayList<Order>();

	@Override
	public void prepare() {
		try {
			dbc = new DBconnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getTodayOrders() {
		OrderService orderService = new OrderService(dbc.getConnection());
		
		try {
			setOrders(orderService.TodayOrders());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {
			try {
				orderService.closeConn();
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getDayOrders() {
		OrderService orderService = new OrderService(dbc.getConnection());
		
		try {
			setOrders(orderService.DayOrders(order));
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {
			try {
				orderService.closeConn();
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public Order getModel() {
		return order;
	}

}
