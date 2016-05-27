package com.phil.viewmodel;

import java.util.List;

import com.phil.model.CustomList;
import com.phil.model.Order;
import com.phil.model.OrderList;

public class ViewOrder {
	Order order;
	List<OrderList> orderList;
	List<CustomList> customList;

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

	public List<CustomList> getCustomList() {
		return customList;
	}

	public void setCustomList(List<CustomList> customList) {
		this.customList = customList;
	}

}
