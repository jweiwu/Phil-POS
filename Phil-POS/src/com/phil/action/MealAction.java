package com.phil.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.phil.model.Meal;
import com.phil.service.MealService;
import com.phil.viewmodel.ShowMeal;

public class MealAction extends ActionSupport implements ModelDriven<Meal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8737605395967987479L;
	private Meal meal = new Meal();
	private List<ShowMeal> meals = new ArrayList<ShowMeal>();

	public String execute() {
		try {
			MealService mealService = new MealService();
			setMeals(mealService.showMeals());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
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

	@Override
	public Meal getModel() {
		return meal;
	}

}
