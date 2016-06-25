package com.phil.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.phil.dbc.DBconnection;
import com.phil.model.Head;
import com.phil.model.Order;
import com.phil.model.OrderList;
import com.phil.service.HeadService;
import com.phil.service.MealService;
import com.phil.service.OrderService;
import com.phil.viewmodel.ViewOrder;

import com.phil.viewmodel.ShowMeal;

public class OrderAction extends ActionSupport implements ModelDriven<ViewOrder>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 530495108269371667L;
	private DBconnection dbc = null;
	private Order order = new Order();
	private List<OrderList> orderList = new ArrayList<OrderList>();
	private List<ShowMeal> meals = new ArrayList<ShowMeal>();
	private List<Head> heads = new ArrayList<Head>();
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private ViewOrder viewOrder = new ViewOrder();

	@Override
	public void prepare() {
		try {
			dbc = new DBconnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String execute() {
		MealService mealService = new MealService(dbc.getConnection());
		HeadService headService = new HeadService(dbc.getConnection());

		try {
			setMeals(mealService.showMeals());
			setHeads(headService.showHeads());
			dataMap.put("meals", meals);
			dataMap.put("heads", heads);

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {
			try {
				mealService.closeConn();
				headService.closeConn();
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}

	public String insert() {
		OrderService orderService = new OrderService(dbc.getConnection());
		// System.out.println(order.getDiscount());
		// System.out.println(orderList.size());

		// System.out.println(dataMap.size());
		// System.out.println(dataMap.keySet().toString());
		// viewOrder = (ViewOrder) dataMap;
		// System.out.println(String.valueOf(dataMap.get("order")));
		// return SUCCESS;
		try {
			if (orderService.insertOrder(viewOrder)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
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

	// public String delete() {
	// MealService mealService = new MealService(dbc.getConnection());
	//
	// try {
	// if (mealService.deleteMeal(meal)) {
	// return SUCCESS;
	// } else {
	// return ERROR;
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// return ERROR;
	// } finally {
	// try {
	// mealService.closeConn();
	// dbc.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// }

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderList> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderList> orderList) {
		this.orderList = orderList;
	}

	public List<ShowMeal> getMeals() {
		return meals;
	}

	public void setMeals(List<ShowMeal> meals) {
		this.meals = meals;
	}

	public List<Head> getHeads() {
		return heads;
	}

	public void setHeads(List<Head> heads) {
		this.heads = heads;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public ViewOrder getViewOrder() {
		return viewOrder;
	}

	public void setViewOrder(ViewOrder viewOrder) {
		this.viewOrder = viewOrder;
	}

	@Override
	public ViewOrder getModel() {
		return viewOrder;
	}
}
