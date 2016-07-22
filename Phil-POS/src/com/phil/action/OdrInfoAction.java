package com.phil.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.phil.dbc.DBconnection;
import com.phil.model.Order;
import com.phil.service.OrderService;
import com.phil.viewmodel.ShowOrderList;

public class OdrInfoAction extends ActionSupport implements ModelDriven<Order>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9098450876255590067L;
	private DBconnection dbc = null;
	private Order order = new Order();
	private List<Order> orders = new ArrayList<Order>();
	private List<ShowOrderList> showOrderLists = new ArrayList<ShowOrderList>();
	private Map<String, Object> dataMap = new HashMap<String, Object>();

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
	
	public String getOrderLists() {
		OrderService orderService = new OrderService(dbc.getConnection());
		
		try {
			setShowOrderLists(orderService.ShowOrderLists(order));
			dataMap.put("orderLists", showOrderLists);
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

	public List<ShowOrderList> getShowOrderLists() {
		return showOrderLists;
	}

	public void setShowOrderLists(List<ShowOrderList> showOrderLists) {
		this.showOrderLists = showOrderLists;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	@Override
	public Order getModel() {
		return order;
	}

}
