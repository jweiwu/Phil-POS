package com.phil.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.phil.model.Head;
import com.phil.model.Meal;
import com.phil.service.HeadService;
import com.phil.service.MealService;
import com.phil.viewmodel.ShowMeal;

public class MealAction extends ActionSupport implements ModelDriven<Meal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8737605395967987479L;
	private Meal meal = new Meal();
	private List<ShowMeal> meals = new ArrayList<ShowMeal>();
	private List<Head> heads = new ArrayList<Head>();

	public String execute() {
		try {
			MealService mealService = new MealService();
			HeadService headService = new HeadService();
			setMeals(mealService.showMeals());
			setHeads(headService.showHeads());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String insert() {
		try {
			MealService mealService = new MealService();
			if (mealService.insertMeals(meal))  {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String delete() {
		try {
			MealService mealService = new MealService();
			if (mealService.deleteMeal(meal)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
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
