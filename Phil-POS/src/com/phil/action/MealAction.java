package com.phil.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.phil.dbc.DBconnection;
import com.phil.model.Head;
import com.phil.model.Meal;
import com.phil.service.HeadService;
import com.phil.service.MealService;
import com.phil.viewmodel.ShowMeal;

public class MealAction extends ActionSupport implements ModelDriven<Meal>, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8737605395967987479L;
	private DBconnection dbc = null;
	private Meal meal = new Meal();
	private List<ShowMeal> meals = new ArrayList<ShowMeal>();
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
		MealService mealService = new MealService(dbc.getConnection());
		HeadService headService = new HeadService(dbc.getConnection());
		
		try {
			setMeals(mealService.showMeals());
			setHeads(headService.showHeads());
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
		MealService mealService = new MealService(dbc.getConnection());
		
		try {
			if (mealService.insertMeal(meal))  {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {
			try {
				mealService.closeConn();
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String delete() {
		MealService mealService = new MealService(dbc.getConnection());
		
		try {
			if (mealService.deleteMeal(meal)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}finally {
			try {
				mealService.closeConn();
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
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

	@Override
	public Meal getModel() {
		return meal;
	}

}
