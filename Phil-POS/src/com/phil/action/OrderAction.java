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
import com.phil.service.HeadService;
import com.phil.service.MealService;
import com.phil.viewmodel.ShowMeal;

public class OrderAction extends ActionSupport implements ModelDriven<List<Order>>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 530495108269371667L;
	private DBconnection dbc = null;
	private Order order = new Order();
	private List<ShowMeal> meals = new ArrayList<ShowMeal>();
	private List<Head> heads = new ArrayList<Head>();
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	private List<Order> orders = new ArrayList<Order>();

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

		System.out.println(orders.size());

		return SUCCESS;

		// MealService mealService = new MealService(dbc.getConnection());
		//
		// try {
		// if (mealService.insertMeal(meal)) {
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public List<Order> getModel() {
		return orders;
	}

}
